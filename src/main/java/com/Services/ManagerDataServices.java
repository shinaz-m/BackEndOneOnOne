package com.Services;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import com.DataRepositories.ManagerDataRepository;
import com.DataRepositories.ManagerQuestionandAnswerRepository;
import com.DataRepositories.EmployeeDataRepository;
import com.DataRepositories.EmployeegoalsRepository;
import com.Interface.For_mng;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.QuestionandAnswer;
import com.nineleaps.OneonOne.Employeegoals;
import com.nineleaps.OneonOne.month_values;

@Transactional()
@Service
public class ManagerDataServices implements For_mng{
	@Autowired
	private com.DataRepositories.Addmng Addmng;
	
	@Autowired
	public ManagerDataRepository ManagerDataRepository;
	@Autowired
	private ManagerQuestionandAnswerRepository mqanda;
	@Autowired
	private EmployeegoalsRepository emprepo;
	@Autowired
	private EmployeeDataRepository er;
	QuestionandAnswer qq1= new QuestionandAnswer();
	QuestionandAnswer qq2= new QuestionandAnswer();
	QuestionandAnswer qq3= new QuestionandAnswer();
	QuestionandAnswer qq4= new QuestionandAnswer();
	QuestionandAnswer qq5= new QuestionandAnswer();
	
	
	
	Employeegoals gg=new Employeegoals();
	
	public month_values mv=new month_values();
	public Mn_create man(Mn_create z) {
		 return Addmng.save(z);
	 }
	
	public Iterable<JSONObject> emp_prog(int id) {
		
		return ManagerDataRepository.emp_prog(id);
	}

	public Iterable<JSONObject> updatemonth(String month, int id) {
		
		
		if(month.equals("jan"))
			ManagerDataRepository.jan(id);
			else if(month.equals("feb"))
			ManagerDataRepository.feb(id);
			else if(month.equals("mar"))
			ManagerDataRepository.mar(id);
			else if(month.equals("apr"))
			ManagerDataRepository.apr(id);
			else if(month.equals("may"))
			ManagerDataRepository.may(id);
			else if(month.equals("june"))
			ManagerDataRepository.june(id);
			else if(month.equals("july"))
			ManagerDataRepository.july(id);
			else if(month.equals("aug"))
			ManagerDataRepository.aug(id);
			else if(month.equals("sep"))
			ManagerDataRepository.sept(id);
			else if(month.equals("oct"))
			ManagerDataRepository.oct(id);
			else if(month.equals("nov"))
			ManagerDataRepository.nov(id);
			else if(month.equals("december"))
			ManagerDataRepository.dec(id);
	
		//if(ManagerDataRepository.idcount(id)>0)
		
		return er.allqanda(id,month);	
		}

	
	public Iterable<JSONObject> qandstatic(int id, String q1, String a1, String q2, String a2, String q3, String a3, String q4,
			String a4, String q5, String a5,String month){
	
		Timestamp Mil=new Timestamp(System.currentTimeMillis());
		int id1=0;
		int count=ManagerDataRepository.idcount(id,month);
		if(count>0) {
			id1=ManagerDataRepository.findqid(id,1,month);
			System.out.println(id1);
		}
		qq1.setId(id);qq1.setQues(q1);qq1.setAns(a1);qq1.setQno(1);qq1.setQtime(Mil);qq1.setQid(id1++);qq1.setMonth(month);qq1.setType("s");
		 qq2.setId(id);qq2.setQues(q2);qq2.setAns(a2);qq2.setQno(2);qq2.setQtime(Mil);qq2.setQid(id1++);qq2.setMonth(month);qq2.setType("s");
		 qq3.setId(id);qq3.setQues(q3);qq3.setAns(a3);qq3.setQno(3);qq3.setQtime(Mil);qq3.setQid(id1++);qq3.setMonth(month);qq3.setType("s");
		 qq4.setId(id);qq4.setQues(q4);qq4.setAns(a4);qq4.setQno(4);qq4.setQtime(Mil);qq4.setQid(id1++);qq4.setMonth(month);qq4.setType("s");
		 qq5.setId(id);qq5.setQues(q5);qq5.setAns(a5);qq5.setQno(5);qq5.setQtime(Mil);qq5.setQid(id1++);qq5.setMonth(month);qq5.setType("s");
		 mqanda.save(qq1);
		 mqanda.save(qq2);
		 mqanda.save(qq3);
		 mqanda.save(qq4);
		 mqanda.save(qq5);
		 return er.allqanda(id,month);	
			
	}

	
	public void goal(JSONObject[] g) {
		
		for(int i=0;i<g.length;i++)
        {
			int gid=gg.getGid();
			int id=(int)g[i].get("id");
			String goal=(String)g[i].get("goal");
			String gtime=(String)g[i].get("deadline");
     		gg.setId(id);gg.setGoal(goal);gg.setGtime(gtime);gg.setGid(++gid);
     		emprepo.save(gg);
	}}

	public void qandadynamic(JSONObject[] object) {
	//	System.out.println("hello");
	//	int id2;
		int qno=6;
		//System.out.println(qq5.getQid());
			for(int i=0;i<object.length;i++)
        {
			System.out.println(i);
        	int id=(int)object[i].get("id");
        	String ques=(String)object[i].get("ques");
        	String ans=(String)object[i].get("ans");
        	String remark=(String)object[i].get("remark");
        	String month=(String)object[i].get("month");

        	try {
        	int exist=ManagerDataRepository.exist(id,month,qno);
        	System.out.println(exist);
           	if(exist==0)
        	{
           		System.out.println("new");
           		
        		//ManagerDataRepository.createdynamic(id,ques,ans,remark,month,qno);
           		Timestamp Mil=new Timestamp(System.currentTimeMillis());
           		QuestionandAnswer qq6= new QuestionandAnswer();
           		qq6.setId(id);qq6.setQues(ques);qq6.setAns(ans);qq6.setQno(qno);qq6.setRemark(remark);
           		qq6.setQtime(Mil);qq6.setMonth(month);qq6.setType("d");
                mqanda.save(qq6);
        		//qno++;
        	}
           	else if(exist==1)
        	{
            		System.out.println("old");
        		ManagerDataRepository.updatedynamic(id,ques,ans,remark,month,qno);
        		      	}
           	qno++;
        	}
        	catch(Exception e)
        	{
        		System.out.println(e);
        	}
//       	int count=ManagerDataRepository.idcount(id,month);
//       	System.out.println(count);
//       	QuestionandAnswer qq6= new QuestionandAnswer(); 
//    	Timestamp Mil=new Timestamp(System.currentTimeMillis());
//    	  if(count>5) 
//      	{
//      		id2=ManagerDataRepository.findqid(id,qno,month);
//      		System.out.println(id2);
//      		qq6.setQid(id2);}
//    	
//		//int qn=ManagerDataRepository.idcount(id,month);
//		qq6.setId(id);qq6.setQues(ques);qq6.setAns(ans);qq6.setQno(qno++);qq6.setRemark(remark);
//		qq6.setQtime(Mil);qq6.setMonth(month);qq6.setType("d");
//        mqanda.save(qq6);
//
    	        	
        }
	}
}


	

		
	

	
	
	
