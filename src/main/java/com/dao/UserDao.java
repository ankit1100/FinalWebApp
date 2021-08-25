package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	ArrayList<UserBean> list = new ArrayList<UserBean>();
	
	public LoginBean login(String email, String password) {
		
	 List<LoginBean> bean=  jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<LoginBean>(LoginBean.class));
	 for (LoginBean userBean : bean) {
		if(userBean.getEmail().equals(email) && userBean.getPassword().equals(password)) {
			return userBean;
		}
	 }
		return null;
	}

	public List<UserBean> showData() {
		List<UserBean> users = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}
	
	public int delete(int id) {
		
		int row = jdbcTemplate.update("delete from users where userId=?",id);
		System.out.println(row);
		return row;
	}
	
	public UserBean getDataById(int id) {
//		=  jdbcTemplate.update("select * from user where id=?",id);
		
		return jdbcTemplate.queryForObject("select * from users where userId =?",new Object[] {id},new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	
	public int updateUser(UserBean user) {
		int i= jdbcTemplate.update("update users set firstName=?,phone=?,gender=?,email=?,password=? where userId=?", user.getFirstName(),user.getPhone(),user.getGender(),user.getEmail(),user.getPassword(),user.getUserId());
		return i;
	} 
	
	public void insert(UserBean user) {
		System.out.println("Role Id from users table => "+user.getRole().getRoleId());
		jdbcTemplate.update("insert into users(firstName,phone,gender,email,password,roleId) values (?,?,?,?,?,?)",user.getFirstName(),user.getPhone(),user.getGender(),user.getEmail(),user.getPassword(),user.getRole().getRoleId());
		
	}
	public List<UserBean> checkExistingUserData(UserBean user){
		List<UserBean> list = jdbcTemplate.query("select * from users where firstName=? and email=?",  new BeanPropertyRowMapper<UserBean>(UserBean.class),user.getFirstName(),user.getEmail());
		return list;
	}

	public boolean checkEmailDuplication(String email) {
		List<UserBean> list = jdbcTemplate.query("select * from users,roles where email like ? and roles.roleId = users.roleId", new BeanPropertyRowMapper<UserBean>(UserBean.class),email);
		System.out.println("Email From userBean => "+list.size());
		
		if(list.size() == 0) {
			return false;
		}else {
			return true;
		}
		
	}
	public boolean checkPhoneDuplication(String phone) {
		List<UserBean> list = jdbcTemplate.query("select * from users, roles where phone like ? and roles.roleId = users.roleId", new BeanPropertyRowMapper<UserBean>(UserBean.class),phone);
		System.out.println("Phone From userBean => "+list.size());
		
		if(list.size() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
}
