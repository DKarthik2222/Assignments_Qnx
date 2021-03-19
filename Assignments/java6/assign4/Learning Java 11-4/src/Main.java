import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Agent{
	private String name;
	private long generatedFund;
	public Agent(String name,long fund){
		this.name=name;
		this.generatedFund=fund;
	}
	public String[] getData(){
		String[] data={this.name,Long.toString(this.generatedFund)};
		return data;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter no of Agents:");
		Scanner sc=new Scanner(System.in);
		List<Agent> aList=new ArrayList<Agent>();
		int inLength=Integer.parseInt(sc.nextLine());
		Agent[] a=new Agent[inLength];
		for(int i=0;i<inLength;i++){			
			String[] inArr=sc.nextLine().split(",");
			a[i]=new Agent(inArr[0],Long.parseLong(inArr[1]));
			aList.add(a[i]);
		}
		Collections.sort(aList, (p1, p2) -> {
	         return p2.getData()[1].compareTo(p1.getData()[1]); 
	      });
		LinkedHashMap<String,String> starMap=new LinkedHashMap<String,String>();
		for(int i=0;i<inLength;i++){
			if(Long.parseLong(aList.get(i).getData()[1])>=2000000){
				starMap.put(aList.get(i).getData()[0], "*****");
			}
			else if(Long.parseLong(aList.get(i).getData()[1])>=1500000 && Long.parseLong(aList.get(i).getData()[1])<2000000){
				starMap.put(aList.get(i).getData()[0], "***");
			}
			else if(Long.parseLong(aList.get(i).getData()[1])>=1000000 && Long.parseLong(aList.get(i).getData()[1])<1500000){
				starMap.put(aList.get(i).getData()[0], "*");
			}
		}
		Set set=starMap.entrySet();
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        Map.Entry entry=(Map.Entry)itr.next();  
	        System.out.println(entry.getKey()+"="+entry.getValue());  
	    }  
	}
}
