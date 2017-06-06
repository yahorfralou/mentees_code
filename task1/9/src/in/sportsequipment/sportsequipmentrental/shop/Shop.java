package in.sportsequipment.sportsequipmentrental.shop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import in.sportsequipment.sportsequipmentrental.equipments.Category;
import in.sportsequipment.sportsequipmentrental.equipments.SportsEquipment;
import in.sportsequipment.sportsequipmentrental.rent.RentUnit;

public class Shop {
	private Map<SportsEquipment, Integer> goods = new HashMap<>();
	RentUnit cart = new RentUnit();
	private static final String FILENAME = "D:\\input.txt";
	Scanner scr = new Scanner(System.in);

	public void initializeShop() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String currentLine;
			String[] fields;
			int noOfGoodsAvailableForRent = 0;
			while ((currentLine = br.readLine()) != null) {
				fields = currentLine.split(":");
				// System.out.println(fields[0] + " " + fields[1] + " " +
				// fields[2] + " " + fields[3] + " " + fields[4]);
				if ((fields[0] != null) && (fields[1] != null) && (fields[3] != null)) {
					SportsEquipment se = new SportsEquipment();
					se.setTitle(fields[0]);
					se.setCategory(Category.valueOf(fields[1]));
					se.setPrice(Integer.valueOf(fields[2]));
					noOfGoodsAvailableForRent = Integer.valueOf(fields[3]);
					goods.put(se, noOfGoodsAvailableForRent);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not present in the specified loaction.");
		} catch (IOException e) {
			System.out.println("IO expection.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid data in the file. Some of the fields are missings in the file.");
		}
	}

	public void displayGoods() {
		if (!goods.isEmpty()) {
			for (Map.Entry<SportsEquipment, Integer> entry : goods.entrySet()) {
				if (entry != null && entry.getValue() > 0) {
					SportsEquipment se = entry.getKey();
					System.out.println(" Name : " + se.getTitle() + " Category: " + se.getCategory() + " Price: "
							+ se.getPrice() + " No of goods available: " + entry.getValue());
				}
			}
		} else
			System.out.println("Currently, there are no sports equipemnt available for rent. Thank you!");
	}

	public int userSelection() throws InputMismatchException {
		return scr.nextInt();
	}

	public void searchGoods() {
		scr.nextLine();
		System.out.println("Enter the name of the equipment you would like to search: ");
		String seachName = scr.nextLine();
		boolean isFound = false;
		if (!goods.isEmpty()) {
			for (Map.Entry<SportsEquipment, Integer> entry : goods.entrySet()) {
				if (entry != null) {
					SportsEquipment se = entry.getKey();
					if (se.getTitle().equalsIgnoreCase(seachName)) {
						System.out.println(" Name : " + se.getTitle() + " Category: " + se.getCategory() + " Price: "
								+ se.getPrice() + " No of goods available: " + entry.getValue());
						isFound = true;
						break;
					}
				}
			}
			if (!isFound) {
				System.out.println("Entered sports equipment is not available in the shop.");
			}
		} else
			System.out.println("Currently, there are no sports equipemnt available for rent. Thank you!");
	}

	public void addItemToCart() {
		scr.nextLine();
		System.out.println("Enter the name of the equipment you would like to add: ");
		String equipmentName = scr.nextLine();
		boolean isFound = false;
		if (!goods.isEmpty()) {
			for (Map.Entry<SportsEquipment, Integer> entry : goods.entrySet()) {
				if (entry != null) {
					SportsEquipment se = entry.getKey();
					if (se.getTitle().equalsIgnoreCase(equipmentName) && entry.getValue() > 0) {
						System.out.println(" Name : " + se.getTitle() + " Category: " + se.getCategory() + " Price: "
								+ se.getPrice() + " No of goods available: " + entry.getValue());
						if (cart.addToCart(se)) {
							entry.setValue(entry.getValue() - 1);
							if (entry.getValue() == 0) {
								goods.remove(se);
							}
						}
						isFound = true;
						break;
					}
				}
			}
			if (!isFound) {
				System.out.println("Entered sports equipment is not available in the shop.");
			}
		} else
			System.out.println("Currently, there are no sports equipemnt available for rent. Thank you!");
	}

	public void viewCart() {
		cart.reviewCart();
	}

}
