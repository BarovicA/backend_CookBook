package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecipeDTO {

	@Column
	@NotNull(message = "Name must be included.")
	@Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
	private String name;
	
	@Column
	@NotNull(message = "Description must be included.")
	@Size(min=2,max = 500, message= "Description must be beetwen {min} and {max} characters long.")
	private String decription;
	
	@Column
	@NotNull(message = "Steps must be included.")
	private String steps;
	
	@Column
	@NotNull(message = "Time to prepare must be included.")
	private Integer timeToPrepare;
	
	@Column
	@NotNull(message = "Expected yield must be included.")
	private String expectedYield;

	public RecipeDTO(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Description must be included.") @Size(min = 2, max = 500, message = "Description must be beetwen {min} and {max} characters long.") String decription,
			@NotNull(message = "Steps must be included.") String steps,
			@NotNull(message = "Time to prepare must be included.") Integer timeToPrepare,
			@NotNull(message = "Expected yield must be included.") String expectedYield) {
		super();
		this.name = name;
		this.decription = decription;
		this.steps = steps;
		this.timeToPrepare = timeToPrepare;
		this.expectedYield = expectedYield;
	}

	public RecipeDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public Integer getTimeToPrepare() {
		return timeToPrepare;
	}

	public void setTimeToPrepare(Integer timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}

	public String getExpectedYield() {
		return expectedYield;
	}

	public void setExpectedYield(String expectedYield) {
		this.expectedYield = expectedYield;
	}
	
	
	
	
}
