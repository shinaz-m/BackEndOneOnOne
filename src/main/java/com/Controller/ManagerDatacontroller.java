package com.Controller;

import java.util.List;

import javax.transaction.Transactional;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.w@Api(value="Employee Data Controller")eb.bind.annotation.RestController;

import com.Services.ManagerDataServices;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.ManHr;
import com.nineleaps.OneonOne.Mn_create;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//import antlr.collections.List;

import com.nineleaps.OneonOne.Employeegoals;

@Transactional
@RestController
@Api(value="Manager Data Controller")

@CrossOrigin

public class ManagerDatacontroller {
	@Autowired
	private ManagerDataServices mng;
	
	@RequestMapping(path="/add_mng",method=RequestMethod.POST) 
	@ApiOperation(value="Priviledge for super user to add manager .")
	public Mn_create AddMngVal(@RequestBody Mn_create z) {
		return mng.man(z);
	}
	
	
	@RequestMapping(path="/emp_progress",method=RequestMethod.POST) 
	@ApiOperation(value=" display 12 month digital values based on progress of month.")
	public Iterable<JSONObject> emp_progress(@RequestBody JSONObject id)
	{
		//JSONObject j=new JSONObject(id);
		int eid=(int)id.get("id");
		return mng.emp_prog(eid);
	}
	
	@RequestMapping(path="/updatemonthvalue",method=RequestMethod.PATCH)
	@ApiOperation(value=" upload 12 month digital values based on progress of month.")
	public Iterable<JSONObject> updatemonth(@RequestBody JSONObject m)
	{
		String month=(String)m.get("month");
		int id=(int)m.get("id");
 		return mng.updatemonth(month,id);
		
	}
	
	@RequestMapping(path="/qanda_dynamic",method=RequestMethod.POST)
	@ApiOperation(value=" Fill dynamic question and answer for a particular id based on question count.")	
	public void QAns(@RequestBody List<JSONObject> q) throws Exception
	{   
		 try
		 {int size = q.size();
	        JSONObject object[] = new JSONObject[size];
	     //   System.out.println(size);
	        for(int i=0;i<size;i++)
	        {
	            object[i]=new JSONObject(q.get(i));
	        }
	        
	        mng.qandadynamic(object);
		 }catch(Exception e) {}
	}

	
	//public void startupdate(JSONObject obj[]) {
	        	
	
	
	@RequestMapping(path="/qanda_static",method=RequestMethod.POST) 
	@ApiOperation(value=" Fill five static question and answer for a particular id .")
	public Iterable<JSONObject> QAns1(@RequestBody JSONObject qq) 
	{
		int id=(int)qq.get("id");
		String q1=(String)qq.get("q1");
		String a1=(String)qq.get("a1");
		String q2=(String)qq.get("q2");
		String a2=(String)qq.get("a2");
		String q3=(String)qq.get("q3");
		String a3=(String)qq.get("a3");
		String q4=(String)qq.get("q4");
		String a4=(String)qq.get("a4");
		String q5=(String)qq.get("q5"); 
		String a5=(String)qq.get("a5");
		String month=(String)qq.get("month");
		return mng.qandstatic(id,q1,a1,q2,a2,q3,a3,q4,a4,q5,a5,month);
	}
	
	
	@RequestMapping(path="/add_goals",method=RequestMethod.POST) 
	@ApiOperation(value=" Fill Goals for a particular id .")
	public void AddMthVal(@RequestBody List<JSONObject> g)
	{
		int size = g.size();
        JSONObject object[] = new JSONObject[size];
        System.out.println(size);
        for(int i=0;i<size;i++)
        {
            object[i]=new JSONObject(g.get(i));
        }
	    mng.goal(object);
	}





}
