package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AccountBean;
import com.bean.AccountType;
import com.bean.CategoryBean;
import com.bean.Expense;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;
import com.dao.UserDao;
import com.dao.labelDao;
import com.dao.payeeDao;

@Controller
public class ExpenseController {
	
	@Autowired
	AccountDao acc;
	
	@Autowired
	CategoryDao cDao;
	
	@Autowired
	labelDao lDao;
	
	@Autowired
	payeeDao pDao;
	
	@Autowired
	ExpenseDao eDao;
	
	@Autowired
	UserDao dao;
	
	@PostMapping("/ExpenceTracking")
	public String ExpenseTracking(@Valid @ModelAttribute("validate8") Expense ex, BindingResult result, Model model, CategoryBean category,LabelBean label,PayeeBean payee,AccountBean account, HttpSession session,String message) {
		if(result.hasErrors()) {
			LoginBean user = (LoginBean) session.getAttribute("user");
			model.addAttribute("expense", ex);
			
			List<AccountType> list = acc.getAccTypes();
			model.addAttribute("getAccTypes", list);
			
			List<LabelBean> list4 = lDao.getAllLabels(user);
			model.addAttribute("getAllLabels", list4);
			
			List<PayeeBean> list3 = pDao.getAllPayees(user);
			model.addAttribute("getAllPayees", list3);
			
			List<AccountBean> list5 = acc.getAccounts(user);
			model.addAttribute("getAccounts", list5);
			
			List<CategoryBean> list2 = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list2);
			
			return "ExpenseCreation";
		}else {
			LoginBean user = (LoginBean) session.getAttribute("user");
			model.addAttribute("expense", ex);
			
			List<AccountType> list = acc.getAccTypes();
			model.addAttribute("getAccTypes", list);
			
			List<LabelBean> list4 = lDao.getAllLabels(user);
			model.addAttribute("getAllLabels", list4);
			
			List<PayeeBean> list3 = pDao.getAllPayees(user);
			model.addAttribute("getAllPayees", list3);
			
			List<AccountBean> list5 = acc.getAccounts(user);
			model.addAttribute("getAccounts", list5);
			
			List<CategoryBean> list2 = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list2);
			
			boolean flag = false;
			try {
				flag = eDao.createExpense(ex,category,payee,label,user,account);
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(flag) {
				message = "Your expense has added successfully...";
				model.addAttribute("EMessage", message);
			}else {
				message = "Sorry try again later!";
				model.addAttribute("EMessage", message);
			}
			return "ExpenseCreation";
		}
	}
	
	@GetMapping("/PDFGeneration")
	public String PDFGeneration(Model model, HttpSession session,UserBean uBean) {
		LoginBean user = (LoginBean) session.getAttribute("user");
		int uId = user.getUserId();
		uBean = dao.getDataById(uId);
		model.addAttribute("uBean", uBean);
		List<Expense> list1 = eDao.getExpensesByMonth(user);
		List<Expense> list2 = eDao.getExpensesByYear(user);
		model.addAttribute("getExpensesByMonth", list1);
		model.addAttribute("getExpensesByYear", list2);
		return "PDFGeneration";
	}
	@GetMapping("/moveToReportGeneration")
	public String MoveToReportGeneration() {
		return "PDFGeneration";
	}

	@GetMapping("/manageExpenses")
	public String ManageExpenses(Model model,HttpSession session,String message,Expense ex,CategoryBean category,LabelBean label,PayeeBean payee){
		LoginBean user = (LoginBean) session.getAttribute("user");
		
		List<Object> list = eDao.getAllProperties(user);
		System.out.println("A list containing expense, category, payee and label records based on a login user from controller => "+list);
		System.out.println("List Size => "+list.size());
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			model.addAttribute("getAllProperties",list.get(i));
		}
//		model.addAttribute("getAllExpenses", list);
		return "ExpenseTracking";
	}
}
