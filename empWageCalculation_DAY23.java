package javaPractice;

public class empWageCalculation_DAY23 {

	public static void main (String[] args) {

		int isFullTime=2;
		int isPartTime=1;
		int emp_rate_per_hour=20;
		int empHours=0;
		int empWage=0;
		double empCheck = Math.floor(Math.random()*10)%3;		////computation of random number to check shift
		if (empCheck == isFullTime) {
			empHours=8;
		}
		else if  (empCheck==isPartTime){
			empHours=4;
		}
		else {
			empHours=0;
		}
		empWage=empHours*emp_rate_per_hour;
		System.out.println("Emp Wage: " +empWage);				//printing the employee wage
	}
}
