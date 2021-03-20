package part2;

import java.util.Scanner;

public class Main {
	public static boolean checkIpAddress(String ipAddress){
	    String[] inputArr=ipAddress.split("\\.");
	    boolean status=false;
	    if(inputArr.length!=4){
	    	status=false;
	    }
	    else{
	    	if((Integer.parseInt(inputArr[0])<=255 && Integer.parseInt(inputArr[0])>=0) && (Integer.parseInt(inputArr[1])<=255 && Integer.parseInt(inputArr[1])>=0) && (Integer.parseInt(inputArr[2])<=255 && Integer.parseInt(inputArr[2])>=0) && (Integer.parseInt(inputArr[3])<=255 && Integer.parseInt(inputArr[3])>=0)){
	    		
	    		status=true;
	    	}
	    }
		return status;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
	    System.out.println("Enter the IPv4 address:");
	    String input=sc.nextLine();
	    if(checkIpAddress(input)){
	    	System.out.println("Valid");
	    }
	    else{
	    	System.out.println("Invalid");
	    }
	}

}
