
public class StudentResult {
	private String rollNumber;
	private String studentName;
	private double halfYearly;
	private double annualTotal;
	private String grade=null;
	public StudentResult(String rn, String sn, double hy){
		this.rollNumber=rn;
		this.studentName=sn;
		this.halfYearly=hy;
	}
	public String geRollNumber(){
		return this.rollNumber;
	}
	public String geName(){
		return this.studentName;
	}
	public double getHalfYearly(){
		return this.halfYearly;
	}
	public double getAnnualTotal(){
		return this.annualTotal;
	}
	public String getGrade(){
		return this.grade;
	}
	public void setAnnualTotal(double total){
		this.annualTotal=total;
	}
	public void setGrade(String grade){
		this.grade=grade;
	}
	public String getData(){
		return String.format("%-5s %-20s %-20s %-20s %-5s",this.rollNumber,this.studentName,Double.toString(this.halfYearly),Double.toString(this.annualTotal),this.grade);
	}
	  @Override
	  public int hashCode(){
	    return (int) this.rollNumber.hashCode();
	  }
}
