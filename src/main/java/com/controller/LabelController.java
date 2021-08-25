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
import com.dao.labelDao;

@Controller
public class LabelController {
	@Autowired
	labelDao lDao;
	
	@PostMapping("/labelInsertion")
	public String LabelInsertion(@Valid @ModelAttribute("validate9") LabelBean label,BindingResult result,String message,CategoryBean cbean, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("label", label);
			message = "Invalid Input!";
			model.addAttribute("message", message);
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			return "UserHome";
		}else {
			
			model.addAttribute("label", label);
			LoginBean user = (LoginBean) session.getAttribute("user");
			System.out.println("Session User ID From controller when insert the label => "+user.getUserId());
			try {
				boolean flag = lDao.createLabels(label,user);
				if(flag) {
					message = "One label has inserted successfully...";
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
