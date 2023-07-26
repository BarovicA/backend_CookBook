package com.cookbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AlergeniEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ikona")
	private String ikona;

	@Column(name = "naziv")
	private String naziv;

	public AlergeniEntity() {
		super();
	}

	public AlergeniEntity(Integer id, String ikona, String naziv) {
		super();
		this.id = id;
		this.ikona = ikona;
		this.naziv = naziv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
