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
import com.nineleaps.OneonOne.ManHr;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.egoal;

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
	
	@RequestMapping(path="/qanda_dynamic",method=RequestMethod.POST) 
	public void QAns(@RequestBody JSONObject q) 
	{   
		int id=(int)q.get("id");
		String ques=(String)q.get("q1");
		String ans=(String)q.get("a1");
		String remark=(String)q.get("rmk");
		mng.qandsdynamic(id,ques,ans,remark);
	}
	
	@RequestMapping(path="/qanda_static",method=RequestMethod.POST) 
	public void QAns1(@RequestBody JSONObject qq) 
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
		 mng.qandstatic(id,q1,a1,q2,a2,q3,a3,q4,a4,q5,a5);
	}
	
	
	@RequestMapping(path="/add_goals",method=RequestMethod.POST) 
	public void AddMthVal(@RequestBody JSONObject g)
	{
		int id=(int)g.get("id");
		String goal=(String)g.get("goal");
		String gtime=(String)g.get("gtime");
	    mng.goal(id,goal,gtime);
	}





}
