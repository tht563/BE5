import java.sql.*;
import java.util.*;
import com.mysql.*;
import Database.*;
import Service.*;
public class Main {
	
	public static void main (String[] args) {
		int selection = 0;
		
		Connection connection = DBConnection.makeConnection();
		
		if (Objects.isNull(connection)) {
			return;
		}
		
		initDB.main();
		
		do {
			selection = loginPage();
		}while (selection == 0);
	
		String email = null;
		do {
			switch (selection) {
				case 1:
					email = login();
					break;
				case 2:
					register();
			}
			if (!Objects.isNull(email)) {
				email = courseListPage(email);
			}
		} while (email==null);
		
	}
	
	public static String courseListPage(String email) {
		Scanner scan  = new Scanner(System.in);
		ArrayList<Course> courses = new ArrayList<>();
		
		do {
			System.out.println("--------------------------------------------------");
			System.out.println("Course list: ");
			System.out.println("-1. Logout");
			System.out.println("0. Your courses");
			courses = CourseService.showAllCourses();
			System.out.print("Your selection: ");
			int selection = scan.nextInt();
			switch (selection) {
				case (-1):
					return null;
				case (0):
					showYourCourse(email);
				break;
				default:
					showCourseDetails(email, courses.get(selection-1));
			}
		}while (true);
	}
	
	public static void showCourseDetails(String email, Course course) {
		Scanner scan = new Scanner (System.in);
		System.out.println("--------------------------------------------------");
		System.out.println("Name: "+course.getName());
		System.out.println("Subject Code: "+course.getSubjectCode());
		System.out.println("Start Date: "+course.getStartDate());
		System.out.println("End Date: "+course.getEndDate());
		System.out.println("Price: "+course.getPrice());
		System.out.println("Do you want to enroll this course?");
		System.out.println("1. Register");
		System.out.println("2. No");
		System.out.println("3. View Mentor Detail");
		System.out.print("Your selection: ");
		int selection = scan.nextInt();
		switch (selection) {
			case (1):
				if (UserService.registerNewCourse(email, course)) {
					System.out.println("Your new course has been added.");
				}else {
					System.out.println("You have already enrolled.");
				}
				break;
			case (3):
				CourseService.showMentor(course);
				break;
		}
	}
	
	public static void showYourCourse(String email) {
		System.out.println("--------------------------------------------------");
		UserService.showEnrolledCourses(email);
	}
	
	public static String login() {
		Scanner scan = new Scanner (System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Please enter your email and password.");
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Password: ");
		String password = scan.next();
		
		if (UserService.login(email, password)) {
			return email;
		}else {
			System.out.println("Your login has been failed. Please try again.");
			return null;
		}
	}
	
	public static void  register() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Please enter your register information.");
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Password: ");
		String password = scan.next();
		System.out.print("Name: ");
		String name = scan.next();
		
		if (UserService.registerNewUser(email, password, name)) {
			System.out.println("Successfully registered.");
			return;
		}
		System.out.println("The email has been used. Please try again with another.");
	}
	
	public static int loginPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Coding Mentor.");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Your selection: ");
		return (scan.nextInt());
	}
	
}