package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="egoal")
public class egoal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gid;
	
	@Column(name="id")
	private int id;
	
	@Column(name= "goal",columnDefinition="varchar(500)")
	private String goal;
    
	@Column(name= "gtime",columnDefinition="varchar(500)")
	private String gtime;

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

	@Override
	public String toString() {
		return "egoal [gid=" + gid + ", id=" + id + ", goal=" + goal + ", gtime=" + gtime + "]";
	}
	
}
