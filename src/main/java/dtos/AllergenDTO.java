package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AllergenDTO {

	@Column
	@NotNull(message = "Name must be included.")
	@Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
	private String name;
	
	@Column
	@NotNull(message = "Name must be included.")
	private String icon;

	public AllergenDTO(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Name must be included.") String icon) {
		super();
		this.name = name;
		this.icon = icon;
	}

	

	public AllergenDTO() {
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
