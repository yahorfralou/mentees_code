package com.abcsports.rent.store;

import java.util.HashMap;
import java.util.Map;

import com.abcsports.rent.bo.SportEquipment;

public class Shop {

	private Map<SportEquipment, Integer> goods = new HashMap<SportEquipment,Integer>();

	public Map<SportEquipment, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<SportEquipment, Integer> goods) {
		this.goods = goods;
	}
	
	public void addGood(SportEquipment sportEquipment, Integer count) {
	    goods.put(sportEquipment, count);
	
	}
}
