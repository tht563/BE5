package Service;

import java.sql.*;
import java.util.ArrayList;

import Database.Course;
import Database.DBConnection;

public class UserService {
	final static int the_email_has_not_used = 0;
	final static int there_is_no_course = 0;
	final static int the_user_has_been_found = 1;
	
	static Connection connection = DBConnection.makeConnection();
	
	public static boolean registerNewCourse(String email, Course course) {
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(*) "
						 + "FROM enrolment "
						 + "WHERE enrolment.user_email = \""+email+"\""
						 + "AND enolment.subject_code = \""+course.getSubjectCode()+"\"";
			ResultSet record = statement.executeQuery(query);
			int count=1;
			if (record.next()) {
				count = record.getInt(1);
			}
			if (count > 0) {
				return false;
			}
			query = "INSERT INTO enrolment(user_email, subject_code) "
				  + "VALUES (\""+email+"\","+"\""+course.getSubjectCode()+"\""+")";
			statement.executeUpdate(query);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static void showEnrolledCourses(String email) {
		ArrayList<Course> courses = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(*) "
						 + "FROM enrolment "
						 + "JOIN course ON enrolment.subject_code = course.subject_code "
						 + "WHERE enrolment.user_email = \""+email+"\";";
			ResultSet record = statement.executeQuery(query);
			int count = 0;
			if(record.next()){
				count = record.getInt(1);
			}
			if (count == there_is_no_course) {
				System.out.println("There is no course in your account.");
				return;
			}
			query = "SELECT course.name, course.subject_code, course.price , course.start_date, course.end_date "
					+ "FROM enrolment "
					+ "JOIN course ON enrolment.subject_code = course.subject_code "
					+ "WHERE enrolment.user_email = \""+email+"\";";
			
			record = statement.executeQuery(query);
			int i=1;
			System.out.println("Your courses: ");
			while (record.next()) {
				courses.add(new Course(record.getString("course.name"),record.getString("course.subject_code"),record.getDate("course.start_date"),record.getDate("course.end_date"),record.getInt("course.price")));
			}
			for (Course myCourses:courses) {
				System.out.println("Name: "+myCourses.getName());
				System.out.println("Subject Code: "+myCourses.getSubjectCode());
				System.out.println("Start Date: "+myCourses.getStartDate());
				System.out.println("End Date: "+myCourses.getEndDate());
				System.out.println("Price: "+myCourses.getPrice());
				System.out.println("------------------------------");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static boolean login(String email, String password) {
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(*)"
						+  "FROM user "
						+  "WHERE email=\"" + email + "\" AND password =\"" + password +"\";";
			ResultSet record = statement.executeQuery(query);
			if (record.next()) {
				if (record.getInt(1) == the_user_has_been_found) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}

	public static boolean registerNewUser(String email, String password, String name) {
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(*) "
						+  "FROM user"
						+  "WHERE email ='" + email+"');";
			int count = statement.executeUpdate(query);
			if (count==the_email_has_not_used) {
				return true;
			}else {
				return false;
			}
		
		}catch(Exception e){
            return false;
        }
	}
}
