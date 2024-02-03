package entity;


import java.util.Date;

public class Order {
	private int id;
	private int userId;
	private Date submitDate;
	
		
	public Order() {
		super();
	}

	public Order(int id, int userId, Date submitDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.submitDate = submitDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	};
	
	
	
}
