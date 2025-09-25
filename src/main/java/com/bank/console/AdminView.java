package com.bank.console;

import com.bank.controls.AdminControl;
import com.bank.project.App;

public class AdminView {
	public static void adminMenu() {
	    while (true) {
	        System.out.println("\n************* Admin Portal *************");
	        System.out.println("1. Add Manager");
	        System.out.println("2. Edit Manager");
	        System.out.println("3. Delete Manager");
	        System.out.println("4. Approve/Reject Manager");
	        System.out.println("5. View Transaction Reports");
	        System.out.println("6. Logout");
	        System.out.print("Choose your option: ");

	        int choice = App.scanner.nextInt();
	        App.scanner.nextLine(); 

	        switch (choice) {
	            case 1: 
	            	AdminControl.addManager();
	            	break;
	            case 2: 
	            	AdminControl.editManager();
	            	break;
	            case 3: 
	            	AdminControl.deleteManager();
	            	break;
	            case 4:
	            	AdminControl.approveOrRejectManager();
	            	break;
	            case 5:
	            	AdminControl.viewTransactionReports();
	            	break;
	            case 6: 
	            	System.out.println("Logging out...");
	            	MainMenu.show();
	            	return;
	            default: 
	            	System.out.println("Invalid option. Try again.");
	            	adminMenu();
	            	break;
	        }
	    }
	}

}
