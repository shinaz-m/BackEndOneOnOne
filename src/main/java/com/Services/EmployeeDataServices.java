package com.Services;

import java.util.Optional;



import com.Controller.*;
import com.DataRepositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.OneonOne.EmployeeData;
//import com.nineleaps.SignUpApi.UserData;
//import com.nineleaps.SignUpApi.ProjectIdAndName;
import com.nineleaps.OneonOne.month_values;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Transactional
@Service
public class EmployeeDataServices {
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
	
	
	
	
	public ResponseEntity<JSONObject> authenticate(String email,String password)
	{
		String l=EmployeeDataRepository.findByEmail(email);
		JSONObject var=new JSONObject();
		if(encoder.matches(password,l))
		{
		var=EmployeeDataRepository.profile(email);
		var.put("status","true");
			return new ResponseEntity<>(var,HttpStatus.OK);
	}
		else
		{
			var.put("status","false");
			return new ResponseEntity<>(var,HttpStatus.OK);
		}
	
	}



	public Iterable<JSONObject> viewqanda(int id,String month) {
		return EmployeeDataRepository.allqanda(id,month);
	}



	public Iterable<JSONObject> viewgoal(int g, String month) {
		// TODO Auto-generated method stub
		
			 return mr.goallist(g,month);
		 }
	}

	

