package com.epam.sportequipmentrental.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.epam.sportequipmentrental.constants.RentalConstants;
import com.epam.sportequipmentrental.entity.SportEquipment;
import com.epam.sportequipmentrental.service.GoodsStockService;
import com.epam.sportequipmentrental.service.ShopDataService;

public class SportsEquipmentController {

	public static void main(String[] args) throws IOException {

		/*
		 * To intialize shop data on app start
		 */ /** single resp | store in class field*/
		List<SportEquipment> sportEquipmentList = ShopDataService.intializeShopDataFromFile();

		System.out.println(RentalConstants.OPTION1);
		System.out.println(RentalConstants.OPTION2);
		System.out.println(RentalConstants.OPTION3);
		System.out.println(RentalConstants.OPTION4);

		Scanner inputReader = new Scanner(System.in);
		String name = inputReader.nextLine();

		switch (name) {
		case "1":
			GoodsStockService.seeAvailableGoods(sportEquipmentList);
			break;
		case "2":

			break;
		case "3":

			break;
		case "4":
			System.out.println(RentalConstants.STOP_APP);
			System.exit(0); /** ?? */

			break;
		}
	}

}
