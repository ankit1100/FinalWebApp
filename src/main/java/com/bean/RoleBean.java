	package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class RoleBean {
	int roleId;
	
	@NotBlank(message = "Please enter the valid role name!")
	String roleName;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
