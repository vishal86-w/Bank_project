package com.bank.console;

import com.bank.controls.ManagerControl;
import com.bank.project.App;

public class ManagerView {

	public static void managerMenu() {
	    while (true) {
	        System.out.println("\n=====  Manager Portal =====");
	        System.out.println("1. View All Customers");
	        System.out.println("2. Approve/Reject Customer Accounts");
	        System.out.println("3. View Transactions by Account");
	        System.out.println("4. View Branch Summary");
	        System.out.println("5. Create New Customer Account");
	        System.out.println("6. Update Customer Details");
	        System.out.println("7. Logout");

	        System.out.print("Enter your choice: ");
	        int choice = App.scanner.nextInt();
	        App.scanner.nextLine(); 

	        switch (choice) {
	            case 1:
	            	ManagerControl.viewAllCustomers(); 
	            	break;
	            case 2: 
	            	ManagerControl.approveOrRejectCustomer();
	            	break;
	            case 3:
	            	ManagerControl.viewTransactionsByAccount();
	            	break;
	            case 4: 
	            	ManagerControl.viewBranchSummary(); 
	            	break;
	            case 5: 
	            	ManagerControl.createCustomerAccount(); 
	            	break;
	            case 6: 
	            	ManagerControl.updateCustomerDetails(); 
	            	break;
	            case 7: 
	            	System.out.println("Logging out..."); 
	            	MainMenu.show(); 
	            	return;
	            default: 
	            	System.out.println("Invalid choice. Please try again.");
	            	managerMenu();
	            	break;
	        }
	    }
	}

}
