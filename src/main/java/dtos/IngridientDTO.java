package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class IngridientDTO {
	
	@Column
	@NotNull(message = "Name must be included.")
	@Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
	private String name;
	
	@Column(name = "serving_fats")
	@NotNull(message = "Serving size must be included.")
	private String servingSize;
	
	@Column
	@NotNull(message = "Calories must be included.")
	private Integer calories;
	
	@Column
	@NotNull(message = "Carbs must be included.")
	private Integer carbs;
	
	@Column
	@NotNull(message = "Sugars must be included.")
	private Integer sugars;
	
	@Column
	@NotNull(message = "Fats must be included.")
	private Integer fats;
	
	@Column(name = "saturated_fats")
	@NotNull(message = "Saturated fats must be included.")
	private Integer saturatedFats;
	
	@Column
	@NotNull(message = "Proteins must be included.")
	private Integer proteins;

	public IngridientDTO(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Serving size must be included.") String servingSize,
			@NotNull(message = "Calories must be included.") Integer calories,
			@NotNull(message = "Carbs must be included.") Integer carbs,
			@NotNull(message = "Sugars must be included.") Integer sugars,
			@NotNull(message = "Fats must be included.") Integer fats,
			@NotNull(message = "Saturated fats must be included.") Integer saturatedFats,
			@NotNull(message = "Proteins must be included.") Integer proteins) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturatedFats = saturatedFats;
		this.proteins = proteins;
	}

	public IngridientDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getCarbs() {
		return carbs;
	}

	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}

	public Integer getSugars() {
		return sugars;
	}

	public void setSugars(Integer sugars) {
		this.sugars = sugars;
	}

	public Integer getFats() {
		return fats;
	}

	public void setFats(Integer fats) {
		this.fats = fats;
	}

	public Integer getSaturatedFats() {
		return saturatedFats;
	}

	public void setSaturatedFats(Integer saturatedFats) {
		this.saturatedFats = saturatedFats;
	}

	public Integer getProteins() {
		return proteins;
	}

	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}
	
	
}
