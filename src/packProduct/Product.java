package packProduct;

public class Product {

	private int code;
	private String name;
	private double price;
	private int amount;
	private double weight;
	
	private final double VAT = 0.21;

	/**
	 * 
	 * @param code
	 * @param name
	 * @param price
	 * @param amount
	 * @param weight
	 */
	public Product(int code, String name, double price, int amount, double weight) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.weight = weight;
	}
	public Product() {
		super();
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) throws NegativeAmountException {
		
			if(amount < 0) {
				throw new NegativeAmountException("Kopurua ezin du negatiboa izan");
			}
			else {
				this.amount = amount;
			}
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the vAT
	 */
	public double getVAT() {
		return VAT;
	}
	
	/**
	 * 
	 * @return produktuaren prezioa BEZ-arekin gehituta itzultzen du
	 */
	public double priceWithVAT() {
		
		return this.price + this.price * VAT;
	}	
	public void print() {
		
		System.out.println("Kodea: " + this.code);
		System.out.println("Izena: " + this.name);
		System.out.println("Prezioa: " + this.price);
		System.out.println("Kopurua: " + this.amount);
		System.out.println("Prezioa BEZ-arekin: " + this.priceWithVAT());

	}
	
	@Override
	public boolean equals(Object obestea) {
		
		Product bestea = (Product)obestea;
		
		return this.getCode() == bestea.getCode();
		
		
	}
	
	public void printForClient() {
		
		System.out.println("Kodea: " + this.code);
		System.out.println("Izena: " + this.name);
		System.out.println("Prezioa: " + this.price);
		System.out.println("Pisua: " + this.weight);
		System.out.println("Prezioa BEZ-arekin: " + this.priceWithVAT());
	}
		
	public String toString() {
		
		return this.code+ " "+ this.name + " " + this.price + " " + this.amount + " " + this.weight;
		
	}
}
