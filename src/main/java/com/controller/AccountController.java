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
import com.bean.Expense;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;
import com.dao.labelDao;
import com.dao.payeeDao;

@Controller
public class AccountController {


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
	
	@GetMapping("/moveToInsertAcc")
	public String moveToInsertAcc(Model model) {

		model.addAttribute("validate4", new AccountType());
		return "AddAccountType";
	}

	@PostMapping("/insertAccType")
	public String insertAccType(@Valid @ModelAttribute("validate4") AccountType accType, BindingResult result,
			Model model, String message, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("accType", accType);
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			model.addAttribute("validate12", new AccountType());
			return "AdminHome";
		} else {
			model.addAttribute("accType", accType);
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			model.addAttribute("validate12", new AccountType());
			boolean flag = acc.addAccType(accType);
			if(flag) {
				message = "Account type has inserted...";
				model.addAttribute("message", message);
				System.out.println("Account type has inserted...");
				return "AdminHome";
			}else {
				message = "Something is wrong...";
				model.addAttribute("message", message);
				System.out.println("something is wrong...");
				return "AdminHome";
			}
		}
	}
	@PostMapping("/createAcc")
	public String CreateAcc(@Valid @ModelAttribute("validate5") AccountBean account, BindingResult result,
			@RequestParam String accTypeName, Model model, String message, HttpSession session, HttpServletRequest request) {
		
		boolean bool = false;
		System.out.println("Create Account Method Called...");
		System.out.println(account);
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("account", account);
			List<AccountType> list = acc.getAccTypes();
			model.addAttribute("getAccTypes", list);
			return "AccountCreation";
		}else {
			System.out.println("Validation successfull...");
			List<AccountType> list = acc.getAccTypes();
			System.out.println("Account Type list=> "+list);
			model.addAttribute("getAccTypes", list);
			model.addAttribute("account", account);
			LoginBean user = (LoginBean) session.getAttribute("user");
			System.out.println("User Session Object => " + user);
			int userId = user.getUserId();
			System.out.println("User ID from account..."+userId);
			bool = acc.createAccount(account, userId, accTypeName);
			System.out.println("bool value =>"+bool);
			if(bool == true) {
				System.out.println("Account has created successfully");
				message = "Your account has created successfully...";
				model.addAttribute("message", message);
				return "AccountCreation";
			}else {
				System.out.println("Something Wrong!");
				message = "Something Wrong!";
				model.addAttribute("message", message);
				return "AccountCreation";
			}
		}
	}
	@GetMapping("/checkAccStatus")
	public String CheckAccStatus(AccountBean account, String message, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {
		
		LoginBean user = (LoginBean) session.getAttribute("user");
		System.out.println("Method called..."+user.getUserId());
			List<AccountBean> list1 = acc.checkAccCreation(user);
			System.out.println(user.getUserId());
			if (list1.size()>=1) {
				message = "You already have an account!";
				System.out.println(message);
				model.addAttribute("validate8", new Expense());
				model.addAttribute("validate6", new CategoryBean());
				
				List<AccountType> list2 = acc.getAccTypes();
				model.addAttribute("getAccTypes", list2);
				
				List<CategoryBean> list3 = cDao.getAllCategories(user);
				model.addAttribute("getAllCategories", list3);
				
				List<AccountBean> list5 = acc.getAccounts(user);
				model.addAttribute("getAccounts", list5);
				
				List<LabelBean> list4 = lDao.getAllLabels(user);
				model.addAttribute("getAllLabels", list4);
				System.out.println("Label Records: "+list4);
				
				List<PayeeBean> list6 = pDao.getAllPayees(user);
				model.addAttribute("getAllPayees", list6);
				
				return "ExpenseCreation";
			}else {
				message = "You don't have any account, please firstly create one!";
				System.out.println(message);
				model.addAttribute("validate5", new AccountBean());
				List<AccountType> list = acc.getAccTypes();
				model.addAttribute("getAccTypes", list);
				return "AccountCreation";
			}
	}
	
	@PostMapping("/insertAccounts")
	public String InsertAccounts(@Valid @ModelAttribute("validate5") AccountBean account, BindingResult result, @RequestParam("accTypeName") String accTypeName, @RequestParam("accountName") String param_accountName, Model model, HttpSession session, String message) {
		boolean flag = false;
		if(result.hasErrors()) {
			List<AccountType> list = acc.getAccTypes();
			model.addAttribute("getAccTypes", list);
			model.addAttribute("account", account);
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			return "UserHome";
		}else {
			List<AccountType> list = acc.getAccTypes();
			model.addAttribute("getAccTypes", list);
			model.addAttribute("account", account);
			LoginBean user = (LoginBean) session.getAttribute("user");
			System.out.println("User Session Object => " + user);
			System.out.println("User ID from account..."+user.getUserId());
			System.out.println(param_accountName);
			flag = acc.createAccount1(account, user.getUserId(), accTypeName,param_accountName);
			System.out.println("Account Insertion Result in boolean =>"+flag);
				if(flag == true) {
					System.out.println("Account has created successfully");
					message = "Your account has created successfully...";
					model.addAttribute("message", message);
					model.addAttribute("validate5", new AccountBean());
					model.addAttribute("validate6", new CategoryBean());
					model.addAttribute("validate9", new LabelBean());
					model.addAttribute("validate10", new PayeeBean());
					return "UserHome";
				}else {
					System.out.println("Invalid Action!");
					message = "Invalid Action!";
					model.addAttribute("message", message);
					model.addAttribute("validate5", new AccountBean());
					model.addAttribute("validate6", new CategoryBean());
					model.addAttribute("validate9", new LabelBean());
					model.addAttribute("validate10", new PayeeBean());
					return "UserHome";
				}
		}
	}
}
