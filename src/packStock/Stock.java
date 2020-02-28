package packStock;

import java.util.ArrayList;
import packProduct.Product;

public class Stock {
	
	private ArrayList<Product> list;
	private int lastCode;
	
	private static Stock instance;

	private Stock() {
		
		list = new ArrayList<Product>();
		
	}
	
	public Stock(ArrayList<Product> list, int lastCode) {
		super();
		this.list = list;
		this.lastCode = lastCode;
	}

	public static Stock getInstance() {
		
		if(instance == null) {
			instance = new Stock();
		}
		
		return instance;
	}

	public int getNextCode() {
		
		return this.lastCode ++;
	}
		
	public void addProduct(Product produktua) {
		
		this.list.add(produktua);
		getNextCode();
	}
	
	public int numberOfProducts() {
		
		return this.list.size();
	}
	//TODO displyStock method
	
	public void displayStock() {
		
		for(Product elem: list) {
			elem.print();
		}
	}
	//TODO removeProduct method
	public void removeProduct(int code) {
		
		Product bestea = new Product();
		bestea.setCode(code);
		if(this.list.contains(bestea)) {
			this.list.remove(bestea);
		}
		else {
			System.out.println("Ez dago produkturik");
		}
		
		
	}
	
	
	//TODO updateAmount method
	
	//TODO obtainProduct method
}
