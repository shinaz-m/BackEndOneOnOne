package com.Services;

import java.security.Timestamp;
import java.sql.Date;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Transactional
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
	QuestionandAnswer qq6= new QuestionandAnswer();
	
	
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
		
		return er.allqanda(id);	
		
		
	
		//mv.setId(id);
	//	ManagerDataRepository.save(mv);
		}
	
	
	
	int id1=qq5.getQid();
	
	public void qandstatic(int id, String q1, String a1, String q2, String a2, String q3, String a3, String q4,
			String a4, String q5, String a5) {
		
		long Mil=System.currentTimeMillis();
		Date d=new Date(Mil);
	
		
		qq1.setId(id);qq1.setQues(q1);qq1.setAns(a1);qq1.setQno(1);qq1.setQtime(d.toString());qq1.setQid(id1++);
		//q2,a2,q3,a3,q4,a4,q5,a5
		 qq2.setId(id);qq2.setQues(q2);qq2.setAns(a2);qq2.setQno(2);qq2.setQtime(d.toString());qq2.setQid(id1++);
		 qq3.setId(id);qq3.setQues(q3);qq3.setAns(a3);qq3.setQno(3);qq3.setQtime(d.toString());qq3.setQid(id1++);
		 qq4.setId(id);qq4.setQues(q4);qq4.setAns(a4);qq4.setQno(4);qq4.setQtime(d.toString());qq4.setQid(id1++);
		 qq5.setId(id);qq5.setQues(q5);qq5.setAns(a5);qq5.setQno(5);qq5.setQtime(d.toString());qq5.setQid(id1++);
		 mqanda.save(qq1);
		 mqanda.save(qq2);
		 mqanda.save(qq3);
		 mqanda.save(qq4);
		 mqanda.save(qq5);
	}
	
	int id2=qq6.getQid();
	int qn=6;
	
	public void qandsdynamic(int id, String ques, String ans,String remark) {
		
		
		long Mil=System.currentTimeMillis();
		Date o=new Date(Mil);
		int qn=ManagerDataRepository.idcount(id);
		
		//qq6.setQtime(o.toString());
		//id2++;
		 qq6.setId(id);qq6.setQues(ques);qq6.setAns(ans);qq6.setQno(qn);qq6.setRemark(remark);qq6.setQtime(o.toString());qq6.setQid(id2++);
          qn++;
         // System.out.println(qq6.getPques());
          mqanda.save(qq6);
	}

	public void goal(int id, String goal, String gtime) {
		gg.setId(id);gg.setGoal(goal);gg.setGtime(gtime);
		emprepo.save(gg)	;
	}


	

		
	}

	
	
	
