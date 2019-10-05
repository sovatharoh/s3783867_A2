package product;

public class Product {
	private String name;
	private double weight;
	private double cost;
	
	public Product(String name, double weight, double cost) {
		this.name = name;
		this.weight = weight;
		this.cost = cost;
		setName(name);
		setWeight(weight);
		setCost(cost);
	}
	
	public void setName(String name) {
		if(name == null) 
		{
			this.name = "N/A";
		}else 
		{
			this.name = name;
		}
	}
	
	public void setWeight(double weight) {
		if(weight<=0) {
			this.weight = -1.0;
		}else {
			this.weight = weight;
		}
	}
	
	public void setCost(double cost) {
		if(cost<=1) {
			this.cost = -1.0;
		}else {
			this.cost = cost;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + ":" + weight + ":" + cost);
		return sb.toString();
	}
	
}
