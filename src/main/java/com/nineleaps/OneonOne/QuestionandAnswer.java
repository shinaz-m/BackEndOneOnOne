package com.nineleaps.OneonOne;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="q_and_a")
public class QuestionandAnswer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "qid")  
	private int qid; 	
    
	
	@Column(name="id")
	private int id;
	
	@Column(name= "ques",columnDefinition="varchar(500)")
	private String ques;
    
	@Column(name= "ans",columnDefinition="varchar(500)")
	private String ans;
	
	@Column (name="qno")
	private int qno;
    
	@Column(name="qtime")
	private String qtime;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQtime() {
		return qtime;
	}

	public void setQtime(String qtime) {
		this.qtime = qtime;
	}

	@Override
	public String toString() {
		return "QuestionandAnswer [qid=" + qid + ", id=" + id + ", ques=" + ques + ", ans=" + ans + ", qno=" + qno
				+ ", qtime=" + qtime + "]";
	}

	
	public QuestionandAnswer(int qid, int id, String ques, String ans, int qno, String qtime) {
		//super();
		this.qid = qid;
		this.id = id;
		this.ques = ques;
		this.ans = ans;
		this.qno = qno;
		this.qtime = qtime;
	}
 public QuestionandAnswer()
 {
	 
 }


	

}
