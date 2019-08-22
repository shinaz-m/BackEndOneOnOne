package com.Services;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataRepositories.ManagerDataRepository;
import com.Interface.For_mng;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.month_values;

//@Transactional
@Service
public class ManagerDataServices implements For_mng{
	@Autowired
	private com.DataRepositories.Addmng Addmng;
	
	@Autowired
	public ManagerDataRepository ManagerDataRepository;
	 
	public month_values mv=new month_values();
	public Mn_create man(Mn_create z) {
		 return Addmng.save(z);
	 }
	
	public Iterable<JSONObject> emp_prog(int id) {
		// TODO Auto-generated method stub
		return ManagerDataRepository.emp_prog(id);
	}

	public void updatemonth(String month, int id) {
		// TODO Auto-generated method stub
		
		if(month.equals("jan"))
		mv.setJan(1);
		else if(month.equals("feb"))
		mv.setFeb(1);
		else if(month.equals("mar"))
		mv.setMar(1);
		else if(month.equals("apr"))
		mv.setApr(1);
		else if(month.equals("may"))
		mv.setMay(1);
		else if(month.equals("jun"))
		mv.setJune(1);
		else if(month.equals("july"))
		mv.setJuly(1);
		else if(month.equals("aug"))
		mv.setAug(1);
		else if(month.equals("sep"))
		mv.setSep(1);
		else if(month.equals("oct"))
		mv.setOct(1);
		else if(month.equals("nov"))
		mv.setNov(1);
		else if(month.equals("december"))
		mv.setDecember(1);
				
		mv.setId(id);
		ManagerDataRepository.save(mv);
		}
		
	}

	
	
	
