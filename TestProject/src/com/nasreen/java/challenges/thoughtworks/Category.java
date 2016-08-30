/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

/**
 * @author Nasrin Created on Aug 27, 2016
 */
public class Category {
	private String categoryName;
	private Integer discount;
	private Category parent;

	public Category(String categoryName, Integer discount, Category parent) {
		super();
		this.categoryName = categoryName;
		this.discount = discount;
		this.parent = parent;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @return the parent
	 */
	public Category getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}

}
