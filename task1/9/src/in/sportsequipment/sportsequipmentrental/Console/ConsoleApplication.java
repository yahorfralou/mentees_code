package in.sportsequipment.sportsequipmentrental.Console;

import java.util.InputMismatchException;

import in.sportsequipment.sportsequipmentrental.shop.Shop;

public class ConsoleApplication {

	public static void main(String[] args) {
		Shop shop = new Shop();
		int selection = 0;
		shop.initializeShop();
		System.out.println("Welcome to Sports Rental Shop !");
		try {
			while (true) {
				System.out.println(
						" 1. Display Available Items \n 2. Seach Items \n 3. Add to Cart \n 4. Review Cart \n 5. Exit");
				System.out.println("Enter your option: ");

				selection = shop.userSelection();

				if (selection == 5) {
					System.out.println("Exiting.....");
					break;
				}

				switch (selection) {
				case 1:
					shop.displayGoods();
					break;
				case 2:
					shop.searchGoods();
					break;
				case 3:
					shop.addItemToCart();
					break;
				case 4:
					shop.viewCart();
					break;
				default:
					System.out.println("Invalid selection... Please retry..");
					break;
				}
			}

		} catch (InputMismatchException e) { //* no retry here */
			System.out.println("String value entered.. Invalid Selection. Please Retry.. " + e);
		}
	}

}
