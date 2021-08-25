package com.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.AccountBean;
import com.bean.AccountType;
import com.bean.CategoryBean;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.UserDao;
import com.dao.labelDao;
import com.dao.payeeDao;
import com.ser.MailSend;

@Controller
class UserController {

	@Autowired
	CategoryDao cDao;
	
	@Autowired
	labelDao lDao;
	
	@Autowired
	payeeDao pDao;
	
	@Autowired
	AccountDao acc;
	
	@Autowired
	UserDao dao;
	
	@GetMapping("/checkemail/{email}")
	@ResponseBody
	public boolean checkEmail(@PathVariable("email") String email) {
		boolean result = dao.checkEmailDuplication(email);
		return result;
	}
	@GetMapping("/checkphone/{phone}")
	@ResponseBody
	public boolean checkPhone(@PathVariable("phone") String phone) {
		boolean result = dao.checkPhoneDuplication(phone);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("validate", new LoginBean());
//		List<RoleBean> listRole = roleDao.getRoles();
//		System.out.println(listRole.get(1).getRoleName());
//		model.addAttribute("roles", listRole);
		return "login";
	}

	@GetMapping("/adminLogout")
	public String adminSignout(HttpSession session, @Valid @ModelAttribute("validate") UserBean user,
			BindingResult result) {
		session.invalidate();
		System.out.println("Session Destroyed!");
		System.out.println("Your are logged out from our site!");
		return "login";
	}
	@GetMapping("/loginPage")
	public String moveToLoginPage(Model model, HttpSession session) {
		model.addAttribute("validate", new LoginBean());
		session.invalidate();
		return "login";
	}
	@GetMapping("/adminHome")
	public String AdminHome(Model model,HttpSession session){
		LoginBean user = (LoginBean) session.getAttribute("user");
		
		List<CategoryBean> list2 = cDao.getAllCategories(user);
		model.addAttribute("getAllCategories", list2);
		
		List<AccountType> list = acc.getAccTypes();
		model.addAttribute("getAccTypes", list);
		
		List<LabelBean> list4 = lDao.getAllLabels(user);
		model.addAttribute("getAllLabels", list4);
		
		List<PayeeBean> list3 = pDao.getAllPayees(user);
		model.addAttribute("getAllPayees", list3);
		
		List<AccountBean> list5 = acc.getAccounts(user);
		model.addAttribute("getAccounts", list5);
		
		model.addAttribute("validate5", new AccountBean());
		model.addAttribute("validate6", new CategoryBean());
		model.addAttribute("validate9", new LabelBean());
		model.addAttribute("validate10", new PayeeBean());
		model.addAttribute("validate12", new AccountType());
		return "AdminHome";
	}

	@GetMapping("/userLogout")
	public String userSignout(HttpSession session, @Valid @ModelAttribute("validate") UserBean user,
			BindingResult result) {
		session.invalidate();
		System.out.println("Session Destroyed!");
		System.out.println("Your are logged out from our site!");
		return "login";
	}

	@RequestMapping(value = "viewData")
	public String getUserData(Model model) {
		model.addAttribute("showdata", dao.showData());
		return "userData";
	}

	@GetMapping("/moveToRegister")
	public String signUp(Model model) {
		model.addAttribute("validate3", new UserBean());
		return "UserSignup";
	}

	@PostMapping("/saveUser")
	public String signup(@Valid @ModelAttribute("validate3") UserBean user, BindingResult result, RoleBean role, Model model, String message) {
		System.out.println("Binding Result=> " + result);
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "UserSignup";
		} else {
			// String filename= service.fileUpload(file);
			// user.setProfilePic(filename);
			role.setRoleId(2);
			user.setRole(role);
			int rId = user.getRole().getRoleId();
			System.out.println("Role ID:" + rId);
			List<UserBean> list = dao.checkExistingUserData(user);
			System.out.println(list.size());
			if(list.size()==1) {
				model.addAttribute("user", user);
				model.addAttribute("validate", user);
				message = "Invalid Action!";
				model.addAttribute("message", message);
				return "UserSignup";
			}else {
				model.addAttribute("user", user);
				model.addAttribute("validate", user);
				dao.insert(user);
				return "login";
			}
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id, Model model) {
		int i = dao.delete(id);
		if (i != 0) {
			model.addAttribute("showdata", dao.showData());
			return "userData";
		}
		return "userData";

	}

	@GetMapping(value = "/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {

		UserBean bean = dao.getDataById(id);
		model.addAttribute("user", bean);
		return "updateUser";
	}

	@PostMapping("/editUser")
	public String EditUser(UserBean user, Model model) {
		System.out.println(user.getEmail());
		int i = dao.updateUser(user);
		System.out.println(i);
		return "redirect:/viewData";
	}

	@GetMapping("/forgotpassword")
	public String forgot() {
		return "Email";
	}

	@GetMapping("/submit")
	public String demoSubmit(@RequestParam String username) {
		System.out.println("User Name:" + username);
		return "redirect:/adminHome";
	}

	@GetMapping("/email")
	public String email(@RequestParam("email") String email, Model model, HttpSession session) {
		if (email != "") {
			int int_otp = generateOTP();
			MailSend.mail(email, int_otp);
			session.setAttribute("email", email);
			return "otp";

		} else {
			return "Email";
		}
	}

	public static int generateOTP() {
		int lengthOtp = 6;
		char OTPValue[] = new char[lengthOtp];
		String allDigits = "1234567890";
		Random randomObj = new Random();
		for (int i = 0; i < lengthOtp; i++) {
			int randomNo = randomObj.nextInt(allDigits.length());
			OTPValue[i] = allDigits.charAt(randomNo);
		}
		String otp = new String(OTPValue);
		int int_otp = Integer.parseInt(otp);
		return int_otp;
	}

	@GetMapping("/newPassword")
	public String updatePass(@RequestParam("otp") String otp, Model model, HttpSession session) {
		String eotp = (String) session.getAttribute("eotp");
		if (eotp.equals(otp)) {
			return "forgot";
		}
		return "otp";
	}
	
}