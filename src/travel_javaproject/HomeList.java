package travel_javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HomeList implements DAQTravel{
	private Connection conn;
	private String currentUser;
	
	@Override
	public void signup(){
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/tripzy1?useSSL=false","root","root");
			if (conn == null) {
	            System.out.println("Database connection failed.");
	            return;
	        }
		}catch(SQLException e) {
			System.out.println("Database conncetion failed: "+e.getMessage());
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		System.out.println("Enter email");
		String email=sc.nextLine();
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into users(username,password,email) values (?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
			System.out.println("Signup successful!Please Login.");
		}catch(SQLException e) {
			System.out.println("Signup failed: "+e.getMessage());
		}
		
	}

	@Override
	public void login() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/tripzy1?useSSL=false","root","root");
		}catch(SQLException e) {
			System.out.println("Database conncetion failed: "+e.getMessage());
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				currentUser=username;
				System.out.println("Login Successfully.Welcome " +username);
			}else {
				System.out.println("Invalid credentials.Try again.");
			}
		}catch(SQLException e) {
			System.out.println("Login failed: "+e.getMessage());
		}
		
	}
	

	@Override
	public void Home1() {
		System.out.println("1.Traveler_info");
		System.out.println("2.Traveler update");
		System.out.println("3:Trip Information");
		System.out.println("4.Trip update");
		System.out.println("5.Expenses");
		System.out.println("6.:Edit_expenses");
		System.out.println("7.Cancel_expenses");
		System.out.println("8.Display data");
		System.out.println("9.Exit");
		System.out.println("******************");
		
	}

	@Override
	public void Traveler_info() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1","root","root");
			PreparedStatement ps=con.prepareStatement("insert into traveler(id,name,travel_num,phn_no) values(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id:");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name:");
			String name = sc.next(); 
			System.out.println("Enter travel number:");
			String travel_num = sc.next();
			sc.nextLine();
			System.out.println("Enter phone number:");
			String phn_no = sc.next();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, travel_num);
			ps.setString(4, phn_no);
			
			int result = ps.executeUpdate();
			System.out.println(result + " travelers data added successfully.");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("****************************");
	}
	
	@Override
	public void Traveler_update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1","root","root");
			PreparedStatement ps=con.prepareStatement("UPDATE traveler SET name=?, travel_num=?, phn_no=? WHERE id=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id:");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name:");
			String name = sc.next(); 
			System.out.println("Enter travel number:");
			String travel_num = sc.next();
			sc.nextLine();
			System.out.println("Enter phone number:");
			String phn_no = sc.next();
			ps.setString(1, name);
			ps.setString(2, travel_num);
			ps.setString(3, phn_no);
			ps.setInt(4, id);
			
			int result = ps.executeUpdate();
			System.out.println(result + " travelers data added successfully.");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("****************************");
		
	}
	
	
	@Override
	public void Trip_info() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into trip (trip_id, destination, start_date, end_date,id) values (?, ?, ?, ?, ?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter trip id:");
			int trip_id = sc.nextInt();
			System.out.println("Enter destination:");
			String destination = sc.next();
			sc.nextLine();
			System.out.println("Enter trip start date (YYYY-MM-DD):");
			String start_date = sc.nextLine();
			System.out.println("Enter trip end date (YYYY-MM-DD):");
			String end_date = sc.nextLine();
			System.out.println("Enter traveler id");
			int id=sc.nextInt();
			ps.setInt(1, trip_id);
			ps.setString(2, destination);
			ps.setString(3, start_date);
			ps.setString(4, end_date);
			ps.setInt(5, id);
			int result = ps.executeUpdate();
			System.out.println(result + " trip data added successfully.");
			} catch (Exception e) {
			System.out.println(e);
			}
		System.out.println("***************************");
	}
	
	@Override
	public void Trip_update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1", "root", "root");
			PreparedStatement ps = con.prepareStatement("update trip set trip_id=?,destination=?,start_date=?,end_date=? where id=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter trip id:");
			int trip_id = sc.nextInt();
			System.out.println("Enter destination:");
			String destination = sc.next();
			sc.nextLine();
			System.out.println("Enter trip start date (YYYY-MM-DD):");
			String start_date = sc.nextLine();
			System.out.println("Enter trip end date (YYYY-MM-DD):");
			String end_date = sc.nextLine();
			System.out.println("Enter traveler id");
			int id=sc.nextInt();
			ps.setInt(1, trip_id);
			ps.setString(2, destination);
			ps.setString(3, start_date);
			ps.setString(4, end_date);
			ps.setInt(5, id);
			int result = ps.executeUpdate();
			System.out.println(result + " trip data added successfully.");
			} catch (Exception e) {
			System.out.println(e);
			}
		System.out.println("***************************");
		
	}

	@Override
	public void Expenses() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into expenses (eid,category, amount, edate,id,trip_id) VALUES (?, ?, ?, ?, ?, ?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expense id");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter expense category (Transportation, Food, Accommodation, etc.):");
			String category = sc.nextLine();
			System.out.println("Enter amount:");
			double amount = sc.nextDouble();
			sc.nextLine(); 
			System.out.println("Enter date of the expense (YYYY-MM-DD):");
			String edate = sc.nextLine();
			System.out.println("Enter traveler id");
			int id = sc.nextInt();
			sc.nextLine(); 
			System.out.println("Enter trip id");
			int trip_id = sc.nextInt();
			sc.nextLine(); 
			ps.setInt(1, eid);
			ps.setString(2, category);
			ps.setDouble(3, amount);
			ps.setString(4, edate);
			ps.setInt(5, id);
			ps.setInt(6, trip_id);
			int result = ps.executeUpdate();
			System.out.println(result + " expense added successfully.");
			} catch (Exception e) {
			System.out.println(e);
			}
		System.out.println("*****************************");
	}

	@Override
	public void Edit_expenses() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1", "root", "root");
			PreparedStatement ps = con.prepareStatement("update expenses set eid=?,category=?, amount=?, edate=?,id=? where trip_id=? ");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expense id");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter expense category (Transportation, Food, Accommodation, etc.):");
			String category = sc.nextLine();
			System.out.println("Enter amount:");
			double amount = sc.nextDouble();
			sc.nextLine(); 
			System.out.println("Enter date of the expense (YYYY-MM-DD):");
			String edate = sc.nextLine();
			System.out.println("Enter traveler id");
			int id = sc.nextInt();
			sc.nextLine(); 
			System.out.println("Enter trip id");
			int trip_id = sc.nextInt();
			sc.nextLine(); 
		
			ps.setInt(1, eid);
			ps.setString(2, category);
			ps.setDouble(3, amount);
			ps.setString(4, edate);
			ps.setInt(5, id);
			ps.setInt(6, trip_id);
			int result = ps.executeUpdate();
			System.out.println(result + " expense update added successfully.");
			} catch (Exception e) {
			System.out.println(e);
			}
		System.out.println("*****************************");
		
	}

	@Override
	public void Cancel_expenses() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from expenses where eid=?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expense id");
			int eid=sc.nextInt();
			sc.nextLine();
			
			ps.setInt(1, eid);
			
			int result = ps.executeUpdate();
			System.out.println(result + " expense deleted successfully.");
			} catch (Exception e) {
			System.out.println(e);
			}
		System.out.println("*****************************");
	}

	@Override
	public void display_data() {
		try {
			//Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Creating connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tripzy1","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from traveler");
			Thread.sleep(1000);
			System.out.println("Data from traveler table");
			while(rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
				 System.out.println("********************************************************");
				 System.out.println("**  ID           : " + rs.getInt(1) + "					**");
                 System.out.println("**  Name         : " + rs.getString(2) + "				**");
                 System.out.println("**  Travel Number: " + rs.getString(3) + "				**");
                 System.out.println("**  Phone Number : " + rs.getString(4) + "				**");
                 System.out.println("********************************************************");
			}
			
			Thread.sleep(2000);
			rs = st.executeQuery("select * from trip");
		    System.out.println("Data from trip table:");
		    while (rs.next()) {
//		       System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getString(4) + rs.getInt(5));
		       System.out.println("************************************************************");
		       System.out.println("**  TripID		: " + rs.getInt(1) + "					**");
               System.out.println("**  Destinations	: " + rs.getString(2) + "				**");
               System.out.println("**  Start_date		: " + rs.getString(3) + "				**");
               System.out.println("**  End_date		: " + rs.getString(4) + "				**");
               System.out.println("**  ID 			: " + rs.getInt(5) + "					**");
               System.out.println("************************************************************");
		   }
		    Thread.sleep(3000);
		    rs = st.executeQuery("select * from expenses");
		    System.out.println("Data from expenses table:");
		    while (rs.next()) {
//		       System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
			   System.out.println("********************************************************");
			   System.out.println("**  ExpensesID		: " + rs.getInt(1) + "				**");
	           System.out.println("**  Category		: " + rs.getString(2) + "			**");
	           System.out.println("**  Amount		: " + rs.getString(3) + "				**");
	           System.out.println("**  Expenses_date	: " + rs.getString(4) + "			**");
	           System.out.println("**  ID 			: " + rs.getInt(5) + "				**");
	           System.out.println("**  TripID 		: " + rs.getInt(6) + "				**");
	           System.out.println("********************************************************");
		   }
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("**********************");
		
	}

	

	

	

	

	
}
