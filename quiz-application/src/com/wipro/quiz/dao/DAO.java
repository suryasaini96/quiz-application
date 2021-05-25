package com.wipro.quiz.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wipro.quiz.bean.*;
import com.wipro.quiz.util.DBUtil;

public class DAO {
	
	/*        Student methods         */
	
	public StudentBean loginUserStudent(int id,String password) {
		StudentBean beanObj = null;
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from student where id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				beanObj = new StudentBean();
				beanObj.setId(resultSet.getInt("id"));
				beanObj.setPassword(resultSet.getString("password"));				
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanObj;
	}
	
	public StudentBean studentProfile(int id) {
		StudentBean beanObj = null;
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from student where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				beanObj = new StudentBean();
				beanObj.setId(result.getInt("ID"));
				beanObj.setFname(result.getString("FNAME"));
				beanObj.setLname(result.getString("LNAME"));
				beanObj.setGender(result.getString("GENDER"));
				beanObj.setDob(result.getDate("DOB"));
				beanObj.setMobile(result.getLong("MOBILE"));
				beanObj.setEmail(result.getString("EMAIL"));
				beanObj.setPassword(result.getString("PASSWORD"));
			}
			result.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanObj;
	}
	
	public int studentProfileUpdate(int id, String gender, Date dob, long mobile, String email) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update student set gender = ?, dob = ?, mobile = ?, email = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, gender);
			statement.setDate(2, dob);
			statement.setLong(3, mobile);
			statement.setString(4, email);
			statement.setInt(5, id);
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Profile updated.");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public int studentProfileUpdate(int id, String gender, Date dob, long mobile, String email, String newPassword) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update student set gender = ?, dob = ?, mobile = ?, email = ?, password = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, gender);
			statement.setDate(2, dob);
			statement.setLong(3, mobile);
			statement.setString(4, email);
			statement.setString(5, newPassword);
			statement.setInt(6, id);
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Profile updated with password.");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public int registerStudent(int id, String fname, String lname, String gender, Date dob, long mobile, String email, String password) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "insert into student values (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, fname);
			statement.setString(3, lname);
			statement.setString(4, gender);
			statement.setDate(5, dob);
			statement.setLong(6, mobile);
			statement.setString(7, email);
			statement.setString(8, password);
			
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Student registered.");
				return rowsInserted;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public int answerValidate(String topic, int quesID, String ans) {
		try {
			Connection connection = DBUtil.getDBConnection();
	
			String query1 = "select ans from " + topic.toLowerCase() + " where quesid = ?";
			PreparedStatement statement1 = connection.prepareStatement(query1);
			statement1.setInt(1, quesID);
			ResultSet result = statement1.executeQuery();
			if(result.next()) {
				String fetchedAns = result.getString("ANS");
				if(fetchedAns.equals(ans)) {
					return 1;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	public int storeResult(int stuID, String topic, int level1, int level2, int level3, String time ) {
		try {
			Connection connection = DBUtil.getDBConnection();
	
			String query1 = "insert into results values (?,?,?,?,?,?)";
			PreparedStatement statement1 = connection.prepareStatement(query1);
			statement1.setInt(1, stuID);
			statement1.setString(2, topic);
			statement1.setInt(3, level1);
			statement1.setInt(4, level2);
			statement1.setInt(5, level3);
			statement1.setString(6, time);
			int result = statement1.executeUpdate();
			if(result>0) {
				System.out.println("Result stored.");
				return result;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public ResultBean studentProgress(int stuid, String topic) {
		ResultBean resultObj = null;
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from results where stuid = ? and topic = ? order by time";
			PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, stuid);
			statement.setString(2, topic);
			ResultSet result = statement.executeQuery();
			result.afterLast();
			if(result.previous()) {
				resultObj = new ResultBean();
				resultObj.setStuid(result.getInt("STUID"));
				resultObj.setTopic(result.getString("TOPIC"));
				resultObj.setLevel1(result.getInt("LEVEL1"));
				resultObj.setLevel2(result.getInt("LEVEL2"));
				resultObj.setLevel3(result.getInt("LEVEL3"));
				resultObj.setTime(result.getString("TIME"));
			}
			result.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultObj;
	}
	
	
	
	/*----------------------------------*/
	
	/*        Professor methods         */
	
	public ProfessorBean loginUserProfessor(int id,String password) {
		ProfessorBean beanObj = null;
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from professor where id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				beanObj = new ProfessorBean();
				beanObj.setId(resultSet.getInt("id"));
				beanObj.setPassword(resultSet.getString("password"));				
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanObj;
	}
	
	public ProfessorBean professorProfile(int id) {
		ProfessorBean beanObj = null;
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from professor where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				beanObj = new ProfessorBean();
				beanObj.setId(result.getInt("ID"));
				beanObj.setDept(result.getString("DEPT"));
				beanObj.setFname(result.getString("FNAME"));
				beanObj.setLname(result.getString("LNAME"));
				beanObj.setGender(result.getString("GENDER"));
				beanObj.setDob(result.getDate("DOB"));
				beanObj.setQualification(result.getString("QUALIFICATION"));
				beanObj.setMobile(result.getLong("MOBILE"));
				beanObj.setEmail(result.getString("EMAIL"));
				beanObj.setPassword(result.getString("PASSWORD"));
			}
			result.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanObj;
	}
	
	public int registerProfessor(int id, String dept, String fname, String lname, String gender, Date dob, String qualification, long mobile, String email, String password) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "insert into professor values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, dept);
			statement.setString(3, fname);
			statement.setString(4, lname);
			statement.setString(5, gender);
			statement.setDate(6, dob);
			statement.setString(7, qualification);
			statement.setLong(8, mobile);
			statement.setString(9, email);
			statement.setString(10, password);
			
			int rowsInserted = statement.executeUpdate();
			if(rowsInserted>0) {
				System.out.println("Professor registered.");
				return rowsInserted;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public int professorProfileUpdate(int id, String dept, String gender, Date dob, String qualification, long mobile, String email) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update professor set dept = ?, gender = ?, dob = ?, qualification = ?, mobile = ?, email = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, dept);
			statement.setString(2, gender);
			statement.setDate(3, dob);
			statement.setString(4, qualification);
			statement.setLong(5, mobile);
			statement.setString(6, email);
			statement.setInt(7, id);
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Profile updated.");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public int professorProfileUpdate(int id, String dept, String gender, Date dob, String qualification, long mobile, String email, String newPassword) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update professor set dept = ?, gender = ?, dob = ?, qualification = ?, mobile = ?, email = ?, password = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, dept);
			statement.setString(2, gender);
			statement.setDate(3, dob);
			statement.setString(4, qualification);
			statement.setLong(5, mobile);
			statement.setString(6, email);
			statement.setString(7, newPassword);
			statement.setInt(8, id);
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Profile updated with password.");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}
	
	public void createTopic(String topic) {
		try {
			Connection connection = DBUtil.getDBConnection();
			
			String query1 = "create table " + topic.toLowerCase() +  
					"(quesid number(3) not null," + 
					"ques varchar2(2000)," + 
					"op1 varchar2(1000)," + 
					"op2 varchar2(1000)," + 
					"op3 varchar2(1000)," + 
					"op4 varchar2(1000)," + 
					"ans varchar2(1000)," + 
					"constraint " + topic.toLowerCase() + "_pk primary key(quesid))";
			Statement statement1 = connection.createStatement();
			statement1.execute(query1);
			
			String query2 = "insert into topics values (?)"; 
			PreparedStatement statement2 = connection.prepareStatement(query2);
			statement2.setString(1, topic);
			statement2.executeUpdate();
		} catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}
	
	public List<TopicsBean> getTopics () {
		List<TopicsBean> topics = new ArrayList<TopicsBean>();
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from topics";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				TopicsBean topicsObj = new TopicsBean(resultSet.getString("topic"));
				topics.add(topicsObj);
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return topics;
	}
	
	public int deleteTopic(String topic) {
		try {
			Connection connection = DBUtil.getDBConnection();
			
			String query1 = "delete from topics where topic = ?";
			String query2 = "drop table " + topic.toLowerCase(); 
			PreparedStatement statement1 = connection.prepareStatement(query1);
			Statement statement2 = connection.createStatement();
			statement1.setString(1, topic);
			statement2.execute(query2);
			int rowsAffected = statement1.executeUpdate();
			if(rowsAffected>0) {
				System.out.println(topic + " deleted.");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int addQues(String topic, int quesid, String ques, String op1, String op2, String op3, String op4, String ans) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "insert into " + topic.toLowerCase() + " values(?,?,?,?,?,?,?)"; 
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, quesid);
			statement.setString(2, ques);
			statement.setString(3, op1);
			statement.setString(4, op2);
			statement.setString(5, op3);
			statement.setString(6, op4);
			statement.setString(7, ans);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Question added to '" + topic + "'");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int editQues(String topic, int quesid, String ques, String op1, String op2, String op3, String op4, String ans) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update " + topic.toLowerCase() + " set ques = ?, op1 = ?, op2 = ?, op3 = ?, op4 = ?, ans = ? where quesid = ?"; 
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ques);
			statement.setString(2, op1);
			statement.setString(3, op2);
			statement.setString(4, op3);
			statement.setString(5, op4);
			statement.setString(6, ans);
			statement.setInt(7, quesid);
			
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Question edited in'" + topic + "'");
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public List<QuestionsBean> getQuesList(String topic) {
		List<QuestionsBean> listOfQues = new ArrayList<QuestionsBean>();
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from " + topic.toLowerCase() + " order by quesid";
			PreparedStatement preparedStatement = connection.prepareStatement(query);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				QuestionsBean quesObj = new QuestionsBean(resultSet.getInt("quesid"), resultSet.getString("ques"), resultSet.getString("op1"), resultSet.getString("op2"), resultSet.getString("op3"), resultSet.getString("op4"), resultSet.getString("ans"));
				listOfQues.add(quesObj);
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listOfQues;
	}
	
	public QuestionsBean getQues(String topic, int quesid) {
		QuestionsBean quesObj = null;
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from " + topic.toLowerCase() + " where quesid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, quesid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {	
				quesObj = new QuestionsBean(resultSet.getInt("quesid"), resultSet.getString("ques"), resultSet.getString("op1"), resultSet.getString("op2"), resultSet.getString("op3"), resultSet.getString("op4"), resultSet.getString("ans"));
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return quesObj;
	}
	
	public int deleteQues(String topic, int quesid) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "delete from " + topic.toLowerCase() + " where quesid = ?"; 
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, quesid);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Question ID " + quesid + " deleted from " + topic);
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public List<ResultBean> studentHistory(int id) {
		List<ResultBean> listOfTests = new ArrayList<ResultBean>();
		try {			
			Connection connection = DBUtil.getDBConnection();
			String query = "select * from results where stuid = ? order by topic";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ResultBean resultObj = new ResultBean(resultSet.getInt("STUID"), resultSet.getString("TOPIC"), resultSet.getInt("LEVEL1"), resultSet.getInt("LEVEL2"), resultSet.getInt("LEVEL3"), resultSet.getString("TIME"));
				listOfTests.add(resultObj);
			}
			resultSet.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listOfTests;
	}
	
	
	/*----------------------------------*/
	
	/*        Forgot Password         */
	
	public int forgotPass(int id, String pass, String loginType) {
		try {
			Connection connection = DBUtil.getDBConnection();
			String query = "update " + loginType.toLowerCase() + " set password = ? where id = ?"; 
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, pass);
			statement.setInt(2, id);
			int rowsAffected = statement.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Password updated for " + id);
				return rowsAffected;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
}
