import java.util.Arrays;
import java.util.Scanner;

class Employee{
	int id;
	String name;
	String address;
	String dept;
	String salary;
	public Employee(String[] edata){
		this.id=Integer.parseInt(edata[0]);
		this.name=edata[1];
		this.address=edata[2];
		this.dept=edata[3];
		this.salary=edata[4];
	}
	public void getData(){
		System.out.print(String.format("%-10d %-20s %-20s %-20s %-20s",this.id,this.name,this.address,this.dept,this.salary));
	}
	class EmployeeAccount{
		int userId;
		String password;
		String mailId;
		public EmployeeAccount(String[] adata){
			this.userId=Integer.parseInt(adata[0]);
			this.password=adata[1];
			this.mailId=adata[2];
		}
		public void getData(){
			System.out.println(String.format("%-10d %-20s %-20s",this.userId,this.password,this.mailId));
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("No.of Unix user accounts.");
		Scanner sc=new Scanner(System.in);
		int inputCount=Integer.parseInt(sc.nextLine());
		Employee[] outer=new Employee[inputCount];
		Employee.EmployeeAccount[] inner=new Employee.EmployeeAccount[inputCount];
		for(int i=0;i<inputCount;i++){
			System.out.println("Enter employee "+(i+1)+" details");
			String cInput=sc.nextLine();
			String[] employeeData=Arrays.copyOfRange(cInput.split(","), 0, 5);
			String[] accountData=Arrays.copyOfRange(cInput.split(","), 5, 8);
			outer[i]=new Employee(employeeData);
			inner[i]=outer[i].new EmployeeAccount(accountData);
		}
		for(int i=0;i<inputCount;i++){
			outer[i].getData();
			inner[i].getData();
		}
	}
}