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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.nineleaps.OneonOne.Employeegoals;

@Transactional
@RestController
@CrossOrigin
@Api(value="Employee Data Controller")
@ApiResponses(
        value = {
                
                @ApiResponse(code = 200, message = "Successfully Executed"),
                @ApiResponse(code = 400, message = "Token not found"),
                @ApiResponse(code = 404, message = "Wrong Api Path")
})
public class EmployeeDataController {

	@Autowired
	private EmployeeDataServices usd ;
	
	
	@ApiOperation(value="Display all the existing employees")
	@RequestMapping(path="/employees",method=RequestMethod.GET) 
	public Iterable<EmployeeData> findUsers()
	{
		return usd.allusers();
	}
    
	@ApiOperation(value = "To Display all the employees")
	@RequestMapping(path="/emps_list",method=RequestMethod.GET) 
	public Iterable<JSONObject> findEmps ()
	{
		return usd.allemps();
	}
	
	@ApiOperation(value = "To Display reportees under a particular manager")
	@RequestMapping(path="/mng_list",method=RequestMethod.POST) 
	public Iterable<JSONObject> findEmpos(@RequestBody EmployeeData l)
	{
		return usd.listemps(l.getMid());
	}
	
	@ApiOperation(value = "TO Register a new employee to database")
	@RequestMapping(path="/employee",method=RequestMethod.POST) 
	public String AddNewUser(@RequestBody EmployeeData u)
	{
		return usd.add(u);
	}
	
	@ApiOperation(value = "To add a reportee under manager id")
	@RequestMapping(path="/addformng",method=RequestMethod.PATCH) 
	public void AddNewMem(@RequestBody EmployeeData m)
	{
		usd.addMem(m);
	}
	
	@ApiOperation(value = "To delete a reportee for a particular manager")
	@RequestMapping(path="/dropformng",method=RequestMethod.PATCH) 
	public void DelOneMem(@RequestBody EmployeeData d)
	{
		usd.DropMem(d);
	}
	
	@ApiOperation(value = "To display all the un-assigned employees so that the manager could could add him")
	@RequestMapping(path="/mngdroplist",method=RequestMethod.GET) 
	public Iterable<EmployeeData> findmlist ()
	{
		return usd.droplist();
	}
	
	@ApiOperation(value = "To view goals for a particular employee")
	@RequestMapping(path="/viewgoal",method=RequestMethod.POST) 
	public Iterable<JSONObject> goallist(@RequestBody Employeegoals g )
	{
		return usd.viewgoal(g.getId());
	}

	
	@ApiOperation(value = "It will verify the user ad grants him access")
	@RequestMapping(path="/login",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<JSONObject> Authenticate(@RequestBody JSONObject user) {
		//JSONObject j=new JSONObject(user);
		String email=(String)user.get("email");
		String password=(String)user.get("password");
		return usd.authenticate(email,password);
		
	}
	
	@ApiOperation(value = "To view all the feedback of employee")
	@RequestMapping(path="/viewqanda",method=RequestMethod.POST) 
	public Iterable<JSONObject> viewqanda(@RequestBody JSONObject idget){
		int id=(int)idget.get("id");
		String month=(String)idget.get("month");
		return usd.viewqanda(id,month);
	}
	
	
	
}
