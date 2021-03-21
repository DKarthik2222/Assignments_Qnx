import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRecord {
	private static Map<Integer,Patient> patientMap=new HashMap<Integer,Patient>();
	
	public static int generateSerialNumber(int prevId){
		return prevId+1;
	}

	public static List<Patient> getAllPatients(){
		if(patientMap.size()==0){
			Patient[] p=new Patient[20];
			p[0]=new Patient("Ajay", "21 warangal", "Dr. Jhon");
			p[1]=new Patient("Nani", "19 Vizag", "Dr. Thor");
			p[2]=new Patient("Akhil", "9 Hyderabad", "Dr. Warner");
			p[0].setSerialNo(0);
			p[1].setSerialNo(1);
			p[2].setSerialNo(2);
			patientMap.put(new Integer(0), p[0]);
			patientMap.put(new Integer(1), p[1]);
			patientMap.put(new Integer(2), p[2]);
		}
		List<Patient> myList=new ArrayList<Patient>();
		patientMap.entrySet().stream().forEach(x -> myList.add(x.getValue()));
		return myList;
	}

	public static void patientEntry(Patient patient){ 
		if(patientMap.size()==0){
			Patient[] p=new Patient[20];
			Map<Integer,Patient> myMap=new HashMap<Integer, Patient>();
			p[0]=new Patient("Ajay", "19 warangal", "Dr. Karthik");
			p[1]=new Patient("Nani", "19 Vizag", "Dr. Marthandam");
			p[2]=new Patient("Akhil", "19 Hyderabad", "Dr. Karthik");
			p[0].setSerialNo(0);
			p[1].setSerialNo(1);
			p[2].setSerialNo(2);
			patientMap.put(0, p[0]);
			patientMap.put(1, p[1]);
			patientMap.put(2, p[2]);
		}
		patient.setSerialNo(patientMap.size());
		patientMap.put(patientMap.size(), patient);
	}

}
