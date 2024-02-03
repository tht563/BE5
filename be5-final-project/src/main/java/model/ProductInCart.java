package model;

public class ProductInCart {
	private int id;
	private String name;
	private int price;
	private double subTotal;
	private int quantity;
	
	
	public ProductInCart() {
		super();
	}

	public ProductInCart(int id, String name, int price, double subTotal, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.subTotal = subTotal;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = 31 + id;
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		ProductInCart product = (ProductInCart) obj;
		return this.id==product.getId();
	}
	
	
	
}
