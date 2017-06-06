package in.sportsequipment.sportsequipmentrental.equipments;

import java.util.Objects;

public class SportsEquipment {
	private String title;
	private Category category;
	private int price;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof SportsEquipment))
			return false;

		SportsEquipment sportsEquipment = (SportsEquipment) obj;
		return this.title.equalsIgnoreCase(sportsEquipment.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

}
