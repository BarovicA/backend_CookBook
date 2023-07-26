package dtos;

import jakarta.persistence.Column;

public class HranljivostDTO {

	@Column
	protected double gramiUgljeniHidrati;
	@Column
	protected double secera;
	@Column
	protected double masti;
	@Column
	protected double zasiceneMasti;
	@Column
	protected double proteini;
	@Column
	protected Integer brojKalorija;

	public HranljivostDTO() {
		super();
	}

	public HranljivostDTO(double gramiUgljeniHidrati, double secera, double masti, double zasiceneMasti,
			double proteini, Integer brojKalorija) {
		super();
		this.gramiUgljeniHidrati = gramiUgljeniHidrati;
		this.secera = secera;
		this.masti = masti;
		this.zasiceneMasti = zasiceneMasti;
		this.proteini = proteini;
		this.brojKalorija = brojKalorija;
	}

	public double getGramiUgljeniHidrati() {
		return gramiUgljeniHidrati;
	}

	public void setGramiUgljeniHidrati(double gramiUgljeniHidrati) {
		this.gramiUgljeniHidrati = gramiUgljeniHidrati;
	}

	public double getSecera() {
		return secera;
	}

	public void setSecera(double secera) {
		this.secera = secera;
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

	public Integer getBrojKalorija() {
		return brojKalorija;
	}

	public void setBrojKalorija(Integer brojKalorija) {
		this.brojKalorija = brojKalorija;
	}

}
