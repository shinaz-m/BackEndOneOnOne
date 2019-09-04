package com.Controller;

import java.util.List;

import javax.transaction.Transactional;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
   
import com.Services.ManagerDataServices;
import com.nineleaps.OneonOne.EmployeeData;
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
	
	
	@RequestMapping(path="/emp_progress",method=RequestMethod.POST) 
	@ApiOperation(value=" display 12 month digital values based on progress of month.")
	public Iterable<JSONObject> emp_progress(@RequestBody JSONObject id)
	{
		//JSONObject j=new JSONObject(id);
		int eid=(int)id.get("id");
		return mng.emp_prog(eid);
	}
	
	@RequestMapping(path="/updatemonthvalue/{id}/{month}",method=RequestMethod.POST)
	@ApiOperation(value=" upload 12 month digital values based on progress of month.")
	public Iterable<JSONObject> updatemonth(@PathVariable (value="id") int id,@PathVariable(value="month")String month)
	{
		return mng.updatemonth(month,id);
		
	}
	
	@RequestMapping(path="/qanda_dynamic/{id}/{month}",method=RequestMethod.POST)
	@ApiOperation(value=" Fill dynamic question and answer for a particular id based on question count.")	
	public void QAns(@RequestBody List<JSONObject> q,@PathVariable (value="id") int id,@PathVariable(value="month")String month) throws Exception
	{   
		 try
		 {int size = q.size();
	        JSONObject object[] = new JSONObject[size];
	     //   System.out.println(size);
	        for(int i=0;i<size;i++)
	        {
	            object[i]=new JSONObject(q.get(i));
	        }
	        
	        mng.qandadynamic(object,id,month);
		 }catch(Exception e) {}
	}

	
	//public void startupdate(JSONObject obj[]) {
	        	
	
	
	@RequestMapping(path="/qanda_static/{id}/{month}",method=RequestMethod.POST) 
	@ApiOperation(value=" Fill five static question and answer for a particular id .")
	public Iterable<JSONObject> QAns1(@RequestBody JSONObject qq,@PathVariable (value="id") int id,@PathVariable(value="month")String month) 
	{
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
		return mng.qandstatic(id,q1,a1,q2,a2,q3,a3,q4,a4,q5,a5,month);
	}
	
	
	@RequestMapping(path="/addgoals/{id}/{month}",method=RequestMethod.POST) 
	@ApiOperation(value=" Fill Goals for a particular id .")
	public void AddMthVal(@RequestBody List<JSONObject> g,@PathVariable (value="id") int id,@PathVariable(value="month")String month)
	{
		int size = g.size();
        JSONObject object[] = new JSONObject[size];
        System.out.println(size);
        for(int i=0;i<size;i++)
        {
            object[i]=new JSONObject(g.get(i));
        }
	    mng.goal(object,id,month);
	}

	@ApiOperation(value = "To Display reportees under a particular manager")
	@RequestMapping(path="/mng_list/{id}",method=RequestMethod.GET) 
	public Iterable<JSONObject> findEmpos(@PathVariable (value="id") int id)
	{
		return mng.listemps(id);
	}
	
	@ApiOperation(value = "To add a reportee under manager id")
	@RequestMapping(path="/addformng",method=RequestMethod.PATCH) 
	public void AddNewMem(@RequestBody EmployeeData m)
	{
		mng.addMem(m);
	}
	
	@ApiOperation(value = "To delete a reportee for a particular manager")
	@RequestMapping(path="/dropformng",method=RequestMethod.PATCH) 
	public void DelOneMem(@RequestBody EmployeeData d)
	{
		mng.DropMem(d);
	}
	




}
