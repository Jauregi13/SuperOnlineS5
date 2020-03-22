package packProduct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	private Product produktua;
	
	@BeforeEach
	void setUp() throws Exception {
		
		produktua = new Product();
		
	}

	@Test
	void testSetAmount() throws NegativeAmountException{
		
		Exception e = assertThrows(NegativeAmountException.class,
				()-> produktua.setAmount(-5));
		
		assertTrue(e.getMessage().contains("Kopurua ezin du negatiboa izan"));
		
		
		
	}
	
	
	@Test
	void testSetAmount2() throws NegativeAmountException{
		
		produktua.setAmount(5);
		
		assertTrue(produktua.getAmount() > 0);
	}
	
	

}
