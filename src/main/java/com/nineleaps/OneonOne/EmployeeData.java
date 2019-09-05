package com.nineleaps.OneonOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
public class EmployeeData {
	@NotNull
	@Size(min=5,max=30)
	@Column(name="empname")
	private String empname;
	
	@Column(name="password",length=255)
	@NotNull
	private String password;
	
	@Column(name="email")
	@NotNull
	private String email;

	@Column(name="designation", columnDefinition="varchar(255) default 'employee'")
	private String designation="employee";
	
	@Column(name="phone")
	private String phone;
    
	@Column(name="mid",columnDefinition="int(11) default '0'")
    @NotNull
    private int mid=0;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	
	public EmployeeData()
	
	{
		
	}
	
	
	



	public void UserData(String empname, String password,String phone,String email) {
		//super();,
		//this.id=id;
		this.empname = empname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public String getDesignation() {
		return designation;
	}

	public int getMid() {
		return mid;
	}



	public void setMid(int mid) {
		this.mid = mid;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public void setUsername(String empname) {
		String s =empname;
		this.empname = s.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		String i= password;
		this.password = i.replaceAll("\\s+","");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}






	@Override
	public String toString() {
		return "EmployeeData [empname=" + empname + ", password=" + password + ", email=" + email + ", designation="
				+ designation + ", phone=" + phone + ", mid=" + mid + ", id=" + id + "]";
	}
	
	
	
	
	
}
