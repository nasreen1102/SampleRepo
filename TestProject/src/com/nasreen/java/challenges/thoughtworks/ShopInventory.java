/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nasrin Created on Aug 27, 2016
 */
public class ShopInventory {

	private Map<Integer, ShopItem> itemInventory;

	public ShopInventory() {
		super();
		itemInventory = new HashMap<Integer, ShopItem>();
	}

	/*private void displayInventory(Map<Integer, ShopItem> itemInventory) {
		if (itemInventory == null || itemInventory.isEmpty()) {
			System.out.println("item inventory is empty or null");
		}
		System.out.println("***********************");
		Set<Entry<Integer, ShopItem>> entrySet = itemInventory.entrySet();
		for (Entry<Integer, ShopItem> entry : entrySet) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		System.out.println("***********************");
	}*/

	public void constructShopInventory(Scanner scan) {
		// System.out.println("Enter the no. of items in the shop");
		int noofItems = scan.nextInt();
		scan.nextLine();// to avoid Line
		for (int i = 0; i < noofItems; i++) {
			String[] itemDetails;
			do {
				// System.out.println("Enter the item:" + i
				// + " with details (id, brand, category, price)");
				itemDetails = scan.nextLine().split(",");
			} while (itemDetails.length != 4);
			try {
				ShopItem item = new ShopItem(itemDetails[1], itemDetails[2],
						Long.valueOf(itemDetails[3]));
				itemInventory.put(Integer.parseInt(itemDetails[0]), item);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			}
			// displayInventory(inventory);
		}
	}

	public Map<Integer, ShopItem> getItemInventory() {
		return itemInventory;
	}

	public void setItemInventory(Map<Integer, ShopItem> itemInventory) {
		this.itemInventory = itemInventory;
	}

}
