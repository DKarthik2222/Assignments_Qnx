import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	public Connection connect() {
		Connection cn=null;
		String url = "jdbc:postgresql://localhost/assignment1";
		String user="postgres";
		String password="1234";
		try{
			cn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	public static List<Customer> jsonData() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer=null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File("src/main/resources/data.json"));
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {};
			customer=mapper.readValue(inputStream, typeReference);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, SQLException {
		// TODO Auto-generated method stub
		Main sqlConnect=new Main();
		Connection connect=sqlConnect.connect();
		Statement statement=null;
		try {
			String query="create table customer(custId int primary key, custName varchar(240), city varchar(240), pin int)";
			statement=connect.createStatement();
			statement.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		List<Customer> customers=jsonData();
		ResultSet rs=null;
		for(int i=0;i<customers.size();i++) {
			String query="insert into customer values("+customers.get(i).getCustId()+",'"+customers.get(i).getCustName()+"','"+customers.get(i).getCity()+"',"+customers.get(i).getPin()+");";
			statement=connect.createStatement();
			statement.executeUpdate(query);
			query="select * from customer where custId="+customers.get(i).getCustId();
			statement=connect.createStatement();
			rs=statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(String.format("%-5s %-15s %-10s %-8s", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		}
	}

}