package items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Database {

	private static Item a;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of the product: ");
		String name = in.nextLine();
		System.out.println();
		System.out.println("Please enter the price of the product: ");
		double price = in.nextDouble();
		System.out.println();
		System.out.println("Please enter the upc of the product: ");
		String upc = in.next();
		System.out.println();
		a = new Item(name,price,upc);
		System.out.println("The " + a.getName() + " costs " + a.getPrice() + " and the code is " + a.getUpc());
		insertItem(a.getName(),a.getPrice(),a.getUpc());
		in.close();
		
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/storage";
			String username = "root";
			String password = "A1hwca67";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection Successful");
			return conn;
			
		}catch(Exception e) {System.out.println(e);};
		
		return null;
	}

	public static void insertItem(String name, double price, String upc)throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("INSERT INTO item(item_name,item_price,item_code) VALUES('"+name+"',"+price+",'"+upc+"')");
			insert.executeUpdate();
			System.out.println("Got here");
		}catch(Exception e) {}
		finally {System.out.println("Insert complete");};
	}	
}
