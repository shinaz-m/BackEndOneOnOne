package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="egoal")
public class Employeegoals {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gid;
	
	@Column(name="id")
	private int id;
	
	@Column(name= "goal",columnDefinition="varchar(500)")
	private String goal;
    
	@Column(name= "gtime",columnDefinition="varchar(500)")
	private String gtime;
	
	@Column(name="month")
	private String month;
	
	@Column(name="gno")
	private int gno;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getGtime() {
		return gtime;
	}

	public void setGtime(String gtime) {
		this.gtime = gtime;
	}

	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	@Override
	public String toString() {
		return "Employeegoals [gid=" + gid + ", id=" + id + ", goal=" + goal + ", gtime=" + gtime + ", month=" + month
				+ ", gno=" + gno + "]";
	}

	
	
 

	

	
}
