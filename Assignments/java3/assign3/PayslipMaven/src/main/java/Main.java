import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Employee{
	private int id;
	private String name;
	private String grade;
	private int basic;
	public Employee(String data){
		String[] cData=data.split("-");
		this.id=Integer.parseInt(cData[0]);
		this.name=cData[1];
		this.grade=cData[2];
		this.basic=Integer.parseInt(cData[3]);
	}
	public String[] getData(){
		String[] data =new String[4];
		data[0]=Integer.toString(this.id);
		data[1]=this.name;
		data[2]=this.grade;
		data[3]=Integer.toString(this.basic);
		return data;
	}
	public String toString(){
		return String.format("%-5s %-10s %-10s %-10s",Integer.toString(this.id),this.name,this.grade,Integer.toString(this.basic));
	}
}
class Payment{
	private int id;
	private int basic;
	private int allowance;
	private int gross;
	int tax;
	private int net;
	PayService ps=new PayService();
	public Payment(Employee emp){
		this.id=Integer.parseInt(emp.getData()[0]);
		this.basic=Integer.parseInt(emp.getData()[3]);
		this.allowance=ps.allowanceCalculation(emp);
		this.gross=this.basic+this.allowance;
		this.tax=ps.taxCalculation(gross);
		this.net=this.gross-this.tax;
	}
	public String[] getData(){
		String[] data =new String[6];
		data[0]=Integer.toString(this.id);
		data[1]=Integer.toString(this.basic);
		data[2]=Integer.toString(this.allowance);
		data[3]=Integer.toString(this.gross);
		data[4]=Integer.toString(this.tax);
		data[5]=Integer.toString(this.net);
		return data;
	}
	public String toString(){
		return String.format("%-5s %-10s %-10s %-10s %-10s %-10s",Integer.toString(this.id),Integer.toString(this.basic),Integer.toString(this.allowance),Integer.toString(this.gross),Integer.toString(this.tax),Integer.toString(this.net));
	}
}
class PayService{
	public int allowanceCalculation(Employee emp){
		int basic=Integer.parseInt(emp.getData()[3]);
		char grade=emp.getData()[2].charAt(0);
		int allowance = 0;
		switch(grade){
		case 'A': allowance=(basic/100)*35;
					break;
		case 'B': allowance=(basic/100)*40;
					break;
		case 'C': allowance=(basic/100)*45;
					break;
		}
		return allowance;
	}
	public int taxCalculation(int gross){
		int tax = 0;
		if(gross>=45000){
			tax=(gross/100)*10;
		}
		else if(gross>=30000 && gross<45000){
			tax=(int) Math.round((gross/100)*7.5);
		}
		else if(gross<30000){
			tax=(gross/100)*5;
		}
		return tax;
	}
}
public class Main {
	private static List<Employee> readEmployeesFromFile() throws IOException{
		List<Employee> list = new ArrayList<Employee>();
		File file = new File("C:\\Users\\dkarthik\\Desktop\\Employee.txt");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      String[] stringArray = data.split("\r\n");
	      Employee[] emp=new Employee[stringArray.length];
	      for(int i=0;i<stringArray.length;i++){
	    	  emp[i]=new Employee(stringArray[i]);
	    	  list.add(emp[i]);
	      }
	      return list;
	}
	private static void writePaymentsToFile(List<Payment> paymentList,List<Employee> employeeList) throws IOException{
		String filename="C:\\Users\\dkarthik\\Desktop\\Payment.txt";
	    JSONArray messages = new JSONArray();
	    for(int i=0;i<employeeList.size();i++){
	    	JSONObject sampleObject = new JSONObject();
	    	sampleObject.put("Id", employeeList.get(i).getData()[0]);
	    	sampleObject.put("Id", employeeList.get(i).getData()[0]);
	    	sampleObject.put("Name", employeeList.get(i).getData()[1]);
	    	sampleObject.put("Grade", employeeList.get(i).getData()[2]);
	    	sampleObject.put("Basic", employeeList.get(i).getData()[3]);
	    	sampleObject.put("Allowance", paymentList.get(i).getData()[2]);
	    	sampleObject.put("Gross", paymentList.get(i).getData()[3]);
	    	sampleObject.put("Tax", paymentList.get(i).getData()[4]);
	    	sampleObject.put("Net", paymentList.get(i).getData()[5]);
	    	messages.add(sampleObject);
		}
	    Files.write(Paths.get(filename), messages.toJSONString().getBytes());
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		List<Employee> elist = new ArrayList<Employee>();
		elist=readEmployeesFromFile();
		List<Payment> listP = new ArrayList<Payment>();
		Payment[] pmnt=new Payment[elist.size()];
		for(int i=0;i<elist.size();i++){
			pmnt[i]=new Payment(elist.get(i));
			listP.add(pmnt[i]);
		}
		writePaymentsToFile(listP,elist);
	}
}
