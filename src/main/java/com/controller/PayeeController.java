package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.dao.payeeDao;

@Controller
public class PayeeController {
	@Autowired
	payeeDao pDao;
	
	@PostMapping("/payeeInsertion")
	public String PayeeInsertion(@Valid @ModelAttribute("validate10") PayeeBean payee,BindingResult result,String message,Model model, HttpSession session) {
		if(result.hasErrors()) {
			message = "Invalid Input!";
			model.addAttribute("message", message);
			model.addAttribute("payee", payee);
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			return "UserHome";
		}else {
			
			model.addAttribute("payee", payee);
			System.out.println("PayeeName = "+payee.getPayeeName());
			LoginBean user = (LoginBean) session.getAttribute("user");
			System.out.println("Session User ID From controller when insert the payee => "+user.getUserId());
			try {
				boolean flag = pDao.createPayees(payee,user);
				if(flag) {
					message = "One payee has inserted successfully...";
					model.addAttribute("message", message);
				}else {
					message = "Something is wrong...";
					model.addAttribute("message", message);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			return "UserHome";
		}
	}
}
