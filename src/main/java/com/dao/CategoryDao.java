package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.Expense;
import com.bean.LoginBean;
import com.bean.SubcategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public CategoryBean createCategory(CategoryBean category, LoginBean user) throws Exception{
		
		List<CategoryBean> list = jdbcTemplate.query("select categoryName from category where categoryName=? and  userId=?", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),category.getCategoryName(),user.getUserId());
		if(list.size() == 0) {
			System.out.println("USer ID From Category Dao => "+user.getUserId());
			System.out.println("Category Name from dao => "+category.getCategoryName());
			jdbcTemplate.update("insert into category (categoryName, userId) values (?,?)",category.getCategoryName(),user.getUserId());
			
		}
		category = jdbcTemplate.queryForObject("select categoryId from category where categoryName=? and userId=?", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),category.getCategoryName(),user.getUserId());
		System.out.println("CategoryId is "+category.getCategoryId());
		return category;
		
	}

	public boolean createSubCategory(SubcategoryBean subCategory, CategoryBean category,LoginBean user) {
		List<SubcategoryBean> list1 = jdbcTemplate.query("select subCatName from subCategory where subCatName = ? and userId=?", new BeanPropertyRowMapper<SubcategoryBean>(SubcategoryBean.class), subCategory.getSubCatName(),user.getUserId());
		
		if(list1.size() == 0) {
			int result = jdbcTemplate.update("insert into subCategory (subCatName,categoryId,userId) values (?,?,?)",subCategory.getSubCatName(),category.getCategoryId(),user.getUserId());
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
		
	public List<CategoryBean> getAllCategories(LoginBean loginuser){
		List<CategoryBean> list = jdbcTemplate.query("select * from category where userId = ?", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),loginuser.getUserId());
		return list;
	}
	public CategoryBean getAllCategoriesById(int categoryId) {
		return  jdbcTemplate.queryForObject("select * from category where categoryId = ?",new Object[]{categoryId},new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class));
	}
	public boolean deleteCategoryById(int catId, LoginBean loginuser) {
		System.out.println("Category Id before delete query => "+catId);
		List<Expense> list = jdbcTemplate.query("select * from expense where catId=? and userId=?", new BeanPropertyRowMapper<Expense>(Expense.class),catId,loginuser.getUserId());
		
//		System.out.println("Category Id from expense list when I tries to delete category by its id => "+list.get(0));
		
		if(list.size()>0) {
			int row1 = jdbcTemplate.update("delete from expense where categoryId=? and userId=?",catId,loginuser.getUserId());
			if(row1 == 1) {
				int row2 = jdbcTemplate.update("delete from category where categoryId = ? and userId = ?",catId,loginuser.getUserId());
				System.out.println("Category Id after delete query => "+catId);
				System.out.println("Delete query fired for category =>"+row2);
				if(row2 == 1) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		else {
			int row = jdbcTemplate.update("delete from category where categoryId = ? and userId = ?",catId,loginuser.getUserId());
			System.out.println("Category Id after delete query => "+catId);
			System.out.println("Delete query fired for category =>"+row);
			if(row == 1) {
				return true;
			}else {
				return false;
			}
		}
	}
	public boolean updateCategories(CategoryBean category) {
		int row = jdbcTemplate.update("update category set categoryName = ? where categoryId = ?",category.getCategoryName(),category.getCategoryId());
		System.out.println("Update query fired for category => "+row);
		if(row == 1) {
			return true;
		}else {
			return false;
		}
	}
}
