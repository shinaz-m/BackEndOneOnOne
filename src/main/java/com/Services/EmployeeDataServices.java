package com.Services;

import java.util.Optional;

import com.Controller.*;
import com.DataRepositories.*;
import com.Interface.For_employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.OneonOne.EmployeeData;
//import com.nineleaps.SignUpApi.UserData;
//import com.nineleaps.SignUpApi.ProjectIdAndName;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.egoal;
import com.nineleaps.OneonOne.month_values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Transactional
@Service
public class EmployeeDataServices implements For_employee {
//class UserDataServices implements ProjectIdAndName{	
	private static final String number="(^$|[0-9]{10})";
	private Pattern pattern;
	private Matcher matcher;
	
	 ObjectMapper Obj = new ObjectMapper(); 
	//EmployeeDataServices Iterable<a>=new EmployeeDataServices();
	
	String s,s1,e; 
	@Autowired
	private EmployeeDataRepository EmployeeDataRepository;
	//private empgoalsRepository emprepo;
	@Autowired
	private ManagerDataRepository mr;
	public month_values mv=new month_values();
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	
	public Iterable<EmployeeData> allusers()
	{
		return  EmployeeDataRepository.findAll();
	}
	
	
	
	 public Iterable<JSONObject>  allemps(){
		 return EmployeeDataRepository.emps_list();	   
		   }
	
	
	 
	 public Iterable<JSONObject> listemps(int l){
		// System.out.println(l);
		 return EmployeeDataRepository.mng_list(l);
		    	 }
	
	 
	 
	 public Iterable<EmployeeData> droplist(){
		 return EmployeeDataRepository.drplist();
	 }
	
	 
	 
	public void addMem(EmployeeData m)
	{
	 EmployeeDataRepository.AddMem(m.getEmail(),m.getId());
	}
	
	 
	
	public void DropMem(EmployeeData d)
	{
    EmployeeDataRepository.dropMem(d.getEmpname());
	}
	 
	
	
	 
	public String add(EmployeeData u)
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		pattern = Pattern.compile(number);
		matcher = pattern.matcher(String.valueOf(u.getPhone()));
	//	boolean pass=matcher.matches();
		String existing = EmployeeDataRepository.findByEmail(u.getEmail());
		String encoded_pass = encoder.encode(u.getPassword());
		boolean password_match = matcher.matches();
				
				if(password_match && existing==null)
		{
					u.setPassword(encoded_pass);
					EmployeeDataRepository.save(u);
					int id=EmployeeDataRepository.getid(u.getEmail());
					mv.setId(id);
					//EmployeeDataRepository.month_valueupdate(id);
					mr.save(mv);
					return "succesful";
		}
		
		else
		{
			return "existing";
		}
	}
	
	
	
	
	public JSONObject authenticate(String email,String password)
	{
		String l=EmployeeDataRepository.findByEmail(email);
		if(encoder.matches(password,l))
		{
			return EmployeeDataRepository.profile(email);
	}
		else
		{
			return null;
		}
	
	}



	public Iterable<JSONObject> viewqanda(int id) {
		return EmployeeDataRepository.allqanda(id);
	}



	public Iterable<JSONObject> viewgoal(int g) {
		// TODO Auto-generated method stub
		
			 return mr.goallist(g);
		 }
	}

	

