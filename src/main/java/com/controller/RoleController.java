package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.RoleBean;
import com.dao.RoleDao;

@Controller
public class RoleController {
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public String roleAddition(Model model) {
		model.addAttribute("validate1", new RoleBean());
		return "createRole";
	}

	@PostMapping("/insertRole")
	public String InsertRole(@Valid @ModelAttribute("validate1") RoleBean role, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("role", role);
			return "createRole";
		} else {
			roleDao.insertRole(role);
			System.out.println("Role has added...");
			return "viewRole";
		}
	}
	
	@GetMapping("/roles")
	public String listAllUsers(Model model) {
		model.addAttribute("roles", roleDao.getRoles());
		System.out.println("All users are viewed...");
		return "viewRole";
	}

//	@PostMapping("/entry")
//	public String entryUser(RoleBean role,UserBean user, Model model) {
//		System.out.println(user.getrId());
//		System.out.println(role.getRoleName());
//		if (role.getRoleName().equalsIgnoreCase("Admin")) {
//			return "login";
//		}else {
//			boolean flag = dao.checkUser(user);
//			if (flag) {
//				model.addAttribute("roleBean", role);
//				return "login";
//			}else {
//				model.addAttribute("roleBean", role);
//				return "UserSignup";
//			}
//		}
//	}

//	@GetMapping("/edit/{roleId}")
//	public String editById(@PathVariable("roleId") int roleId, Model model) {
//		RoleBean role = roleDao.getRoleById(roleId);
//		return "updateRole";
//	}
//
//	@GetMapping("/delete/{roleId}")
//	public String deleteById(@PathVariable("roleId") int roleId) {
//		Boolean bool = roleDao.deleteRoles(roleId);
//		System.out.println("Role has deleted...");
//		return "redirect:/roles";
//	}

//	@PostMapping("/updateRole")
//	public String updateRole(RoleBean role, Model model) {
//
//		model.addAttribute("role", role);
//		boolean flag = roleDao.updateRoles(role);
//		if (flag) {
//			System.out.println("role has updated...");
//			System.out.println(role.getRoleName());
//			return "redirect:/roles";
//		} else {
//			System.out.println("Something wrong!");
//			System.out.println(role.getRoleName());
//			return "updateRole";
//		}
//
//	}

}
