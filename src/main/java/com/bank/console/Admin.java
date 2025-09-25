package com.bank.console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bank.dao.ConnectionProvider;
import com.bank.project.App;

public class Admin {

	public static void AdminPortal()
	{
		
		System.out.println("*************Admin Login portal*************");
		System.out.println("1.Login");
		System.out.println("2.Return to menu");
		System.out.println("Choose your option:");
		int choice = App.scanner.nextInt();
		 App.scanner.nextLine();
		 
		switch (choice) {
		case 1:
			adminLogin();
			break;
		case 2:
			MainMenu.show();
			break;
		default:
			System.out.println("Invalid Option,try again...");
			break;
		}
		
	}
	public static boolean verifyLogin(String inputUsername,String inputPassword)
	{

		 try (Connection con = ConnectionProvider.getCon()) {
	            String sql = "SELECT * FROM admin WHERE user_name = ? AND password = ?";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, inputUsername);
	            stmt.setString(2, inputPassword);

	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); 

	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
		 
		 return false;	
	}
	public static void adminLogin()
	{
		
		try {
			System.out.println("Enter your user name: ");
			String inputUsername = App.scanner.nextLine();
			System.out.println("Enter your password");
			String inputPassword = App.scanner.nextLine();
			
			if(verifyLogin(inputUsername, inputPassword))
			{
				System.out.println("Login successful, welcome,"+inputUsername);
				AdminView.adminMenu();
				
			}
			else
			{
				System.out.println("Invalid credentials!!!");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
