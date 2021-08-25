package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.AccountType;
import com.bean.CategoryBean;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.UserDao;
import com.dao.labelDao;
import com.dao.payeeDao;

@Controller
public class HomeController {
	
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
	
	
	@GetMapping("/userHome")
	public String UserHome(Model model,HttpSession session) {
		
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
		return "UserHome";
	}
	
	@PostMapping("/verifyUser")
	public String login(@Valid @ModelAttribute("validate") LoginBean loginuser, BindingResult result,
			@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,
			HttpServletRequest request, Model model, @RequestParam String message) {

		if (result.hasErrors()) {
			model.addAttribute("user", loginuser);
			return "login";
		} else {
			loginuser = dao.login(email, password);
			if (loginuser != null) {
				int i = loginuser.getUserId();
				System.out.println(i);
				if (i == 1) {
					message = "You are successfully logged in...";
					session = request.getSession();
					session.setAttribute("user", loginuser);
					model.addAttribute("message", message);
					model.addAttribute("validate5", new AccountBean());
					model.addAttribute("validate6", new CategoryBean());
					model.addAttribute("validate9", new LabelBean());
					model.addAttribute("validate10", new PayeeBean());
					model.addAttribute("validate12", new AccountType());
					return "AdminHome";
				} else {
					message = "You are successfully logged in...";
					session = request.getSession();
					int userId = loginuser.getUserId();
					System.out.println("Session Variable of userID after logged in =>" + userId);
					session.setAttribute("user", loginuser);
					model.addAttribute("message", message);
					model.addAttribute("validate5", new AccountBean());
					model.addAttribute("validate6", new CategoryBean());
					model.addAttribute("validate9", new LabelBean());
					model.addAttribute("validate10", new PayeeBean());
					List<AccountType> list = acc.getAccTypes();
					model.addAttribute("getAccTypes", list);
					return "UserHome";
				}
			} else {
				message = "This user is not valid!";
				model.addAttribute("message", message);
				return "login";
			}
		}

	}

}
