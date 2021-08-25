package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.Expense;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;

@Repository
public class ExpenseDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean createExpense(Expense ex, CategoryBean category, PayeeBean payee, LabelBean label, LoginBean loginuser, AccountBean account) {
		
		category = jdbcTemplate.queryForObject("select categoryId from category where categoryName=? and userId = ?", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),category.getCategoryName(),loginuser.getUserId());
		int cat_Id = category.getCategoryId();
		
		payee = jdbcTemplate.queryForObject("select payeeId from payees where payeeName = ? and userId = ?", new BeanPropertyRowMapper<PayeeBean>(PayeeBean.class), payee.getPayeeName(),loginuser.getUserId());
		int p_Id = payee.getPayeeId();
		
		label = jdbcTemplate.queryForObject("select labelId from labels where labelName = ? and userId = ?", new BeanPropertyRowMapper<LabelBean>(LabelBean.class), label.getLabelName(),loginuser.getUserId());
		int l_Id = label.getLabelId();
		
		account = jdbcTemplate.queryForObject("select accountBalance from account where accountName = ? and userId = ?", new BeanPropertyRowMapper<AccountBean>(AccountBean.class),ex.getAccName(),loginuser.getUserId());
		float acc_balance = account.getAccountBalance();
		
		int u_Id = loginuser.getUserId();
		
		
		int result1 = jdbcTemplate.update("insert into expense (amount, ExpDateTime, status, description, accName, paymentMethod, input_subCategory, catId, pId, lId, userId) values (?,?,?,?,?,?,?,?,?,?,?)",ex.getAmount(),ex.getExpDateTime(),ex.getStatus(),ex.getDescription(),ex.getAccName(),ex.getPaymentMethod(),ex.getInput_subCategory(),cat_Id,p_Id,l_Id,u_Id);
		if(result1 == 1) {
			float e_amount = ex.getAmount();
			System.out.println("Account Balance => "+acc_balance+", Expense Amount => "+e_amount);
			acc_balance = acc_balance - e_amount;
			System.out.println("Account Balance => "+acc_balance+", Expense Amount => "+e_amount);
			int result2 = jdbcTemplate.update("update account set accountBalance = ? where accountName = ? and userId = ?",acc_balance,ex.getAccName(),u_Id);
			if(result2 == 1) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public List<Object> getAllProperties(LoginBean user){
		
		List<Object> list1 = new ArrayList<Object>();
		List<Expense> list2 = jdbcTemplate.query("select * from expense where userId=?", new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
		list1.add(list2);
		List<CategoryBean> list3 = jdbcTemplate.query("select c.categoryName from expense e inner join category c on e.catId = c.categoryId where e.userId=?", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),user.getUserId());
		list1.add(list3);
		List<PayeeBean> list4 = jdbcTemplate.query("select p.payeeName from expense e inner join payees p on e.pId = p.payeeId where e.userId=?", new BeanPropertyRowMapper<PayeeBean>(PayeeBean.class),user.getUserId());
		list1.add(list4);
		List<LabelBean> list5 = jdbcTemplate.query("select l.labelName from expense e inner join labels l on e.lId = l.labelId where e.userId=?", new BeanPropertyRowMapper<LabelBean>(LabelBean.class),user.getUserId());
		list1.add(list5);
		System.out.println("A list containing expense, category, payee and label records based on a login user from ExpenseDao => "+list1);
		return list1;
		
//		ex = jdbcTemplate.queryForObject("select * from expense where userId=?",new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
//		List<Expense> list = jdbcTemplate.query("select * from expense where userId=?",new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
//		return list;
	}
	public List<Expense> getExpensesByMonth(LoginBean user){
//		List<Expense> ex = jdbcTemplate.query("select ExpDateTime, amount from expense where userId=?", new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
		List<Expense> list = jdbcTemplate.query("SELECT DATEPART(MONTH, ExpDateTime) as months,sum(amount) as amount from expense where userId=? group by DATEPART(MONTH, ExpDateTime),DATEPART(YEAR, ExpDateTime)",new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
		System.out.println("no of months along with expense amount => "+list.size());
		if(list.size() != 0) {
			System.out.println(list);
			return list;
		}else {
			System.out.println(list);
			return null;
		}
	}
	public List<Expense> getExpensesByYear(LoginBean user){
//		List<Expense> ex = jdbcTemplate.query("select ExpDateTime, amount from expense where userId=?", new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
		List<Expense> list = jdbcTemplate.query("SELECT DATEPART(YEAR, ExpDateTime) as years,sum(amount) as amount from expense where userId=? group by DATEPART(YEAR, ExpDateTime)",new BeanPropertyRowMapper<Expense>(Expense.class),user.getUserId());
		System.out.println("no of years along with expense amount => "+list.size());
		if(list.size() != 0) {
			System.out.println(list);
			return list;
		}else {
			System.out.println(list);
			return null;
		}
	}
//	public list<Expense> getAmountByYear(LoginBean user){
//		
//	}
//	
//	public list<Expense> getAmountByMonth(LoginBean user){
//		
//	}
}
