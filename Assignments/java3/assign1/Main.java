import java.util.Scanner;

class Consumer{
	private String id;
	private String name;
	private Integer unitConsumed;
	private String finalPayment;
	public Consumer(String cnum,String cname,String cunits){
		this.id=cnum;
		this.name=cname;
		this.unitConsumed=Integer.parseInt(cunits);
		this.finalPayment=BillService.billCalculation(Double.parseDouble(cunits));
	}
	public void getData(){
		System.out.println(String.format("%-5s %-20s %-10s %-10s",this.id,this.name,this.unitConsumed,this.finalPayment));
		System.out.println();
	}
}
class BillService{
	public static String billCalculation(double units){
		double cost=0;
		if(units<=200){
			cost = 300;
		}
		else if(units>=201 && units<=500){
			double temp=units-200;
			cost=(temp*1.25)+300;
		}
		else if(units>=501 && units<=1000){
			double temp=units-500;
			cost=(temp*1.00)+(300*1.25)+300;
		}
		else if(units>=1001){
			double temp=units-1000;
			cost=(temp*0.75)+(500*1.00)+(300*1.25)+300;
		}
		return Double.toString(cost);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentInput;
		String[] cArr;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of consumers bill to prepare");
		int n=Integer.parseInt(sc.nextLine());
		if(n <= 0){
			System.out.println("Invalid input");
		}
		Consumer[] c;
		c=new Consumer[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter the details of consumer number "+(i+1)+" seperated by ','");
			currentInput=sc.nextLine();
			cArr=currentInput.split(",");
			c[i]=new Consumer(cArr[0],cArr[1],cArr[2]);
		}
		for(int i=0;i<n;i++){
			c[i].getData();
		}
	}

}
