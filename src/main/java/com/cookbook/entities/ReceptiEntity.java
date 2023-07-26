package com.cookbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReceptiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nazivRecepta")
	private String naziv;

	@Column(name = "opisRecepta")
	private String opis;

	@Column(name = "koraciPripreme")
	private String koraciPripreme;

	@Column(name = "vremePripreme")
	Integer ocekivaniRasponVremenaPripreme;

	@Column(name = "kolicinaHrane")
	private Integer ocekivanaKolicinaHrane;

	public ReceptiEntity() {
		super();
	}

	public ReceptiEntity(Integer id, String naziv, String opis, String koraciPripreme,
			Integer ocekivaniRasponVremenaPripreme, Integer ocekivanaKolicinaHrane) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.koraciPripreme = koraciPripreme;
		this.ocekivaniRasponVremenaPripreme = ocekivaniRasponVremenaPripreme;
		this.ocekivanaKolicinaHrane = ocekivanaKolicinaHrane;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getKoraciPripreme() {
		return koraciPripreme;
	}

	public void setKoraciPripreme(String koraciPripreme) {
		this.koraciPripreme = koraciPripreme;
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
