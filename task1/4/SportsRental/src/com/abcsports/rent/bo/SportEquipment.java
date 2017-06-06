package com.abcsports.rent.bo;


public class SportEquipment {

	private String category;

	private String title;

	private int price;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SportEquipment [category=" + category + ", title=" + title
				+ ", price=" + price + "]";
	}

	public String listAvailableEquipments()	{
		
		return "--- Sport Equipment details --- \n category=" + category + "\n title=" + title
				+ "\n price=" + price + "";
	}
	
}
