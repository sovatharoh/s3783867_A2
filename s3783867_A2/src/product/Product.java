package product;
/**
* <h1>Producte</h1>
* <p><b>This class creates an product object  and
*applies all the business rules and operations.
*</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
public class Product {
	private String name;
	private double weight;
	private double cost;
	
	public Product(String name, double weight, double cost) {
		this.name = name;
		this.weight = weight;
		this.cost = cost;
		checkName(name);
		checkWeight(weight);
		checkCost(cost);
	}
	/*
	 * validates and checks if name is null or empty.
	 */
	public void checkName(String name) {
		if(name == null || name.isEmpty()) 
		{
			this.name = "N/A";
		}else 
		{
			this.name = name;
		}
	}
	/*
	 * validates and checks if weight meets business rules.
	 */
	public void checkWeight(double weight) {
		if(weight<=0) {
			this.weight = -1.0;
		}else {
			this.weight = weight;
		}
	}
	/*
	 * validates and checks if cost meets business rules.
	 */
	public void checkCost(double cost) {
		if(cost<=1) {
			this.cost = -1.0;
		}else {
			this.cost = cost;
		}
	}

	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s %s\n", "Product Name:", name));
		sb.append(String.format("%-15s %s\n", "Weight:", weight));
		sb.append(String.format("%-15s %s\n", "Cost: $", cost));
		return sb.toString();
	}
	
	public String toString() {
		return name + " " + weight + " " + cost;
	}
	
	/*
	 * required getters
	 */
	public String getName()
	{
		return name;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getCost()
	{
		return cost;
	}
	
}
