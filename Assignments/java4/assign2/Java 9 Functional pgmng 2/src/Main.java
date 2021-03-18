import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cricketer{
	private String name;
	private int runFirst;
	private int runSecond;
	private int avgRun;
	private int wicketFirst;
	private int wicketSecond;
	private int avgWicket;
	private String performance;
	public Cricketer(String n,int rf,int rs,int wf,int ws){
		this.name=n;
		this.runFirst=rf;
		this.runSecond=rs;
		this.avgRun=(this.runFirst+this.runSecond)/2;
		this.wicketFirst=wf;
		this.wicketSecond=ws;
		this.avgWicket=(this.wicketFirst+this.wicketSecond)/2;
		this.performance=performanceCalc();
	}
	public String performanceCalc(){
		String perf="";
		if(this.avgRun >= 50 && this.avgWicket >= 3){
			perf="All Rounder";
		}
		else if(this.avgRun >= 50){
			perf="Super Batsman";
		}
		else if(this.avgWicket >= 3){
			perf="Super Bowler";
		}
		return perf;
	}
	public void getData(){
		System.out.println(String.format("%-15s %-10s %-10s %-10s %-10s %-10s %-10s",this.name,Integer.toString(this.runFirst),Integer.toString(this.runSecond),Integer.toString(this.avgRun),Integer.toString(this.wicketFirst),Integer.toString(this.wicketSecond),Integer.toString(this.avgWicket)));
	}
	public String getPerf(){
		return this.performance;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Cricketer[] c=new Cricketer[11];
		List<Cricketer> cList=new ArrayList<>();
		System.out.println("Enter all 11 players details");
		for(int i=0;i<11;i++){			
			String input=sc.nextLine();
			String[] a=new String[5];
			a=input.split(",");
			c[i]=new Cricketer(a[0],Integer.parseInt(a[1]),Integer.parseInt(a[2]),Integer.parseInt(a[3]),Integer.parseInt(a[4]));
			cList.add(c[i]);
		}
		System.out.println(String.format("%-15s %-10s %-10s %-10s %-10s %-10s %-10s","Name","Score1","Score2","Avg Score","wkts1","wkts2","Avg wkts"));
		System.out.println();
		System.out.println(String.format("%-28s %-15s","","All Rounder"));
		System.out.println();
		cList.stream()
		.filter(x -> x.getPerf().equals("All Rounder"))
		.forEach(x -> x.getData());
		System.out.println();
		System.out.println(String.format("%-28s %-15s","","Super Batsman"));
		System.out.println();
		cList.stream()
		.filter(x -> x.getPerf().equals("Super Batsman"))
		.forEach(x -> x.getData());
		System.out.println();
		System.out.println(String.format("%-28s %-15s","","Super Bowler"));
		System.out.println();
		cList.stream()
		.filter(x -> x.getPerf().equals("Super Bowler"))
		.forEach(x -> x.getData());
	}
}
//karthik,88,66,2,4
//Tom,65,25,0,1
//Raj,33,45,2,5
//Tej,21,33,2,1
//Ram,67,89,1,0
//Yash,10,15,0,0
//Kalyan,60,77,4,4
//Jhon,55,55,0,2
//Michel,21,100,2,1
//David,33,23,4,2
//Smith,88,49,0,3