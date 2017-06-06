package com.epam.sportequipmentrental.entity;

public class SportEquipment {
	private String category;
	private String name;
	private Integer price;
	private Integer inStock;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the inStock
	 */
	public Integer getInStock() {
		return inStock;
	}
	/**
	 * @param inStock the inStock to set
	 */
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}	
}
