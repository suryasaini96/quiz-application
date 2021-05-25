package com.wipro.quiz.bean;

public class QuestionsBean {
	private int quesid;
	private String ques;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String ans;

	public QuestionsBean() {
		super();
	}
	
	public QuestionsBean(int quesid, String ques, String op1, String op2, String op3, String op4, String ans) {
		super();
		this.quesid = quesid;
		this.ques = ques;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.ans = ans;
	}
	public int getQuesid() {
		return quesid;
	}
	public String getQues() {
		return ques;
	}
	public String getOp1() {
		return op1;
	}
	public String getOp2() {
		return op2;
	}
	public String getOp3() {
		return op3;
	}
	public String getOp4() {
		return op4;
	}
	public String getAns() {
		return ans;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "QuestionsBean [quesid=" + quesid + ", ques=" + ques + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
				+ ", op4=" + op4 + ", ans=" + ans + "]";
	}
	
	
	
	
}
