package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="man_hr")
public class ManHr {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int h_id;
	@Column(name = "id")  
	private int id; 
	@Column(name="month")
	private String month;
	
//	@Column(name="1")
//	private String number;
	public String getValue() {
		return value;
	}

	


	
	
	


	@Column(name="value",columnDefinition="varchar(255) default 'No'",table ="man_hr")
	private String value="No";
	
	 
	

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String isValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Hr__view [h_id=" + h_id + ", id=" + id + ", month=" + month + ", value=" + value + 
				 "]";
	}

	

	
	
}
