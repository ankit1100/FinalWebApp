package com.dao;

import java.util.*;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.AccountType;
import com.bean.CategoryBean;
import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class AccountDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean addAccType(AccountType acctype) {
		List<AccountType> list = jdbcTemplate.query("select * from AccountType where accTypeName = ?", new BeanPropertyRowMapper<AccountType>(AccountType.class),acctype.getAccTypeName());
		if(list.size() == 0) {
			int result = jdbcTemplate.update("insert into AccountType (accTypeName) values (?)",acctype.getAccTypeName());
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public List<AccountBean> checkAccCreation(LoginBean user)  {
		List<AccountBean> list = jdbcTemplate.query("select accountName from account where userId=?", new BeanPropertyRowMapper<AccountBean>(AccountBean.class),user.getUserId());
		return list;
	}

	public boolean createAccount(AccountBean account, int userId, String accTypeName) {
		
		Date date = new Date();
		account.setCreatedAt(date);
		List<AccountType> list1 = jdbcTemplate.query("select * from AccountType", new BeanPropertyRowMapper<AccountType>(AccountType.class));
		for(AccountType accType : list1) {
			if(accType.getAccTypeName().equalsIgnoreCase(accTypeName)) {
				account.setAccountType(accType);
			}
		}
		
		System.out.println("Date at account creation time => "+date);
		int result2 = jdbcTemplate.update("insert into account (accountName,accountBalance,userId,accTypeId,createdAt) values (?,?,?,?,?)",account.getAccountName(),account.getAccountBalance(),userId,account.getAccountType().getAccTypeId(),account.getCreatedAt());
		if(result2 == 1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean createAccount1(AccountBean account, int userId, String accTypeName, String param_accountName) {
		Date date = new Date();
		account.setCreatedAt(date);
		System.out.println(param_accountName);
		List<AccountType> list1 = jdbcTemplate.query("select * from AccountType", new BeanPropertyRowMapper<AccountType>(AccountType.class));
		for(AccountType accType : list1) {
			if(accType.getAccTypeName().equalsIgnoreCase(accTypeName)) {
				account.setAccountType(accType);
			}
		}
		List<AccountBean> list2 = jdbcTemplate.query("select accountName from account where userId=?", new BeanPropertyRowMapper<AccountBean>(AccountBean.class),userId);
		
		System.out.println(list2);
		
		if(list2.size() == 0) {
			System.out.println("Date at account creation time => "+date);
			int result2 = jdbcTemplate.update("insert into account (accountName,accountBalance,userId,accTypeId,createdAt) values (?,?,?,?,?)",account.getAccountName(),account.getAccountBalance(),userId,account.getAccountType().getAccTypeId(),account.getCreatedAt());
			if(result2 == 1) {
				return true;
			}else {
				return false;
			}
		}else {
			for(int i=0;i<list2.size();i++) {
				System.out.println(list2.get(i)+" - "+param_accountName);
				if(!list2.get(i).getAccountName().equalsIgnoreCase(param_accountName)) {
					System.out.println(list2.get(i)+" - "+param_accountName);
					System.out.println("Date at account creation time => "+date);
					int result2 = jdbcTemplate.update("insert into account (accountName,accountBalance,userId,accTypeId,createdAt) values (?,?,?,?,?)",account.getAccountName(),account.getAccountBalance(),userId,account.getAccountType().getAccTypeId(),account.getCreatedAt());
					if(result2 == 1) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		return false;
	}

	public List<AccountType> getAccTypes() {
		List<AccountType> list = jdbcTemplate.query("select * from AccountType", new BeanPropertyRowMapper<AccountType>(AccountType.class));
//		System.out.println("Account type list from account dao=> "+list);
		return list;
	}
	
	public List<AccountBean> getAccounts(LoginBean user) {
		List<AccountBean> list = jdbcTemplate.query("select * from account where userId=?", new BeanPropertyRowMapper<AccountBean>(AccountBean.class),user.getUserId());
//		System.out.println("Account type list from account dao=> "+list);
		return list;
	}
}
