package entity;

import java.util.*;

import model.ProductInCart;



public class Cart {
	
	private Set<ProductInCart> items;
	private double total;
	
	public Cart() {}
	
	public Cart(Set<ProductInCart> items, double total) {
		super();
		this.items = items;
		this.total = total;
	}

	public Set<ProductInCart> getItems() {
		return items;
	}

	public void setItems(Set<ProductInCart> hashMap) {
		this.items = hashMap;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
