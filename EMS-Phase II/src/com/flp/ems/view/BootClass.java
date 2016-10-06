package com.flp.ems.view;

import com.flp.ems.domain.Employee;

public class BootClass {
public static void main(String[] args) {
	UserInteraction userInteraction= new UserInteraction();
	
	userInteraction.addEmployee("saurabh","saurabh123", 9876543210L , "01/01/1990", "01/01/2016", "address1", 0, 0, 0);
	userInteraction.addEmployee("tanay","tanay123", 9876543211L , "01/01/1990", "01/01/2016", "address1", 0, 0, 0);
	userInteraction.addEmployee("pawan","pawan123", 9876543212L , "01/01/1990", "01/01/2016", "address1", 0, 0, 0);
	
	userInteraction.getAllEmployee();
	System.out.println();
	
	userInteraction.searchEmployee(2);
	userInteraction.searchEmployee("pawan123");
	
	userInteraction.removeEmployee(1);
	userInteraction.modifyEmployee("arnava","tanay123", 9876543213L , "04/04/1990", "04/04/2016", "address1", 0, 0, 0);
	
	
	
	
	userInteraction.getAllEmployee();
	
}

//public void menuSelection(){
//	
//}

}