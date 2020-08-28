package javaPractice;

/************************************************************************************************
 * purpose: To perform Employee wage computation
 *
 * 
 * @author asmita thorat
 *
 *
 *since 25/08/2020
 ***********************************************************************************************/

public class empWageCalculation_DAY23 {

	public static final int isFullTime=2;
	public static final int isPartTime=1;
	public static final int empRatePerHour=20;
	public static void main (String[] args) {
		//Variables
		int empHours=0;
		int empWage=0;
		//Computation
		int empCheck = (int) Math.floor(Math.random()*10)%3;
		switch (empCheck) {
			case isFullTime:
				empHours=8;
				break;
			case isPartTime:
				empHours=4;
				break;
			default:
				empHours=0;
		}
				
		empWage=empHours*empRatePerHour;
		System.out.println("Emp Wage: " +empWage);		//printing the employee wage
	}

}
