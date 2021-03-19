import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws PriceException, GradeMismatchException, EssentialCommodityException {
		// TODO Auto-generated method stub
		System.out.print("Enter no of Items:");
		Scanner sc=new Scanner(System.in);
		int inLength=Integer.parseInt(sc.nextLine());
		List<String> myList=new ArrayList<String>();
		for(int i=0;i<inLength;i++){			
			String input=sc.nextLine();
			myList.add(input);
		}
		ItemService is=new ItemService();
		Set<Item> dataSet= is.collectAllItems(myList);
		System.out.println(String.format("%-5s %-20s %-10s %-10s %-5s","id","Name","Purchase","Sales","Grade"));
		for(Item value: dataSet){
			value.getData();
		}
	}
}
//1001,Salt,20.00,22.00,E
//1002,Biryani Masala,45.00,55.00,N
//1003,Cake,33.00,60.00,N