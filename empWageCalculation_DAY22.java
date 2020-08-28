package javaPractice;

/************************************************************************************************
 * purpose: To perform Employee wage calculation
 *
 * 
 * @author asmita thorat
 *
 *
 *since 25/08/2020
 ***********************************************************************************************/

public class empWageCalculation_DAY22 {

	public static final int isPartTime=1;
	public static final int isFullTime=2;
	
	public static int computeEmpWage(String company, int empRatePerHour,int numOf_workingDays, int maxHrs_inMonth) {
		//Variables
		int empHours=0;
		int empWage=0;
	
		int totalWorkingDays=0;
		int totalEmpHour=0;
		//Computation
		while (totalEmpHour<=maxHrs_inMonth &&  totalWorkingDays<numOf_workingDays) {
			totalWorkingDays=totalWorkingDays+1;
			int empCheck = (int) Math.floor(Math.random()*10)%3;
			switch (empCheck) {							// checking whether employee is full time ,part time or absent
				case isFullTime:
					empHours=8;
					break;
				case isPartTime:
					empHours=4;
					break;
				default:
					empHours=0;
		}
			totalEmpHour=totalEmpHour+empHours;
			System.out.println("Days#:"+totalWorkingDays + "Emp Hr: " +empHours);
			
			
				
			
	}			
		int totalEmpWage=totalEmpHour*empRatePerHour;
		System.out.println("Total employee wage: " +company+" is : "+totalEmpWage);	//printing the employee wage
		return totalEmpWage;
		
	}
	
	public static void main(String[] args) {
		computeEmpWage("Dmart",20,2,10);
		computeEmpWage("Reliance",10,4,20);
	}

}
