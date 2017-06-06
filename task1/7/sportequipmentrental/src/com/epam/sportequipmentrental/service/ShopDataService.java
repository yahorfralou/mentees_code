package com.epam.sportequipmentrental.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.sportequipmentrental.constants.RentalConstants;
import com.epam.sportequipmentrental.entity.SportEquipment;

public class ShopDataService {
	/** method name */
	public static List<SportEquipment> intializeShopDataFromFile() {
		/** unnecessary assignment */
		SportEquipment eq = new SportEquipment();
		List<SportEquipment> sportEquipmentList = new ArrayList<SportEquipment>();
		try (BufferedReader br = new BufferedReader(new FileReader(RentalConstants.FILE_LOACTION));) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
				eq = populateSportEquipment(line);
				if(eq != null) /** formatting */
				{
					sportEquipmentList.add(eq);
				}
			}
		} catch (IOException e) {
			System.out.println(RentalConstants.EXCEPTION_MESSAGE+e.getMessage());
		}
		return sportEquipmentList;
	}

	/**
	 * use custom Exception
	 */
	private static SportEquipment populateSportEquipment(String line) {
		SportEquipment eq = new SportEquipment();
		if (line != null) {
			String[] sport = line.split(RentalConstants.SPLIT_CONSTANT);
			eq = new SportEquipment();
			eq.setCategory(sport[0]);
			eq.setName(sport[1]);
			eq.setPrice(Integer.parseInt(sport[2]));
			eq.setInStock(Integer.parseInt(sport[3]));
			return eq;
		} else {
			return null;
		}
	}
}
