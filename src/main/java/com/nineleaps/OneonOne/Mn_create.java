package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mn_create")
public class Mn_create {
	
	
	@Id
	@Column(name = "mid")  
	private int mid; 
	@Column(name="mngname")
	private String mngname;
	
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMngname() {
		return mngname;
	}
	public void setMngpos(String mngname) {
		this.mngname = mngname;
	}
	@Override
	public String toString() {
		return "Mn_create [ mid=" + mid + ", mngname=" + mngname + "]";
	}
	
}
