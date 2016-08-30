/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

/**
 * @author Nasrin Created on Aug 27, 2016
 */
public class ShopItem {
	private int itemId;
	private String brand;
	private String category;
	private long price;

	public ShopItem(String brand, String category, long price) {
		super();
		this.brand = brand;
		this.category = category;
		this.price = price;
	}

	public ShopItem() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShopItem [itemId=" + itemId + ", brand=" + brand
				+ ", category=" + category + ", price=" + price + "]";
	}

}
