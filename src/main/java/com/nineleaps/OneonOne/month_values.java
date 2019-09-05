package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="month_values")
public class month_values {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="jan", columnDefinition="int(11) default '0'")
	private int jan;

	@Column(name="feb", columnDefinition="int(11) default '0'")
	private int feb;

	@Column(name="mar", columnDefinition="int(11) default '0'")
	private int mar;

	@Column(name="apr", columnDefinition="int(11) default '0'")
	private int apr;

	@Column(name="may", columnDefinition="int(11) default '0'")
	private int may;

	@Column(name="june", columnDefinition="int(11) default '0'")
	private int june;

	@Column(name="july", columnDefinition="int(11) default '0'")
	private int july;

	@Column(name="aug", columnDefinition="int(11) default '0'")
	private int aug;

	@Column(name="sep", columnDefinition="int(11) default '0'")
	private int sep;

	@Column(name="oct", columnDefinition="int(11) default '0'")
	private int oct;

	@Column(name="nov", columnDefinition="int(11) default '0'")
	private int nov;

	@Column(name="december", columnDefinition="int(11) default '0'")
	private int december;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJan() {
		return jan;
	}

	public void setJan(int jan) {
		this.jan = jan;
	}

	public int getFeb() {
		return feb;
	}

	public void setFeb(int feb) {
		this.feb = feb;
	}

	public int getMar() {
		return mar;
	}

	public void setMar(int mar) {
		this.mar = mar;
	}

	public int getApr() {
		return apr;
	}

	public void setApr(int apr) {
		this.apr = apr;
	}

	public int getMay() {
		return may;
	}

	public void setMay(int may) {
		this.may = may;
	}

	public int getJune() {
		return june;
	}

	public void setJune(int june) {
		this.june = june;
	}

	public int getJuly() {
		return july;
	}

	public void setJuly(int july) {
		this.july = july;
	}

	public int getAug() {
		return aug;
	}

	public void setAug(int aug) {
		this.aug = aug;
	}

	public int getSep() {
		return sep;
	}

	public void setSep(int sep) {
		this.sep = sep;
	}

	public int getOct() {
		return oct;
	}

	public void setOct(int oct) {
		this.oct = oct;
	}

	public int getNov() {
		return nov;
	}

	public void setNov(int nov) {
		this.nov = nov;
	}

	public int getDecember() {
		return december;
	}

	public void setDecember(int december) {
		this.december = december;
	}


}
