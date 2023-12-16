package Database;

import java.sql.*;

public class initDB {

	public static void main() {
		Connection connection = DBConnection.makeConnection();
		try {
			Statement statement = connection.createStatement();
			String createTable, query;
			//Create table user
//			createTable = "CREATE TABLE `user` ("
//					+ "  `email` VARCHAR(45) NOT NULL,"
//					+ "  `password` VARCHAR(45) NOT NULL,"
//					+ "  `name` VARCHAR(45) NOT NULL,"
//					+ "  `fail_count` INT NOT NULL,"
//					+ "  PRIMARY KEY (`email`),"
//					+ "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);";
//			statement.executeUpdate(createTable);
//			
//			//Insert data into table user
//			query = "INSERT INTO user(email, password, name, fail_count) "
//				  + "VALUES (\"hung@gmail.com\",\"hungpassword\",\"hung\",0),"
//				  + "(\"dung@gmail.com\",\"dungpassword\",\"dung\",0);";
//			statement.executeUpdate(query);
			
//			// Create table mentor
//			createTable = "CREATE TABLE `mentor` ("
//					+ "  `name` VARCHAR(45) NOT NULL,"
//					+ "  `email` VARCHAR(45) NOT NULL,"
//					+ "  `phone` VARCHAR(15) NOT NULL,"
//					+ "  PRIMARY KEY (`email`),"
//					+ "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);";
//			statement.executeUpdate(createTable);
//			query = "INSERT INTO mentor(name, email, phone) "
//					  + "VALUES "
//					  + "(\"hungtran@gmail.com\",\"hungmentor\",\"hung\"),"
//					  + "(\"dungnguyen@gmail.com\",\"dungmentor\",\"dung\");";
//			statement.executeUpdate(query);
			
			
			// Create table course
//			createTable = "CREATE TABLE `course` ("
//					+ "  `name` VARCHAR(45) NOT NULL,"
//					+ "  `subject_code` VARCHAR(45) NOT NULL,"
//					+ "  `price` INT NOT NULL,"
//					+ "  `start_date` DATE NOT NULL,"
//					+ "  `end_date` DATE NOT NULL,"
//					+ "  PRIMARY KEY (`subject_code`),"
//					+ "  UNIQUE INDEX `subject_code_UNIQUE` (`subject_code` ASC) VISIBLE);";
//			statement.executeUpdate(createTable);
//			query = "INSERT INTO course(name, subject_code, price, start_date, end_date) "
//					  + "VALUES "
//					  + "(\"backend\",\"be5\",5000, \"2023-09-01\",\"2024-02-24\"),"
//					  + "(\"backend\",\"be6\",6000, \"2024-02-25\",\"2024-10-24\"),"
//					  + "(\"frontend\",\"fe6\",3000, \"2023-10-01\",\"2024-02-24\"),"
//					  + "(\"frontend\",\"fe5\",4000, \"2024-03-01\",\"2024-05-24\");";  
//			statement.executeUpdate(query);
			
			
//			// Create table enrolment
//			createTable = "CREATE TABLE `enrolment` ("
//					+ "  `user_email` VARCHAR(45) NOT NULL,"
//					+ "  `subject_code` VARCHAR(45) NOT NULL);";
//			statement.executeUpdate(createTable);
//			query = "INSERT INTO enrolment(user_email, subject_code) "
//					  + "VALUES "
//					  + "(\"hung@gmail.com\",\"be5\"),"
//					  + "(\"dung@gmail.com\",\"be5\"),"
//					  + "(\"dung@gmail.com\",\"fe6\");";	    
//			statement.executeUpdate(query);
//			
//			
//			// Create table teaching
//			createTable = "CREATE TABLE `teaching` ("
//						+ "  `mentor_email` VARCHAR(45) NOT NULL,"
//						+ "  `subject_code` VARCHAR(45) NOT NULL,"
//						+ "  `isIncharge` BOOLEAN NOT NULL);";
//			statement.executeUpdate(createTable);
//			query = "INSERT INTO teaching(mentor_email, subject_code, isIncharge) "
//					  + "VALUES "
//					  + "(\"hungtran@gmail.com\",\"be5\", FALSE),"
//					  + "(\"dungnguyen@gmail.com\",\"be5\", TRUE),"
//					  + "(\"dungnguyen@gmail.com\",\"fe6\", TRUE);";	    
//			statement.executeUpdate(query);
			
		}catch(Exception e){
            System.out.println(e);
        }
		
	}

}
