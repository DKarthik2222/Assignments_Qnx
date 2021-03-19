public class Item{
	int id;
	String name;
	double purchasePrice;
	double salesPrice;
	String grade;
	public Item(int id,String name,double pPrice,double sPrice,String grade) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.purchasePrice=pPrice;
		this.salesPrice=sPrice;
		this.grade=grade;
	}
	public void getData(){
		System.out.println(String.format("%-5s %-20s %-10s %-10s %-5s",Integer.toString(this.id),this.name,Double.toString(this.purchasePrice),Double.toString(this.salesPrice),this.grade));
	}
	  //Override the predefined hashCode function
	  @Override
	  public int hashCode(){
	    return (Integer.toString(this.id)).hashCode();
	  }
}