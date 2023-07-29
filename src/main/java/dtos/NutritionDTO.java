package dtos;

import jakarta.persistence.Column;

public class NutritionDTO {

	@Column
	protected double carbohydrates;
	@Column
	protected double shugers;
	@Column
	protected double fats;
	@Column
	protected double satturatedFats;
	@Column
	protected double proteins;
	@Column
	protected Integer calories;

	public NutritionDTO() {
		super();
	}

	public NutritionDTO(double carbohydrates, double shugers, double fats, double satturatedFats, double proteins,
			Integer calories) {
		super();
		this.carbohydrates = carbohydrates;
		this.shugers = shugers;
		this.fats = fats;
		this.satturatedFats = satturatedFats;
		this.proteins = proteins;
		this.calories = calories;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getShugers() {
		return shugers;
	}

	public void setShugers(double shugers) {
		this.shugers = shugers;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}

	public double getSatturatedFats() {
		return satturatedFats;
	}

	public void setSatturatedFats(double satturatedFats) {
		this.satturatedFats = satturatedFats;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	
}
