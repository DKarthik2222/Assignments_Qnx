import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<StudentResult> convertToList(String roll) throws IOException{
		Scanner sc=new Scanner(System.in);
		List<StudentResult> list = new ArrayList<StudentResult>();
		File file = new File("C:\\Users\\dkarthik\\Desktop\\StudentResult.txt");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      String[] stringArray = data.split("\r\n");
	      StudentResult[] studentResult=new StudentResult[stringArray.length];
	      for(int i=0;i<stringArray.length;i++){
	    	  String[] sData=stringArray[i].split("-");
	    	  if(sData.length<=3){	    		  
	    		  studentResult[i]=new StudentResult(sData[0],sData[1],Double.parseDouble(sData[2]));
	    		  list.add(studentResult[i]);
	    	  }
	    	  else{
	    		  studentResult[i]=new StudentResult(sData[0],sData[1],Double.parseDouble(sData[2]));
	    		  studentResult[i].setAnnualTotal(Double.parseDouble(sData[3]));
	    		  studentResult[i].setGrade(sData[4]);
	    		  list.add(studentResult[i]);
	    	  }
	      }
	      boolean exists=false;
	      for(int i=0;i<list.size();i++){
	    	  exists=roll.hashCode()==list.get(i).hashCode();
		      if(exists){
		    	  System.out.println("Enter annual exam’s marks for English, Language, Mathematics, Science, Social Study seperated by ','");
					String[] marks=sc.nextLine().split(",");
					double totalMarks=0;
					for(int j=0;j<marks.length;j++){
						totalMarks += Double.parseDouble(marks[j]);
					}
					list.get(i).setAnnualTotal(totalMarks);
					list.get(i).setGrade(ResultService.gradeCalcultion(list.get(i)));
		    	  return list;
		      }
	      }
	      return null;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter roll number: ");
		List<StudentResult> currentList=convertToList(sc.nextLine());
		if(currentList==null){
			System.out.println("Student Not found");
		}
		else{
			PrintWriter pw=new PrintWriter("C:\\Users\\dkarthik\\Desktop\\StudentResult.txt");
			for(int i=0;i<currentList.size();i++){
				if(currentList.get(i).getGrade()!=null){
					System.out.println(currentList.get(i).geRollNumber()+"-"+currentList.get(i).geName()+"-"+currentList.get(i).getHalfYearly()+"-"+currentList.get(i).getAnnualTotal()+"-"+currentList.get(i).getGrade());
					pw.println(currentList.get(i).geRollNumber()+"-"+currentList.get(i).geName()+"-"+currentList.get(i).getHalfYearly()+"-"+currentList.get(i).getAnnualTotal()+"-"+currentList.get(i).getGrade());
				}
				else{
					System.out.println(currentList.get(i).geRollNumber()+"-"+currentList.get(i).geName()+"-"+currentList.get(i).getHalfYearly());
					pw.println(currentList.get(i).geRollNumber()+"-"+currentList.get(i).geName()+"-"+currentList.get(i).getHalfYearly());
				}
			}
			pw.close();
		}
	}
}
//10-Aveek Sharma-325.00
//11-Saranya Ishawran-415.00
//12-Aneek Chouhan-225.00
//13-Rajesh Murugan-295.00
//14-Bobita Ghosh-375.00
//15-Neha Kulkarni-315.00
//16-Reema Krishnamurthy-350.00

//99,88,57,100,92
