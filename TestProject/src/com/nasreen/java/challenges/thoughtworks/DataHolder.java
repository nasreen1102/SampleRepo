/**
 * 
 */
package com.nasreen.java.challenges.thoughtworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Nasrin Created on Aug 27, 2016
 * 
 *         This class holds the static data of the Shop. It maintains all
 *         constants in lowercase
 */
public final class DataHolder {

	public static Scanner userInputScan = new Scanner(System.in);

	public static Map<String, Integer> brandDiscount = new HashMap<String, Integer>() {
		private static final long serialVersionUID = 330102577425510655L;
		{
			put("wrangler", 10);
			put("arrow", 20);
			put("veromoda", 60);
			put("ucb", 0);
			put("adidas", 5);
			put("provogue", 20);
		}
	};

	/**
	 * CategoryMap<childCategory,parentCategory>
	 */
	public static Map<String, Category> categoryDiscount = new HashMap<String, Category>() {
		private static final long serialVersionUID = -6904266446723952420L;
		{
			// Women category
			Category womenWear = new Category("womenswear", 50, null);
			Category dresses = new Category("dresses", 0, womenWear);
			Category footwear = new Category("footwear", 0, womenWear);
			// Men category
			Category menWear = new Category("menswear", 0, null);
			Category shirts = new Category("shirts", 0, menWear);
			Category trousers = new Category("trousers", 0, menWear);
			Category casuals = new Category("casuals", 30, menWear);
			Category jeans = new Category("jeans", 20, menWear);

			put(womenWear.getCategoryName(), womenWear);
			put(dresses.getCategoryName(), dresses);
			put(footwear.getCategoryName(), footwear);
			put(menWear.getCategoryName(), menWear);
			put(shirts.getCategoryName(), shirts);
			put(trousers.getCategoryName(), trousers);
			put(casuals.getCategoryName(), casuals);
			put(jeans.getCategoryName(), jeans);

		}
	};

}
