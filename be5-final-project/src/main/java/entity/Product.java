package entity;

public class Product {
	private int id;
	private String name;
	private int price;
	private String imgName;
	private boolean is_new;
	private int quantity;
	private String description;
	private int categoryId;
	
	public Product() {
		
	}
	
	public Product(int id, String name, int price, String imgName, boolean is_new, int quantity, String description, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.is_new = is_new;
		this.quantity = quantity;
		this.description = description;
		this.categoryId = categoryId;
	}



	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIs_new() {
		return is_new;
	}

	public void setIs_new(boolean is_new) {
		this.is_new = is_new;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
}
