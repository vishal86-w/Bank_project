package com.bank.console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.bank.dao.ConnectionProvider;
import com.bank.model.UserModel;
import com.bank.project.App;

public class User {
	
	public static void UserPortal()
	{
		
		try {
			
			System.out.println("*************User portal*************");
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("3.Return to menu");
			System.out.println("Choose your option:");
			int choice = App.scanner.nextInt();
			App.scanner.nextLine();
			switch (choice) {
			case 1:
				// user login
				userLogin();
				break;
			case 2:
				//user register
				userRegister();
				break;
			case 3:
				// return to menu
				MainMenu.show();
				break;
			default:
				System.out.println("Invalid Option,try again...");
				UserPortal();
				break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static int count = 0  ;
	public static void getCustomerCount()
	{
		try (Connection con = ConnectionProvider.getCon()){
			String sql ="select count(*) from customer";
			Statement smt = con.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			if(rs.next())
			{
				String data = rs.getString(1);
				count = Integer.parseInt(data);
				//System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void userRegister()
	{
		getCustomerCount();
		String BranchId = "SIB090797";
		String accNum = "90808766600";
		
		String getcount=Integer.toString(count);
		String AccountNum = accNum+""+getcount;
		
	
		UserModel user = new UserModel();
		
		
		try(Connection con = ConnectionProvider.getCon()) {
			
			user.setAccountHolderNumber(AccountNum);
			user.setBranchId(BranchId);
			System.out.println("Enter your name (name should be same as aadhar) : ");
			user.setAccountHolderName(App.scanner.nextLine());
			System.out.println("Enter the branch name: ");
			user.setBranchName(App.scanner.nextLine());
			System.out.println("Enter your email : ");
			user.setAccountHolderEmail(App.scanner.nextLine());
			System.out.println("Enter your password :");
			user.setAccPassword(App.scanner.nextLine());
			System.out.println("Enter the account type [1=Saving , 2=Current]:");
			int acctype = App.scanner.nextInt();
			App.scanner.nextLine();
			switch (acctype) {
			case 1:
				user.setAccountType("saving");
				break;
			case 2:
				user.setAccountType("current");
				break;
			default:
				System.out.println("Invalid option,try again...");
				userRegister();
				break;
			}
			String sql = "INSERT INTO customer (account_holder_number, branch_id, branch_name, account_holder_name, account_holder_email, acc_password, account_type, balance, amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement ps = con.prepareStatement(sql);

		    ps.setString(1, user.getAccountHolderNumber());
		    ps.setString(2, user.getBranchId());
		    ps.setString(3, user.getBranchName());
		    ps.setString(4, user.getAccountHolderName());
		    ps.setString(5, user.getAccountHolderEmail());
		    ps.setString(6, user.getAccPassword());
		    ps.setString(7, user.getAccountType());
		    ps.setDouble(8, 0.0); // Initial balance
		    ps.setDouble(9, 0.0); // Initial amount
		    ps.setBoolean(10, false); // Active status
		    int i = ps.executeUpdate();
			if(i==1)
			{
				System.out.println("Registered Successfully,please wait for the approval");
			}
			else
			{
				System.out.println("Registeration failed,Invalid input");
			}

		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
				
	}

	public static void VerifyUser(String ACC_ID,String email ,String password)
	{
		try(Connection con = ConnectionProvider.getCon()) 
		{
			
		String sql = "select * from customer where  account_holder_number =? and account_holder_email=? and acc_password = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ACC_ID);
		ps.setString(2, email);
		ps.setString(3, password);
		
		ResultSet rs = ps.executeQuery();
		
			if (rs.next())
			{
				System.out.println("Login successful, welcome"+ rs.getString("account_holder_name"));
				UserView.userAction();
			}
			else
			{
				System.out.println("Invalid email or password");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void userLogin()
	{
	
	System.out.println("Enter your Account ID: ");
	String ACC_ID = App.scanner.nextLine();
	System.out.println("Enter your email: ");
	String email = App.scanner.nextLine();
	System.out.println("Enter your password: ");
	String password = App.scanner.nextLine();
	VerifyUser(ACC_ID, email, password);
	
	}

}
