import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Applicant{
	String name;
	int subject1;
	int subject2;
	int subject3;
	int total;
	int percentage;
	public Applicant(String name,int s1,int s2,int s3){
		this.name=name;
		this.subject1=s1;
		this.subject2=s2;
		this.subject3=s3;
	}
	public void setTotal(int tValue){
		this.total=tValue;
	}
	public void setPercentage(int pValue){
		this.percentage=pValue;
	}
	public void getData(){
		System.out.println(String.format("%-10s %-5s %-5s %-5s %-10s %-10s",this.name,this.subject1,this.subject2,this.subject3,this.total,this.percentage));
	}
}
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter no of applicant details to enter:");
		Scanner sc=new Scanner(System.in);
		List<Applicant> aList=new ArrayList<Applicant>();
		int inLength=Integer.parseInt(sc.nextLine());
		Applicant[] a=new Applicant[inLength];
		for(int i=0;i<inLength;i++){			
			String[] inArr=sc.nextLine().split(",");
			a[i]=new Applicant(inArr[0], Integer.parseInt(inArr[1]), Integer.parseInt(inArr[2]), Integer.parseInt(inArr[3]));
			int tValue=totalCalculation(a[i]);
			a[i].setTotal(tValue);
			a[i].setPercentage(percentageCalculation(tValue));
			aList.add(a[i]);
		}
		System.out.println(String.format("%-10s %-5s %-5s %-5s %-10s %-10s","Name","S1","S2","S3","Total","%"));
		System.out.println();
		aList.stream()
		.filter(x -> (x.subject1 >= 50) && (x.subject2 >= 50) && (x.subject3 >= 50))
		.sorted((x1,x2)-> Integer.toString(x2.percentage).compareTo(Integer.toString(x1.percentage)))
		.forEach(x -> x.getData());
	}
	public static int totalCalculation(Applicant applicant){
		return applicant.subject1+applicant.subject2+applicant.subject3;
	}
	public static int percentageCalculation(int total) {
		return (int)(total/3);
	}
}
