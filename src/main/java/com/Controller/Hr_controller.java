package com.Controller;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.Services.EmployeeDataServices;
import com.Services.HRDataServices;
@Transactional
@RestController
@CrossOrigin
public class Hr_controller {
	
	@Autowired
	private HRDataServices hrs ;
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
	@RequestMapping(path="/hrviewall",method=RequestMethod.GET)
	public Iterable<JSONObject> hrviewall()
	{
		return hrs.viewall();
		
	}
	@RequestMapping(path="/hremployeeidview",method=RequestMethod.GET)
	public Iterable<JSONObject> hrempid()
	{
		return hrs.viewempid();
	}
}
