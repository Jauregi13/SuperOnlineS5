package packSupermarket;

import gui.BasicProductWindow;

public class SuperOnLine {
	public static void main(String[] args) {

		//TODO: obtain the Stock instance

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

				//TODO: Create an instance of Product using the gathered values

				

				//TODO: add the product to the Stock

				

			}



		}             

		//TODO show all the products in Stock

		//TODO remove the second product in Stock

		//TODO show all the products in Stock


	}
}
