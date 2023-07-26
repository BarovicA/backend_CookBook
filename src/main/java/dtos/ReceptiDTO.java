package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReceptiDTO {

	@Column
	@NotNull(message = "Name must be provided")
	@Size(min=2, max=30, message = "Name must be between {min} and {max} characters long.")
	protected String naziv;
	@Column
	protected String opis;
	@Column
	protected String koraciZaPripremu;
	@Column
	protected Integer ocekivaniRasponVremenaPripreme;
	@Column
	protected Integer ocekivanaKolicinaHrane;
	public ReceptiDTO() {
		super();
	}
	public ReceptiDTO(
			@NotNull(message = "Name must be provided") @Size(min = 2, max = 30, message = "Name must be between {min} and {max} characters long.") String naziv,
			String opis, String koraciZaPripremu, Integer ocekivaniRasponVremena, Integer ocekivanaKolicinaHrane) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.koraciZaPripremu = koraciZaPripremu;
		this.ocekivaniRasponVremenaPripreme = ocekivaniRasponVremenaPripreme;
		this.ocekivanaKolicinaHrane = ocekivanaKolicinaHrane;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getKoraciZaPripremu() {
		return koraciZaPripremu;
	}
	public void setKoraciZaPripremu(String koraciZaPripremu) {
		this.koraciZaPripremu = koraciZaPripremu;
	}
	public Integer getOcekivaniRasponVremenaPripreme() {
		return ocekivaniRasponVremenaPripreme;
	}
	public void setOcekivaniRasponVremenaPripreme(Integer ocekivaniRasponVremenaPripreme) {
		this.ocekivaniRasponVremenaPripreme = ocekivaniRasponVremenaPripreme;
	}
	public Integer getOcekivanaKolicinaHrane() {
		return ocekivanaKolicinaHrane;
	}
	public void setOcekivanaKolicinaHrane(Integer ocekivanaKolicinaHrane) {
		this.ocekivanaKolicinaHrane = ocekivanaKolicinaHrane;
	}
	
	
}
