package com.epam.sportequipmentrental.service;

import java.util.List;

import com.epam.sportequipmentrental.constants.RentalConstants;
import com.epam.sportequipmentrental.entity.SportEquipment;

public class GoodsStockService {
	public static void seeAvailableGoods(List<SportEquipment> sportEquipmentList) {
		System.out.println(RentalConstants.AVAILABLE_GOODS);
		System.out.println(RentalConstants.MESSAGE);
		for (SportEquipment sq : sportEquipmentList) {
			System.out.println(
					sq.getCategory() + "    " + sq.getName() + "        " + sq.getPrice() + "    " + sq.getInStock());
		}
	}
}
