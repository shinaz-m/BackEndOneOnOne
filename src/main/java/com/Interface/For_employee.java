package com.Interface;

import org.json.simple.JSONObject;

import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Hr__view;
import com.nineleaps.OneonOne.Mn_create;

//import com.nineleaps.SignUpApi.UserData;

public interface For_employee {
	public Iterable<JSONObject> allemps();
	public Iterable<EmployeeData> allusers(); 
	public Iterable<EmployeeData> droplist();
	//public Hr__view val(Hr__view x);
	public String add(EmployeeData u);
	public void addMem(EmployeeData m);
	public void DropMem(EmployeeData d);
	//public void authenticate(EmployeeData user);
//	public Iterable<JSONObject> listemps(JSONObject l);
	//public boolean check();
}

