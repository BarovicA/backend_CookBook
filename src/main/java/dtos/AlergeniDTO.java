package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlergeniDTO {

	@Column
	protected String ikona;
	@Column
	@NotNull(message = "Name must be provided")
	@Size(min=2, max=30, message = "Name must be between {min} and {max} characters long.")
	protected String naziv;
	public AlergeniDTO() {
		super();
	}
	public AlergeniDTO(String ikona,
			@NotNull(message = "Name must be provided") @Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.") String naziv) {
		super();
		this.ikona = ikona;
		this.naziv = naziv;
	}
	public String getIkona() {
		return ikona;
	}
	public void setIkona(String ikona) {
		this.ikona = ikona;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
