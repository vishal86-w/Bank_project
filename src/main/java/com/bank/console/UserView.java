package com.bank.console;

import com.bank.controls.UserControl;
import com.bank.controls.UserEmailControl;
import com.bank.project.App;

public class UserView {

	public static void userAction()
	{
			System.out.println("***********User Menu***********");
			
			System.out.println("1.Deposit money");
			System.out.println("2.Withdraw money");
			System.out.println("3.View profile");
			System.out.println("4.Transation history");
			System.out.println("5.Transfer money");
			System.out.println("6.Check balance");
			System.out.println("7.Mini statement");
			System.out.println("8.Log out");
			System.out.println("Enter your choice: ");
			int option = App.scanner.nextInt();
			App.scanner.nextLine();
			switch (option) {
			case 1:
				UserControl.deposit();
				break;
			case 2:
				UserControl.withdraw();
				break;
			case 3:
				UserControl.viewProfile();
				break;
			case 4:
				UserControl.viewTransactions();
				break;
			case 5:
				UserControl.transfer();
				break;
			case 6:
				UserControl.checkBalance();
				break;
			case 7:
	            System.out.print("Enter your Account ID: ");
	            String accId = App.scanner.nextLine().trim();
	            UserEmailControl.generateAndSendReport(accId);
	            break;
			case 8:
				UserControl.logout();
				break;
			default:
				System.out.println("Invalid choice , Try Again!!!");
				userAction();
				break;
			}
	}
		

}
