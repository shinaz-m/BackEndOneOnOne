package com.nineleaps.OneonOne;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="emp_data")
//@SecondaryTable(name="employee_details", pkJoinColumns={
//        @PrimaryKeyJoinColumn(name="id", referencedColumnName="mid") })

//@SecondaryTable(name="employee_details")
public class EmployeeData {
	@Column(name="empname",table="emp_data")
//	@NotNull
//	@Size(min=5,max=30)

	private String empname;
	
	
	@Column(name="password",table="emp_data",length=255)
	@NotNull
	//@Size(min=5,max=30)
	private String password;
	
	@Column(name="email",table="emp_data")
	@NotNull
	private String email;

	@Column(name="Designation", columnDefinition="varchar(255) default 'employee'",table="emp_data")
	private String designation="employee";
	
	@Column(name="phone",table="emp_data")
	
	private String phone;
    @Column(name="mid",columnDefinition="int(11) default '0'",table="emp_data")
    @NotNull
    private int mid=0;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//@OneToMany(fetch=FetchType.LAZY,mappedBy="id")
	//private Set<month_values> id;
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="employee_details")
	//@JoinColumn(name="id")
	//private Set<EmployeeData> coachGroups = new HashSet<>();

	
	
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
