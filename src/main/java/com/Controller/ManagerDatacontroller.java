package com.Controller;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Services.ManagerDataServices;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;

@Transactional
@RestController
@CrossOrigin

public class ManagerDatacontroller {
	@Autowired
	private ManagerDataServices mng;
	@RequestMapping(path="/add_mng",method=RequestMethod.POST) 
	public Mn_create AddMngVal(@RequestBody Mn_create z) {
		return mng.man(z);
	}
	
	
	@RequestMapping(path="/emp_progress",method=RequestMethod.POST) 
	public Iterable<JSONObject> emp_progress(@RequestBody JSONObject id)
	{
		//JSONObject j=new JSONObject(id);
		int eid=(int)id.get("id");
		return mng.emp_prog(eid);
	}
	
	@RequestMapping(path="/updatemonthvalue",method=RequestMethod.PATCH)
	public void updatemonth(@RequestBody JSONObject m)
	{
		String month=(String)m.get("month");
		int id=(int)m.get("id");
 		mng.updatemonth(month,id);
	}
}
