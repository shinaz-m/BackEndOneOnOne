package com.Services;

import java.security.Timestamp;
import java.sql.Date;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DataRepositories.ManagerDataRepository;
import com.DataRepositories.ManagerQuestionandAnswerRepository;
import com.Interface.For_mng;
import com.nineleaps.OneonOne.EmployeeData;
import com.nineleaps.OneonOne.Mn_create;
import com.nineleaps.OneonOne.QuestionandAnswer;
import com.nineleaps.OneonOne.month_values;

//@Transactional
@Service
public class ManagerDataServices implements For_mng{
	@Autowired
	private com.DataRepositories.Addmng Addmng;
	
	@Autowired
	public ManagerDataRepository ManagerDataRepository;
	@Autowired
	 public ManagerQuestionandAnswerRepository mqanda;
	
	QuestionandAnswer qq1=new QuestionandAnswer();
	QuestionandAnswer qq2= new QuestionandAnswer();
	QuestionandAnswer qq3= new QuestionandAnswer();
	QuestionandAnswer qq4= new QuestionandAnswer();
	QuestionandAnswer qq5= new QuestionandAnswer();
	QuestionandAnswer qq6= new QuestionandAnswer();
	
	int id1=qq5.getQid();
	int id2=qq5.getQid();
	
	//int qn=qq6.getQno();
	
	
	
	public month_values mv=new month_values();
	public Mn_create man(Mn_create z) {
		 return Addmng.save(z);
	 }
	
	public Iterable<JSONObject> emp_prog(int id) {
		// TODO Auto-generated method stub
		return ManagerDataRepository.emp_prog(id);
	}

	public void updatemonth(String month, int id) {
		// TODO Auto-generated method stub
		
		if(month.equals("jan"))
		mv.setJan(1);
		else if(month.equals("feb"))
		mv.setFeb(1);
		else if(month.equals("mar"))
		mv.setMar(1);
		else if(month.equals("apr"))
		mv.setApr(1);
		else if(month.equals("may"))
		mv.setMay(1);
		else if(month.equals("jun"))
		mv.setJune(1);
		else if(month.equals("july"))
		mv.setJuly(1);
		else if(month.equals("aug"))
		mv.setAug(1);
		else if(month.equals("sep"))
		mv.setSep(1);
		else if(month.equals("oct"))
		mv.setOct(1);
		else if(month.equals("nov"))
		mv.setNov(1);
		else if(month.equals("december"))
		mv.setDecember(1);
				
		mv.setId(id);
		ManagerDataRepository.save(mv);
		}

	public void qandsdynamic(int id, String ques, String ans) {
		// TODO Auto-generated method stub
		long Mil=System.currentTimeMillis();
		Date o=new Date(Mil);
		System.out.println(Mil);
		
	//	System.out.println(qn);
		
		int qn=ManagerDataRepository.idcount(id);
		System.out.println(qn);
		qn++;
        
//		System.out.println(id2);
		 qq6.setId(id);qq6.setQues(ques);qq6.setAns(ans);qq6.setQno(qn);qq6.setQtime(o.toString());
		 qq6.setQid(id2++);
          // System.out.println(qq6.getPques());
          mqanda.save(qq6);
	}

	
	
	public void qandstatic(int id, String q1, String a1, String q2, String a2, String q3, String a3, String q4,
			String a4, String q5, String a5) {
		// TODO Auto-generated method stub
		long Mil=System.currentTimeMillis();
		Date d=new Date(Mil);
	//	 int idd=qq5.getQid();
		int a=0;
	//	if(id1==0)id1=1;
		System.out.println(""+id+q1+q2+q3+q4+q5+"\n");
		qq1.setId(id);qq1.setQues(q1);qq1.setAns(a1);qq1.setQno(++a);qq1.setQtime(d.toString());
		qq1.setQid(id1++);
		mqanda.save(qq1);
		qq2.setId(id);qq2.setQues(q2);qq2.setAns(a2);qq2.setQno(2);qq2.setQtime(d.toString());
		qq2.setQid(id1++);
		 qq3.setId(id);qq3.setQues(q3);qq3.setAns(a3);qq3.setQno(3);qq3.setQtime(d.toString());
		qq3.setQid(id1++);
		 qq4.setId(id);qq4.setQues(q4);qq4.setAns(a4);qq4.setQno(4);qq4.setQtime(d.toString());
		 qq4.setQid(id1++);
		 qq5.setId(id);qq5.setQues(q5);qq5.setAns(a5);qq5.setQno(5);qq5.setQtime(d.toString());
		 qq5.setQid(id1++);
		 mqanda.save(qq2);
		 mqanda.save(qq3);
		 mqanda.save(qq4);
		 mqanda.save(qq5);
	}
		
	}

	
	
	
