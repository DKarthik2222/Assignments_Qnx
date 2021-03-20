import java.util.Scanner;

public class Main {
	public static int countTotalBirds(int rowNumber){
		int a=0,b=1;
		int finalCount=0;
		for(int i=0;i<=rowNumber;i++){
			int sum=a+b;
			a=b;
			b=sum;
			if(i>0){
				finalCount=finalCount+a;
			}
		}
		return finalCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the no of rows of flying birds :");
		System.out.println("The total birds in the group are :"+countTotalBirds(sc.nextInt()));
	}

}
