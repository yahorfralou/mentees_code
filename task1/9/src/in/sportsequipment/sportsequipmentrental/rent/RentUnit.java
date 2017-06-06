package in.sportsequipment.sportsequipmentrental.rent;

import in.sportsequipment.sportsequipmentrental.equipments.SportsEquipment;

public class RentUnit {
	private SportsEquipment[] units = new SportsEquipment[3];
	static int count = 0;

	public boolean addToCart(SportsEquipment se) {
		if (count > 2) {
			System.out.println("Cart is full. No more items are allowed to add.");
			return false;
		} else {
			units[count] = se;
			System.out.println("Item " + se.getTitle() + " has been added successfully");
			count++;
			return true;
		}
	}

	public void reviewCart() {
		int totalPrice = 0;
		if (count == 0) {
			System.out.println("Cart is empty!");
		} else {
			System.out.println("Following are the items in the cart.");
			for (int i = 0; i < units.length; i++) {
				if (units[i] != null) {
					totalPrice = totalPrice + units[i].getPrice();
					System.out.println(" Name : " + units[i].getTitle() + " Category: " + units[i].getCategory()
							+ " Price: " + units[i].getPrice());
				}
			}
			if (totalPrice > 0) {
				System.out.println("Total price of equipments: " + totalPrice);
			}

		}
	}

}
