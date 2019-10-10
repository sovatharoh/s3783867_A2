package product;

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
	
	public void checkName(String name) {
		if(name == null || name.isEmpty()) 
		{
			this.name = "N/A";
		}else 
		{
			this.name = name;
		}
	}
	
	public void checkWeight(double weight) {
		if(weight<=0) {
			this.weight = -1.0;
		}else {
			this.weight = weight;
		}
	}
	
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
	
	//required getters
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
