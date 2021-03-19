import java.util.Scanner;

public class Palindrome {
	public static boolean palindrome(int num){
		int r,revNum=0,temp;
		temp=num;
		while(temp!=0){
			r=temp%10;
			revNum=(revNum*10)+r;
			temp=temp/10;
		}
		return revNum==num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a positive value greater than 11");
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		if(input<11){
			System.out.println("Invalid Input");
		}
		else{
			for(int i=11;i<=input;i++){
				if(palindrome(i)==true){
					System.out.print(i+" ");
				}
			}
		}
		
	}

}
