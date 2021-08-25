package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertRole(RoleBean role) {
		jdbcTemplate.update("insert into roles (roleName) values (?)",role.getRoleName());
	}
	public List<RoleBean> getRoles() {
		List<RoleBean> roleList = jdbcTemplate.query("select * from roles", new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roleList;
	}

	public RoleBean getRoleById(int roleId) {
		return jdbcTemplate.queryForObject("select * from roles where roleId =?",new Object[] {roleId},new BeanPropertyRowMapper<RoleBean>(RoleBean.class)) ;
	}
	public boolean updateRoles(RoleBean role) {
		jdbcTemplate.update("update roles set roleName=? where roleId=?",role.getRoleName(),role.getRoleId());
		return false;
	}
	public boolean deleteRoles(int roleId) {
		jdbcTemplate.update("delete from roles where roleId=?",roleId);
		return false;
	}

}
