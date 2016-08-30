/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nasrin Created on Aug 27, 2016
 */
public class ShoppingBusiness {

	private ShopInventory inventory;

	public ShoppingBusiness() {
		inventory = new ShopInventory();
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			ShoppingBusiness business = new ShoppingBusiness();
			business.getInventory().constructShopInventory(scan);
			scan.nextLine();
			/*
			 * System.out
			 * .println("Enter no.of customers whose bills to be prepared");
			 */int testCases = scan.nextInt();
			scan.nextLine();// to avoid new Line

			// collect the customer selected inputs
			List<String> customerInputs = new ArrayList<String>();
			for (int i = 0; i < testCases; i++) {
				customerInputs.add(scan.nextLine());
			}
			scan.close();

			// process and prepare the bill for each customer
			for (String input : customerInputs) {
				String[] selectedItems = input.split(",");
				Long billAmount = business.calculateBill(selectedItems);
				System.out.println(billAmount);
			}
		} catch (NoItemFoundException ne) {
			System.out.println("Exception due to invalid Item:" + ne);
		} catch (NumberFormatException ne) {
			System.out.println("Exception due to invalid brnadId/CategoryId:"
					+ ne);
		}
	}

	public Long calculateBill(String[] selectedItems) {
		if (selectedItems.length == 0) {
			// System.out.println("No items selected");
			return 0l;
		}
		Long sum = 0l;
		for (String itemId : selectedItems) {
			// System.out.println("Selected item Id:" + itemId);
			sum += this.getPrice(Integer.parseInt(itemId));
		}
		return sum;
	}

	public Long getPrice(Integer itemId) {
		if (itemId == null) {
			throw new NoItemFoundException("item Id is null");
		}
		Map<Integer, ShopItem> itemInventory = this.inventory
				.getItemInventory();
		ShopItem item = itemInventory.get(itemId);
		if (item == null) {
			throw new NoItemFoundException("Item not found in the inventory");
		}
		return this.getPriceAfterDiscount(item);
	}

	public Long getPriceAfterDiscount(ShopItem userSelectedItem) {
		Integer brandDiscount = DataHolder.brandDiscount.get(userSelectedItem
				.getBrand().toLowerCase());
		Integer categoryDiscount = this.getCategoryDiscount(userSelectedItem
				.getCategory().toLowerCase());

		if (brandDiscount == null && categoryDiscount == null) {
			return userSelectedItem.getPrice();
		} else if (brandDiscount == null) {
			brandDiscount = 0;
		} else if (categoryDiscount == null) {
			categoryDiscount = 0;
		}
		// System.out.println(brandDiscount + "," + categoryDiscount);
		Integer maxDiscount = brandDiscount > categoryDiscount ? brandDiscount
				: categoryDiscount;
		return calculatePrice(userSelectedItem, maxDiscount);
	}

	public Long calculatePrice(ShopItem userSelectedItem, Integer maxDiscount) {
		long itemPrice = userSelectedItem.getPrice();
		Long cost = (100 - maxDiscount) * itemPrice / 100;
		// System.out.println("cost of the item:" + userSelectedItem + " is Rs."
		// + cost);
		return cost;
	}

	public Integer getCategoryDiscount(String category) {
		if (category == null) {
			throw new NoItemFoundException("category is null");
		}

		Integer maxDiscount = 0;
		Category parent = null;
		do {
			Category node = DataHolder.categoryDiscount.get(category);
			if (node == null) {
				throw new NoItemFoundException("Invalid category");
			}
			maxDiscount = maxDiscount > node.getDiscount() ? maxDiscount : node
					.getDiscount();

			parent = node.getParent();
			if (parent != null)
				category = parent.getCategoryName();
		} while (parent != null);
		return maxDiscount;
	}

	public ShopInventory getInventory() {
		return inventory;
	}

	public void setInventory(ShopInventory inventory) {
		this.inventory = inventory;
	}

}
