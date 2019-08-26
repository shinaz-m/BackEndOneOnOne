package com.Controller;
 
import java.util.Optional;
import com.DataRepositories.*;
import com.Services.*;
import com.nineleaps.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Services.EmployeeDataServices;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.ManHr;
//import com.nineleaps.SignUpApi.UserData;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.Employeegoals;

@Transactional
@RestController
@CrossOrigin
public class EmployeeDataController {

	@Autowired
	private EmployeeDataServices usd ;
	
	

	@RequestMapping(path="/employees",method=RequestMethod.GET) 
	public Iterable<EmployeeData> findUsers()
	{
		return usd.allusers();
	}
    
	@RequestMapping(path="/emps_list",method=RequestMethod.GET) 
	public Iterable<JSONObject> findEmps ()
	{
		return usd.allemps();
	}
	
	@RequestMapping(path="/mng_list",method=RequestMethod.POST) 
	public Iterable<JSONObject> findEmpos(@RequestBody EmployeeData l)
	{
		return usd.listemps(l.getMid());
	}
	
	
	@RequestMapping(path="/employee",method=RequestMethod.POST) 
	public String AddNewUser(@RequestBody EmployeeData u)
	{
		return usd.add(u);
	}
	
	@RequestMapping(path="/addformng",method=RequestMethod.PATCH) 
	public void AddNewMem(@RequestBody EmployeeData m)
	{
		usd.addMem(m);
	}
	
	@RequestMapping(path="/dropformng",method=RequestMethod.PATCH) 
	public void DelOneMem(@RequestBody EmployeeData d)
	{
		usd.DropMem(d);
	}
	
	
	@RequestMapping(path="/mngdroplist",method=RequestMethod.GET) 
	public Iterable<EmployeeData> findmlist ()
	{
		return usd.droplist();
	}
	
	@RequestMapping(path="/viewgoal",method=RequestMethod.POST) 
	public Iterable<JSONObject> goallist(@RequestBody Employeegoals g )
	{
		return usd.viewgoal(g.getId());
	}

	
	
	@RequestMapping(path="/login",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<JSONObject> Authenticate(@RequestBody JSONObject user) {
		//JSONObject j=new JSONObject(user);
		String email=(String)user.get("email");
		String password=(String)user.get("password");
		return usd.authenticate(email,password);
		
	}
	
	@RequestMapping(path="/viewqanda",method=RequestMethod.POST) 
	public Iterable<JSONObject> viewqanda(@RequestBody JSONObject idget){
		int id=(int)idget.get("id");
		return usd.viewqanda(id);
	}
	
	
	
}
