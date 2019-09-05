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
@Table(name = "feedback")
public class QuestionandAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qid")
	private int qid;

	@Column(name = "id")
	private int id;

	@Column(name = "question", columnDefinition = "varchar(500)")
	private String question;

	@Column(name = "answer", columnDefinition = "varchar(500)")
	private String answer;

	@Column(name = "qno")
	private int qno;

	@Column(name = "time")
	private java.sql.Timestamp time;

	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;

	@Column(name = "month")
	private String month;

	@Column(name = "type")
	private String type;

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "QuestionandAnswer [qid=" + qid + ", id=" + id + ", question=" + question + ", answer=" + answer
				+ ", qno=" + qno + ", time=" + time + ", remark=" + remark + ", month=" + month + ", type=" + type
				+ "]";
	}


}
