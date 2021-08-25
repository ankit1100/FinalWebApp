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
public class labelDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
		
	public boolean createLabels(LabelBean label, LoginBean user) {
		System.out.println("USerId from lables table => "+user.getUserId());
		
		List<LabelBean> list = jdbcTemplate.query("select labelId from labels where labelName = ? and userId = ?", new BeanPropertyRowMapper<LabelBean>(LabelBean.class),label.getLabelName(),user.getUserId());
		if(list.size() == 0) {
			int result = jdbcTemplate.update("insert into labels(labelName, userId) values (?, ?)",label.getLabelName(),user.getUserId());
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	public List<LabelBean> getAllLabels(LoginBean loginuser){
		List<LabelBean> list = jdbcTemplate.query("select * from labels where userId = ?", new BeanPropertyRowMapper<LabelBean>(LabelBean.class),loginuser.getUserId());
		return list;
	}

}
