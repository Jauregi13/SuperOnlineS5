package packStock;

import java.util.ArrayList;
import packProduct.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Stock {
	
	private ArrayList<Product> list;
	private int lastCode;
	
	private static Stock instance;
	
	@SuppressWarnings("serial")
	public class UnknownCodeException extends Exception {
		
		public UnknownCodeException() {
			super();
		}
		
		public UnknownCodeException(String s) {
			super(s);
		}
	}

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
	
	public void displayStock() {
		
		for(Product elem: list) {
			elem.print();
		}
	}

	public void removeProduct(int code) throws UnknownCodeException {
		
		boolean aurkitua = false;
		Product bestea = new Product();
		bestea.setCode(code);
		
		for(Product elem: list) {
			if(elem.equals(bestea)) {
				aurkitua = true;
				this.list.remove(elem);
				break;
			}
		}
		
		if(!aurkitua) {
			throw new UnknownCodeException("Ez da existitzen produkturik kode horrekin");
		}
		
		
	}
	
	public void updateAmount(int code,int amount) throws NegativeAmountException,UnknownCodeException {
		
		boolean aurkitua = false;
		Product bestea = new Product();
		bestea.setCode(code);
		
		for(Product elem: list) {
			if(elem.equals(bestea)) {
				aurkitua = true;
				elem.setAmount(amount);
				break;
			}
		}
		
		if(!aurkitua) {
			throw new UnknownCodeException("Ez da existitzen produkturik kode horrekin");
		}
	}
	
	public Product obtainProduct(int code) throws UnknownCodeException{
		
		Product produktua = new Product();
		produktua.setCode(code);
		
		for(Product elem: list) {
			if(elem.equals(produktua)) {				
				return elem;
			}
		}
		
		throw new UnknownCodeException("Ez da existitzen produkturik kode horrekin");
		
	}
	
	public void storeStockInFile(String fitxategi) throws IOException{
				
		FileWriter fw = new FileWriter(fitxategi,false);
		
		for(Product elem: list) {
			
			fw.write(elem.toString()+"\n");
			
		}
		
		fw.close();
		
	}
	
	public void loadStockFromFile(String fitxategi) throws FileNotFoundException {
		
		Scanner es = new Scanner(new FileReader(fitxategi));
		
		while(es.hasNext()) {
			
			try {
				String lerroa = es.nextLine();
				String[] comp = lerroa.split(" ");
				
				int code = Integer.parseInt(comp[0]);
				String name = comp[1];
				Double price = Double.parseDouble(comp[2]);
				int amount = Integer.parseInt(comp[3]);
				Double weight = Double.parseDouble(comp[4]);
				
				Product produktua = new Product(code,name,price,amount,weight);
				
				if(code > this.lastCode) {
					this.lastCode = code;
				}
				
				list.add(produktua);
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Produktuen kopurua bete da");
			}
			
			catch(NumberFormatException e2) {
				System.out.println("Datuaren formatua okerra da");
			}
			
		}
		
		es.close();

	}
	
}
