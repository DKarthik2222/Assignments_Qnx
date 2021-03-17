import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UnixUser{
	String userid;
	String employeeId;
	String username;
	String userType;
	UserService us=new UserService();
	public UnixUser(String[] edata,String previousId){
		String[] cdata=new String[2];
		this.employeeId=edata[0];
		this.username=edata[1];
		this.userType=edata[2];
		cdata[0]=previousId;
		cdata[1]=this.userType;
		this.userid=us.createUser(cdata);
	}
	public void getData(){
		System.out.print(String.format("%-10s %-10s %-20s %-10",this.userid,this.employeeId,this.username,this.userType));
	}
	public String getUserid(){
		return this.userid;
	}
	public String getEmployeeId(){
		return this.employeeId;
	}
	  //Override the predefined hashCode function
	  @Override
	  public int hashCode(){
	    return (int) employeeId.hashCode();
	  }
}
class UserData{
	List<UnixUser> userList;
	void save(List<UnixUser> data){
		userList= data;
	}
	List<UnixUser> displayAllUsers(){
		return userList;
	}
}
class UserService{
	public static boolean checkPrime(int num){
		boolean flag=false;
		for (int i = 2; i <= num / 2; i++) {
		      if (num % i == 0) {
		        flag = true;
		        break;
		      }
		    }
		return flag;
	}
	public static String createUser(String[] data){
		int userId = 102;
		for(int i=Integer.parseInt(data[0])+1;i>0;i++){
			if(data[1].equalsIgnoreCase("super")){
				boolean status=checkPrime(i);
				if(status==false){
					userId = i;
					break;
				}
				else
				{
					continue;
				}
			}
			else if(data[1].equalsIgnoreCase("ordinary")){
				boolean status=checkPrime(i);
				if(status==true){
					userId = i;
					break;
				}
				else
				{
					continue;
				}
			}
		}
		return Integer.toString(userId);
	}
}
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("No.of Unix user accounts.");
		Scanner sc=new Scanner(System.in);
		int inputCount=Integer.parseInt(sc.nextLine());
		UnixUser[] user=new UnixUser[inputCount];
		List<UnixUser> userList=new ArrayList<UnixUser>();
		for(int i=0;i<inputCount;i++){
			System.out.println("Enter employee "+(i+1)+" details");
			String cInput=sc.nextLine();
			boolean repeated=false;
			for(int j=0;j<userList.size();j++){				
				repeated=cInput.split(",")[0].hashCode()==user[j].hashCode();
			}
			if(cInput.split(",")[2].equalsIgnoreCase("super") || cInput.split(",")[2].equalsIgnoreCase("ordinary")){
				if(repeated==false){
					if(i==0){					
						user[i]=new UnixUser(cInput.split(","),Integer.toString(1001));
					}
					else
					{
						user[i]=new UnixUser(cInput.split(","),user[i-1].getUserid());
					}
					userList.add(user[i]);
				}
				else
				{
					System.out.println("Only unique ids are allowed");
					i--;
				}
			}
			else{
				throw new TypeNotPresentException(cInput.split(",")[2], null);
			}
			
		}
		UserData userdata=new UserData();
		userdata.save(userList);
		userdata.displayAllUsers().stream()
		.forEach(x->System.out.println(x.userid+" "+x.employeeId+" "+x.username+" "+x.userType));
	}
}
//72562,Mike,Super
//32456,Karthik,Super
//32456,Michel,Ordinary
//4,dsf,SuPer