package com.Controller;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.Services.EmployeeDataServices;
import com.Services.HRDataServices;

import io.swagger.annotations.ApiOperation;
@Transactional
@RestController
@CrossOrigin
public class Hr_controller {
	
	@Autowired
	private HRDataServices hrs ;
	
	@ApiOperation(value = "To view employee progres based on the criteria")
	@RequestMapping(path="/hr",method=RequestMethod.POST) 
	public Iterable<JSONObject> AddMthVal(@RequestBody JSONObject x)
	{
		String id=(String)x.get("id");
		String month=(String)x.get("month");
		String progress=(String)x.get("progress");
		System.out.println(id+"\t"+month+"\t"+progress);
		//if(id==null)
		return hrs.view(id,month,progress);	
		}
	
	@ApiOperation(value = "To view the progress of all employees")
	@RequestMapping(path="/hrviewall",method=RequestMethod.GET)
	public Iterable<JSONObject> hrviewall()
	{
		return hrs.viewall();
		
	}
	
	@ApiOperation(value = "To view the ids of all employees")
	@RequestMapping(path="/hremployeeidview",method=RequestMethod.GET)
	public Iterable<JSONObject> hrempid()
	{
		return hrs.viewempid();
	}
	
	@ApiOperation(value = "To pass the timestamp of a user")
	@RequestMapping(path="/employeetimestamp/{id}/{month}",method=RequestMethod.GET)
	public JSONObject employeetimestamp(@PathVariable(value="id")String id,@PathVariable(value="month")String month)
	{
		return hrs.employetimestamp(id, month);
	}
}
