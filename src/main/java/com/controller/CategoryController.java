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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.LabelBean;
import com.bean.LoginBean;
import com.bean.PayeeBean;
import com.bean.SubcategoryBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao cDao;
	
	@PostMapping("/categoryInsertion")
	public String CategoryInsertion(@Valid @ModelAttribute("validate6") CategoryBean category,BindingResult result, SubcategoryBean subCategory,HttpSession session,String message,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("category", category);
			
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			
			message = "Invalid input!";
			model.addAttribute("message", message);
			return "UserHome";
		}else {
			model.addAttribute("category", category);
			
			model.addAttribute("validate5", new AccountBean());
			model.addAttribute("validate6", new CategoryBean());
			model.addAttribute("validate9", new LabelBean());
			model.addAttribute("validate10", new PayeeBean());
			
			LoginBean user = (LoginBean) session.getAttribute("user");
			System.out.println("Session user id:"+user.getUserId());
			System.out.println("Sub-category Name => "+subCategory.getSubCatName());
			try {
				category = cDao.createCategory(category,user);
				System.out.println(category.getCategoryId());
				boolean flag2 = cDao.createSubCategory(subCategory,category,user);
				if(flag2) {
					System.out.println("Category and Sub-Category Insertion Successful...");
					message = "Category And Sub-Category Insertion Successful...";
					model.addAttribute("message", message);
				}else {
					System.out.println("Something is wrong...");
					message = "Something is wrong...";
					model.addAttribute("message", message);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "UserHome";
	}
	
	@GetMapping ("/manageCategories")
	public String ManageCategories (Model model, HttpSession session) {
		LoginBean user = (LoginBean) session.getAttribute("user");
		List<CategoryBean> list = cDao.getAllCategories(user);
		model.addAttribute("getAllCategories", list);
		return "ManageCategories";
	}
	@RequestMapping("/editCategory/{categoryId}")
	public String EditCategory(@PathVariable("categoryId") int categoryId,Model model, HttpSession session) {
		System.out.println("Category Id when edit button has clicked => "+categoryId);
		CategoryBean category = cDao.getAllCategoriesById(categoryId);
		System.out.println("Category id, name after getAllCategoriesById() called => "+category.getCategoryId()+" - "+category.getCategoryName());
		model.addAttribute("Category", category);
		return "UpdateCategory";
	}
	@GetMapping("/modifyCategory")
	public String ModifyCategory(CategoryBean category, Model model,String message,HttpSession session) {
		System.out.println("Category id and name from modifyCategory mapping =>"+category.getCategoryId()+" - "+category.getCategoryName());
		LoginBean user = (LoginBean) session.getAttribute("user");
		boolean flag= cDao.updateCategories(category);
		System.out.println("Result after updateCategory() function called => "+flag);
		if(flag) {
			message = "Category Updation Successfull...";
			System.out.println("flag true");
			model.addAttribute("message", message);
			System.out.println(message);
			List<CategoryBean> list = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list);
			return "ManageCategories";
		}else {
			System.out.println("flag false");
			message = "Category Updation Unsuccessfull...";
			System.out.println(message);
			model.addAttribute("message", message);
			List<CategoryBean> list = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list);
			return "ManageCategories";
		}
	}
	@GetMapping("/deleteCategory/{categoryId}")
	public String DeleteCategory(@PathVariable("categoryId") int categoryId,SubcategoryBean subCategory,Model model,String message,HttpSession session) {
		LoginBean user = (LoginBean) session.getAttribute("user");
		boolean flag = cDao.deleteCategoryById(categoryId,user);
		if(flag) {
			message = "Category Deletion Successfull...";
			model.addAttribute("message", message);
			List<CategoryBean> list = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list);
			return "ManageCategories";
		}else {
			message = "Category Deletion Unsuccessfull...";
			model.addAttribute("message", message);
			List<CategoryBean> list = cDao.getAllCategories(user);
			model.addAttribute("getAllCategories", list);
			return "ManageCategories";
		}
	}
	
}
