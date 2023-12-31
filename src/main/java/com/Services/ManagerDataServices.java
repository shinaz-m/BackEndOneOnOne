package com.Services;
import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DataRepositories.ManagerDataRepository;
import com.DataRepositories.ManagerQuestionandAnswerRepository;
import com.DataRepositories.EmployeeDataRepository;
import com.DataRepositories.EmployeegoalsRepository;
import com.nineleaps.OneonOne.QuestionandAnswer;
import com.nineleaps.OneonOne.Employeegoals;
import com.nineleaps.OneonOne.month_values;

@Transactional()
@Service
public class ManagerDataServices{
	
	@Autowired
	public ManagerDataRepository ManagerDataRepository;
	@Autowired
	public EmployeeDataRepository EmployeeDataRepository;
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
		
	public Iterable<JSONObject> emp_prog(int id)
	{
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
			return er.allqanda(id,month);	
		}

	
	public Iterable<JSONObject> qandstatic(int id, String q1, String a1, String q2, String a2, String q3, String a3, String q4,
			String a4, String q5, String a5,String month)
		{
		Timestamp Mil=new Timestamp(System.currentTimeMillis());
		int id1=0;
		int count=ManagerDataRepository.idcount(id,month);
		if(count>0) {
			id1=ManagerDataRepository.findqid(id,1,month);
			Timestamp a=ManagerDataRepository.getTime(id,1,month);
			qq1.setTime(a);
			System.out.println(id1);
		}
		else qq1.setTime(Mil);
		qq1.setId(id);qq1.setQuestion(q1);qq1.setAnswer(a1);qq1.setQno(1);qq1.setQid(id1++);qq1.setMonth(month);qq1.setType("s");
		 qq2.setId(id);qq2.setQuestion(q2);qq2.setAnswer(a2);qq2.setQno(2);qq2.setTime(Mil);qq2.setQid(id1++);qq2.setMonth(month);qq2.setType("s");
		 qq3.setId(id);qq3.setQuestion(q3);qq3.setAnswer(a3);qq3.setQno(3);qq3.setTime(Mil);qq3.setQid(id1++);qq3.setMonth(month);qq3.setType("s");
		 qq4.setId(id);qq4.setQuestion(q4);qq4.setAnswer(a4);qq4.setQno(4);qq4.setTime(Mil);qq4.setQid(id1++);qq4.setMonth(month);qq4.setType("s");
		 qq5.setId(id);qq5.setQuestion(q5);qq5.setAnswer(a5);qq5.setQno(5);qq5.setTime(Mil);qq5.setQid(id1++);qq5.setMonth(month);qq5.setType("s");
		 mqanda.save(qq1);
		 mqanda.save(qq2);
		 mqanda.save(qq3);
		 mqanda.save(qq4);
		 mqanda.save(qq5);
		 return er.allqanda(id,month);		
		}

	
	public void goal(JSONObject[] g, int id, String month) {
		int gno=1;
		for(int i=0;i<g.length;i++)
        {
			int gid=gg.getGid();
			String goal=(String)g[i].get("goal");
			String gtime=(String)g[i].get("deadline");
			
			int existgoal=ManagerDataRepository.existgoal(id,month,gno);
						
			if(existgoal==0)
			{
				
     		gg.setId(id);gg.setGoal(goal);gg.setGoaltime(gtime);gg.setGid(++gid);gg.setMonth(month);gg.setGoalno(gno);
     		emprepo.save(gg);
			}
			else if(existgoal==1)
			{
				ManagerDataRepository.updategoal(id,goal,gtime,month,gno);
			}
			gno++;
        }
		}

	public void qandadynamic(JSONObject[] object,int id, String month) {
		int qno=6;
			for(int i=0;i<object.length;i++)
        {
			System.out.println(i);
        	String ques=(String)object[i].get("question");
        	String ans=(String)object[i].get("answer");
        	String remark=(String)object[i].get("remark");
        	
        	try {
        	int exist=ManagerDataRepository.exist(id,month,qno);
        	System.out.println(exist);
           	if(exist==0)
        	{
           		System.out.println("new");
           		
        		//ManagerDataRepository.createdynamic(id,ques,ans,remark,month,qno);
           		Timestamp Mil=new Timestamp(System.currentTimeMillis());
           		QuestionandAnswer qq6= new QuestionandAnswer();
           		qq6.setId(id);qq6.setQuestion(ques);qq6.setAnswer(ans);qq6.setQno(qno);qq6.setRemark(remark);
           		qq6.setTime(Mil);qq6.setMonth(month);qq6.setType("d");
                mqanda.save(qq6);
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
        }
	}
	
	 public Iterable<JSONObject> listemps(int l){
		 return EmployeeDataRepository.mng_list(l);
		 }
		
	 public void addMem(int mid,int id)
		{
		 EmployeeDataRepository.AddMem(mid,id);
		}
		
		 		
		public void DropMem(int id)
		{
	    EmployeeDataRepository.dropMem(id);
		}
		 
	
}


	

		
	

	
	
	
