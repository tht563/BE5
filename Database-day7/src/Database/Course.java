package Database;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	private String name;
	private String subjectCode;
	private Date startDate;
	private Date endDate;
	private int price;
	
	public Course() {
		
	}
	
	public Course(String name, String subjectCode, Date startDate, Date endDate, int price) {
		super();
		this.name = name;
		this.subjectCode = subjectCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}