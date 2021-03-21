
public class Patient {
	private String serialNo;
	private String patientName;
	private String address;
	private String doctorName;
	public Patient(String patientName, String address, String doctorName) {
		this.patientName = patientName;
		this.address = address;
		this.doctorName = doctorName;
	}
	public void setSerialNo(int num){
		this.serialNo=Integer.toString(num+1);
	}
	public String getDoctor(){
		return this.doctorName;
	}
	public String getName(){
		return this.patientName;
	}
	@Override
	public String toString(){
		return String.format("%-5s %-20s %-20s %-20s",this.serialNo,this.patientName,this.address,this.doctorName);
	}
}
