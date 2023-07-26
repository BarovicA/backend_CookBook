package com.cookbook.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class SastojakEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column
    private String naziv;
	@Column
    private Integer jedinicaMere;
    
    private List<AlergeniEntity> alergeni;

	public SastojakEntity() {
		super();
	}

	public SastojakEntity(Integer id, String naziv, Integer jedinicaMere, List<AlergeniEntity> alergeni) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.jedinicaMere = jedinicaMere;
		this.alergeni = alergeni;
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

	public Integer getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(Integer jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public List<AlergeniEntity> getAlergeni() {
		return alergeni;
	}

	public void setAlergeni(List<AlergeniEntity> alergeni) {
		this.alergeni = alergeni;
	}
	

}