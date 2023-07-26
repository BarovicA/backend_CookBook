package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SastojakDTO {
	
	@Column
	@NotNull(message = "Name must be provided")
	@Size(min=2, max=30, message = "Name must be between {min} and {max} characters long.")
	protected String naziv;
	@Column
	protected Integer jedinicaMereSastojka;
	@Column
	protected Integer nulaIliViseAlergena;
	
	public SastojakDTO() {
		super();
	}
	public SastojakDTO(
			@NotNull(message = "Name must be provided") @Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.") String naziv,
			Integer jedinicaMereSastojka, Integer nulaIliViseAlergena) {
		super();
		this.naziv = naziv;
		this.jedinicaMereSastojka = jedinicaMereSastojka;
		this.nulaIliViseAlergena = nulaIliViseAlergena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getJedinicaMereSastojka() {
		return jedinicaMereSastojka;
	}
	public void setJedinicaMereSastojka(Integer jedinicaMereSastojka) {
		this.jedinicaMereSastojka = jedinicaMereSastojka;
	}
	public Integer getNulaIliViseAlergena() {
		return nulaIliViseAlergena;
	}
	public void setNulaIliViseAlergena(Integer nulaIliViseAlergena) {
		this.nulaIliViseAlergena = nulaIliViseAlergena;
	}

	
}
