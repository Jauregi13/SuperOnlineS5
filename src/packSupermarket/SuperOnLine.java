package packSupermarket;

import java.io.FileNotFoundException;
import java.io.IOException;

import gui.BasicProductWindow;
import packStock.Stock;
import packProduct.Product;

public class SuperOnLine {
	public static void main(String[] args) {

		Stock stock_ins = Stock.getInstance();
		
		try {
			stock_ins.loadStockFromFile("lista_Stock/products.txt");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Fitxategia ez da existitzen edo beste karpeta batean dago");
		}
		
		
		//Create 3 products to store in the Stock
		for(int i=0;i<3;i++) {

			BasicProductWindow dlgProduct = new BasicProductWindow ();
			dlgProduct.setModal (true);
			dlgProduct.setVisible (true);

			if (dlgProduct.okPressed()) {
				String name=dlgProduct.getTxtName();
				double price=dlgProduct.getTxtPrice();
				int amount=dlgProduct.getTxtAmount();
				double weight=dlgProduct.getTxtWeight();
				
				Product produktua = new Product(i,name,price,amount,weight);
				
				stock_ins.addProduct(produktua);
				

			}

		}
		
		try {
			
			stock_ins.storeStockInFile("lista_Stock/products.txt");
			 
			stock_ins.displayStock();
		
			stock_ins.removeProduct(1002);
			
			stock_ins.storeStockInFile("lista_Stock/products.txt");
			
			stock_ins.displayStock();

		}
		
		catch (IOException e) {
			
			System.out.println("Fitxategia ez da existitzen edo beste karpeta batean dago");
		}
		
		catch(Stock.UnknownCodeException e) {
			
			System.out.println(e.getMessage());
		}
		
		

	}
}
