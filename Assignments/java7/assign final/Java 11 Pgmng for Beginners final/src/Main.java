import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	private static List<Patient> filterPatient (String doctorName){
		System.out.println();
		System.out.print(doctorName+"=>");
		return PatientRecord.getAllPatients().stream().filter(x -> x.getDoctor().equals(doctorName)).collect(Collectors.toList());
	}
	public static void menu(){
		System.out.println("1. Patient Entry.");
		System.out.println("2. Display All Patient for the day.");
		System.out.println("3. Display Patient Doctor-wise.");
		System.out.println("4. Exit");
		System.out.println("Enter Choice(1-4).");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		menu();
		boolean terminate=false;
		while(terminate==false){
			int input=Integer.parseInt(sc.nextLine());
			switch(input){
			case 1:String newEntry=sc.nextLine();
					Patient p=new Patient(newEntry.split(",")[0],newEntry.split(",")[1],newEntry.split(",")[2]);
					PatientRecord.patientEntry(p);
					break;
			case 2: List<Patient> pList=PatientRecord.getAllPatients();
					pList.stream().forEach(x -> System.out.println( x.toString()));
					break;
			case 3: List<Patient> currentdata=PatientRecord.getAllPatients();
					List<String> myList=new ArrayList<String>();
					currentdata.stream().forEach(x -> myList.add(x.getDoctor()));
					myList.stream().distinct().forEach(x -> filterPatient(x).stream().forEach(y -> System.out.print("   "+y.getName())));
					System.out.println();
					break;
			case 4: terminate=true;
					break;
			default: menu();
			}
		}
	}

}
