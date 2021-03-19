import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size of inputs");
		Scanner sc=new Scanner(System.in);
		int input=Integer.parseInt(sc.nextLine());
		if(input<3){
			System.out.println("Invalid Input");
		}
		else{
			System.out.println("Enter "+input+" input values seperated by ','");
			String data=sc.nextLine();
			String[] dataArr=data.split(",");
			int len=dataArr.length;
			for(int i=0;i<len-1;i++){
				for(int j=0;j<len-1-i;j++){
					if(Integer.parseInt(dataArr[j])>Integer.parseInt(dataArr[j+1])){
						String temp=dataArr[j];
						dataArr[j]=dataArr[j+1];
						dataArr[j+1]=temp;
					}
				}
			}
			int sum=Integer.parseInt(dataArr[0])+Integer.parseInt(dataArr[len-1]);
			System.out.println("Sum of highest and lowest numbers is: "+sum);
		}
	}

}
