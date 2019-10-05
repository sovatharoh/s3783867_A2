package product;

public class TestProduct {
	public void testValid() {
		Product p1 = new Product("Toilet Paper", 200.00, 15.00);
		Product p2 = new Product("Cereal", 100.00, 5.00);
		Product p3 = new Product("Bread", 150.00, 3.00);
		
		System.out.println("Test Valid Product");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
	
	public void testInvalid() {
		Product p4 = new Product(null, 200.00, 15.00);
		Product p5 = new Product("Cereal", 0, 5.00);
		Product p6 = new Product("Bread", 150.00, 0);
		
		System.out.println("Test Invalid Product");
		System.out.println(p4.toString());
		System.out.println(p5.toString());
		System.out.println(p6.toString());
	}
}
