import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Salesperson{
	private String id;
	private String name;
	private Integer salesAmount;
	private String grade="0star";
	public Salesperson(String cnum,String cname,int salesAmount){
		this.id=cnum;
		this.name=cname;
		this.salesAmount=salesAmount;
	}
	public void printData(){
		System.out.println(String.format("%-5s %-20s %-10s %-10s",this.id,this.name,this.salesAmount,this.grade));
		System.out.println();
	}
	public String[] getData(){
		String[] data =new String[3];
		data[0]=this.id;
		data[1]=this.name;
		data[2]=Integer.toString(this.salesAmount);
		return data;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getGrade(){
		return this.grade;
	}
	  //Override the predefined hashCode function
	  @Override
	  public int hashCode(){
	    return (Integer) this.id.hashCode();
	  }
}

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of Salesperson's");
		int n=Integer.parseInt(sc.nextLine());
		if(n <= 0){
			System.out.println("Invalid input");
		}
		Salesperson[] user=new Salesperson[n];
		List<Salesperson> userList=new ArrayList<Salesperson>();
		for(int i=0;i<n;i++){
			System.out.println("Enter employee "+(i+1)+" details");
			String cInput=sc.nextLine();
			boolean repeated=false;
			for(int j=0;j<userList.size();j++){	
				Integer v1 = new Integer(cInput.split(",")[0].hashCode());
				Integer v2 = new Integer(userList.get(j).hashCode());
				repeated=v1.equals(v2);
				if(repeated==true){
					break;
				}
			}
			if(repeated==false){
				if(Integer.parseInt(cInput.split(",")[2])>=100000){					
					user[i]=new Salesperson(cInput.split(",")[0],cInput.split(",")[1],Integer.parseInt(cInput.split(",")[2]));
					userList.add(user[i]);
				}
				else
				{
					continue;
				}
			}
			else
			{
				System.out.println("Only unique ids are allowed");
				i--;
				continue;
			}
			if(i==n-1){
				Collections.sort(userList, (p1, p2) -> {
					Integer i1 = new Integer(p1.getData()[2]);
					Integer i2 = new Integer(p2.getData()[2]);
			         return i1.compareTo(i2); 
			      });
				int k=userList.size()-1;
				int starValue=5;
				while(k>=0){
					if(starValue==0){
						break;
					}
					if(k>0){
						if(Integer.parseInt(userList.get(k).getData()[2])>Integer.parseInt(userList.get(k-1).getData()[2])){						
							userList.get(k).setGrade(starValue+"star");
							starValue--;
						}
						else if(Integer.parseInt(userList.get(k).getData()[2])==Integer.parseInt(userList.get(k-1).getData()[2])){						
							userList.get(k).setGrade(starValue+"star");
						}
						k--;
					}
					else{
						userList.get(k).setGrade(starValue+"star");
						starValue--;
						k--;
					}
				}
			}				
		}
		for(int k=userList.size()-1;k>=0;k--){
			if(Integer.parseInt(userList.get(k).getGrade().split("")[0])>0){				
				userList.get(k).printData();
			}
		}
	}
}