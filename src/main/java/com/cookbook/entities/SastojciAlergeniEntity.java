package com.cookbook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SastojciAlergeniEntity {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AlergeniEntity alergen;

    @ManyToOne
    private SastojakEntity sastojak;

	public SastojciAlergeniEntity() {
		super();
	}

	public SastojciAlergeniEntity(Integer id, AlergeniEntity alergen, SastojakEntity sastojak) {
		super();
		this.id = id;
		this.alergen = alergen;
		this.sastojak = sastojak;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlergeniEntity getAlergen() {
		return alergen;
	}

	public void setAlergen(AlergeniEntity alergen) {
		this.alergen = alergen;
	}

	public SastojakEntity getSastojak() {
		return sastojak;
	}

	public void setSastojak(SastojakEntity sastojak) {
		this.sastojak = sastojak;
	}
	
	
    
    

}
