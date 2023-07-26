package com.cookbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HranljivostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	@Column(name = "gramiUgljenihHidrata")
	private double gramiUgljenihHidrata;

	@Column(name = "secer")
	private double secer;

	@Column(name = "masti")
	private double masti;

	@Column(name = "zasiceneMasti")
	private double zasiceneMasti;

	@Column(name = "proteini")
	private double proteini;

	@Column(name = "brojKalorija")
	private int brojKalorija;

	public HranljivostEntity() {
		super();

	}

	public HranljivostEntity(Integer id, double gramiUgljenihHidrata, double secer, double masti, double zasiceneMasti,
			double proteini, int brojKalorija) {
		super();
		this.id = id;
		this.gramiUgljenihHidrata = gramiUgljenihHidrata;
		this.secer = secer;
		this.masti = masti;
		this.zasiceneMasti = zasiceneMasti;
		this.proteini = proteini;
		this.brojKalorija = brojKalorija;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getGramiUgljenihHidrata() {
		return gramiUgljenihHidrata;
	}

	public void setGramiUgljenihHidrata(double gramiUgljenihHidrata) {
		this.gramiUgljenihHidrata = gramiUgljenihHidrata;
	}

	public double getSecer() {
		return secer;
	}

	public void setSecer(double secer) {
		this.secer = secer;
	}

	public double getMasti() {
		return masti;
	}

	public void setMasti(double masti) {
		this.masti = masti;
	}

	public double getZasiceneMasti() {
		return zasiceneMasti;
	}

	public void setZasiceneMasti(double zasiceneMasti) {
		this.zasiceneMasti = zasiceneMasti;
	}

	public double getProteini() {
		return proteini;
	}

	public void setProteini(double proteini) {
		this.proteini = proteini;
	}

	public int getBrojKalorija() {
		return brojKalorija;
	}

	public void setBrojKalorija(int brojKalorija) {
		this.brojKalorija = brojKalorija;
	}

}
