package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import Database.Course;
import Database.DBConnection;
import Database.Mentor;

public class CourseService {
	
	static Connection connection = DBConnection.makeConnection();
	
	public static void showMentor(Course course) {
		ArrayList<Mentor> mentors = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			System.out.println(course.getSubjectCode());
			String query = "SELECT mentor.name, mentor.email, mentor.phone "
						 + "FROM mentor "
						 + "JOIN teaching ON mentor.email = teaching.mentor_email  "
						 + "WHERE teaching.isIncharge = TRUE "
						 + "AND teaching.subject_code = \""+course.getSubjectCode()+"\";";
			ResultSet record = statement.executeQuery(query);
			System.out.println("Mentor: ");
			while (record.next()) {
				System.out.println("Name: "+record.getString("mentor.name"));
				System.out.println("Email: "+record.getString("mentor.email"));
				System.out.println("Phone: "+record.getString("mentor.phone"));
			}
			query = "SELECT mentor.name, mentor.email, mentor.phone "
					 + "FROM mentor "
					 + "JOIN teaching ON mentor.email = teaching.mentor_email "
					 + "WHERE teaching.isIncharge = FALSE "
					 + "AND teaching.subject_code = \""+course.getSubjectCode()+"\"";
			System.out.println("Co-Mentor: ");
			query = "SELECT mentor.name, mentor.email, mentor.phone "
					 + "FROM mentor "
					 + "JOIN teaching ON mentor.email = teaching.mentor_email  "
					 + "WHERE teaching.isIncharge = FALSE "
					 + "AND teaching.subject_code = \""+course.getSubjectCode()+"\";";
			record = statement.executeQuery(query);
			while (record.next()) {
				System.out.println("Name: "+record.getString("mentor.name"));
				System.out.println("Email: "+record.getString("mentor.email"));
				System.out.println("Phone: "+record.getString("mentor.phone"));
			}
		}catch (Exception e) {
	         e.printStackTrace();
	    }
	}
	
	public static ArrayList<Course> showAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT name, subject_code, price, start_date, end_date "
						 + "FROM course  "
						 + "WHERE start_date>current_date();";
			ResultSet record = statement.executeQuery(query);
			
			while (record.next()) {
				courses.add(new Course(record.getString("course.name"),record.getString("course.subject_code"),record.getDate("course.start_date"),record.getDate("course.end_date"),record.getInt("course.price")));
			}
			int i=0;
			for (Course myCourses:courses) {
				i++;
				System.out.print(i+". "+myCourses.getName());
				System.out.print(" - "+myCourses.getSubjectCode());
				System.out.print(" from "+myCourses.getStartDate());
				System.out.print(" to "+myCourses.getEndDate());
				System.out.print(" - "+myCourses.getPrice());
				System.out.println("");
			}
			return courses;
		}catch (Exception e) {
	         e.printStackTrace();
	         return null;
	    } 
	}
}
