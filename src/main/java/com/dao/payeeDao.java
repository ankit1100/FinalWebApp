package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;

@Repository
public class payeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
		
	public boolean createPayees(PayeeBean payee, LoginBean user) {
		int uId = user.getUserId();
		System.out.println("UserId from payees table => "+uId);
		
		List<PayeeBean> list = jdbcTemplate.query("select payeeName from payees where payeeName = ? and userId = ?", new BeanPropertyRowMapper<PayeeBean>(PayeeBean.class),payee.getPayeeName(),user.getUserId());
		if(list.size() == 0) {
			int result = jdbcTemplate.update("insert into payees(payeeName, userId) values (?, ?)",payee.getPayeeName(),uId);
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public List<PayeeBean> getAllPayees(LoginBean loginuser){
		int userId = loginuser.getUserId();
		List<PayeeBean> list = jdbcTemplate.query("select * from payees where userId = ?", new BeanPropertyRowMapper<PayeeBean>(PayeeBean.class),userId);
		return list;
	}
}
