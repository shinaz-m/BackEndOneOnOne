package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_goals")
public class Employeegoals {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gid;
	
	@Column(name="id")
	private int id;
	
	@Column(name= "goal",columnDefinition="varchar(500)")
	private String goal;
    
	@Column(name= "goaltime",columnDefinition="varchar(500)")
	private String goaltime;
	
	@Column(name="month")
	private String month;
	
	@Column(name="goalno")
	private int goalno;

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

	
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getGoaltime() {
		return goaltime;
	}

	public void setGoaltime(String goaltime) {
		this.goaltime = goaltime;
	}

	public int getGoalno() {
		return goalno;
	}

	public void setGoalno(int goalno) {
		this.goalno = goalno;
	}

	@Override
	public String toString() {
		return "Employeegoals [gid=" + gid + ", id=" + id + ", goal=" + goal + ", goaltime=" + goaltime + ", month="
				+ month + ", goalno=" + goalno + "]";
	}

	
 

	

	
}
