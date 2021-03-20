
public class ResultService {
	public static String gradeCalcultion(StudentResult result){
		double percentage=((result.getHalfYearly()+result.getAnnualTotal())/1000)*100;
		if(percentage>=90){
			return "E";
		}
		else if(percentage<90 && percentage>=75){
			return "V";
		}
		else if(percentage<75 && percentage>=60){
			return "G";
		}
		else if(percentage<60 && percentage>=45){
			return "P";
		}
		else{
			return "F";
		}
	}
}
