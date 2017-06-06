package com.abcsports.rent.main;

import java.io.IOException;
import java.util.Scanner;

import com.abcsports.rent.bo.SportEquipment;
import com.abcsports.rent.service.RentUnit;

public class ShoppingController {
	public ShoppingController sc = new ShoppingController();
	
	public static void main(String args[]) throws ArrayIndexOutOfBoundsException, IOException {
		SportEquipment equipment1 = new SportEquipment();
		SportEquipment equipment2 = new SportEquipment();
		SportEquipment equipment3 = new SportEquipment();

		equipment1.setCategory("Ball");
		equipment1.setPrice(100);
		equipment1.setTitle("FootBall");

		equipment2.setCategory("Ball");
		equipment2.setPrice(150);
		equipment2.setTitle("Cricket Ball");

		equipment3.setCategory("Ball");
		equipment3.setPrice(200);
		equipment3.setTitle("Tennis Ball");

		SportEquipment[] units = new SportEquipment[3];
		units[0] = equipment1;
		units[1] = equipment2;
		units[2] = equipment3;

		RentUnit sportsUnits = new RentUnit();
		sportsUnits.setUnits(units);

		System.out.println("Welcome to ABC Sports");
		System.out.println(" Available Sports Equipment");
		
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = null;

		while (true) {

			System.out.print(
					"Enter Int values for 1 for Reading/Display the data/2 for searching/3 for exit the application : ");
			String input = scanner.nextLine();
			if ("1".equals(input)) {
				for (SportEquipment s : units) {

					System.out.println(s.listAvailableEquipments());
				}
				
			} else if ("2".equals(input)) {
				scanner1 = new Scanner(System.in);
				
				
				System.out.print(
					"Enter Title : ");
				if (scanner1 != null) {
					String searchInput = scanner1.nextLine();

					if (sportsUnits.getUnits() != null) {
						SportEquipment[] sq = sportsUnits.getUnits();

						for (int i = 0; i < sq.length; i++) {
							if (searchInput.equals(sq[i].getTitle())) {
								System.out.println(sq[i]);
							}
						}
					}
				}
				
			} else if ("3".equals(input)) {
				System.out.println("Exit!");
				break;
			}
		}

		scanner.close();
		scanner1.close();

	}
	
	
	
	
}