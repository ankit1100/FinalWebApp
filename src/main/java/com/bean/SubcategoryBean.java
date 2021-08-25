package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class SubcategoryBean {
	
	@NotBlank(message = "Please enter valid sub-category name!")
	private String subCatName;
	
	private int subCatId;
	CategoryBean category;
	
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}
	public CategoryBean getCategory() {
		return category;
	}
	public void setCategory(CategoryBean category) {
		this.category = category;
	}
}
