package travel_javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TravelCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************WELCOME TO TRIPZY***********");
		Scanner scanner = new Scanner(System.in);
		HomeList h1=new HomeList();
		boolean isLoggedIn=false;
		while(!isLoggedIn) {
			System.out.println("1.Signup");
			System.out.println("2.Login");
			System.out.println("Choose an option:");
			int choice1=scanner.nextInt();
			switch(choice1){
			case 1:
				h1.signup();
				break;
			case 2:
				h1.login();
				isLoggedIn =true;
				break;
			default:System.out.println("Invalid option.Try again");
			}
			
		}
        System.out.println("***************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("**********HOME************");
		HomeList h=new HomeList();
		int choice;
		do {
			h.Home1();
			System.out.println("Choose your choice");
			choice=sc.nextInt();
			switch(choice) {
			case 1:h.Traveler_info();
				   break;
			case 2:h.Traveler_update();
					break;
			case 3:h.Trip_info();
					break;
			case 4:h.Trip_update();
					break;
			case 5:h.Expenses();
					break;
			case 6:h.Edit_expenses();
					break;
			case 7:h.Cancel_expenses();
					break;
			case 8:h.display_data();
			// Create an ExecutorService with 3 threads to handle each table's data
	        ExecutorService executorService = Executors.newFixedThreadPool(3);

	        // Submit the tasks to the executor
	        executorService.submit(() -> {
	            display_data("traveler");
	        });
	        executorService.submit(() -> {
	            display_data("trip");
	        });
	        executorService.submit(() -> {
	            display_data("expenses");
	        });

	        // Shutdown the executor service after submitting all tasks
	        executorService.shutdown();

	        try {
	            // Wait for all tasks to finish before exiting the program
	            if (!executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
	                System.out.println("Timeout reached before all tasks completed.");
	            }
	        } catch (InterruptedException e) {
	            System.out.println("Execution was interrupted: " + e.getMessage());
	        }
					break;		
			case 9:System.exit(0);
					break;
			default:System.out.println("Invalid choice");
					break;
			}
		}while(choice<=9);
	}

	private static void display_data(String string) {
		// TODO Auto-generated method stub
		
	}

}


