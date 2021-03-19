import java.util.Scanner;

public class Num_Series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a positive value n to generate n number series");
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		if(input<1){
			System.out.println("Invalid Input");
		}
		else{
			for(int i=1,j=2;i<=input;i++,j++){
				System.out.print(i*j+" ");
			}
		}
	}

}
