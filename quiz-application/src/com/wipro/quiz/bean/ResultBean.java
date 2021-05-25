package com.wipro.quiz.bean;

public class ResultBean {

	private int stuid;
	private String topic;
	private int level1;
	private int level2;
	private int level3;
	private String time;
	
	public ResultBean() {
		super();
	}

	public ResultBean(int stuid, String topic, int level1, int level2, int level3, String time) {
		super();
		this.stuid = stuid;
		this.topic = topic;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.time = time;
	}

	public int getStuid() {
		return stuid;
	}

	public String getTopic() {
		return topic;
	}

	public int getLevel1() {
		return level1;
	}

	public int getLevel2() {
		return level2;
	}

	public int getLevel3() {
		return level3;
	}

	public String getTime() {
		return time;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setLevel1(int level1) {
		this.level1 = level1;
	}

	public void setLevel2(int level2) {
		this.level2 = level2;
	}

	public void setLevel3(int level3) {
		this.level3 = level3;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
	
	
	
	

	
}

