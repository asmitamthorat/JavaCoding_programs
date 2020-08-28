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

public class empWageCalculation_DAY23 {

	public static final int isPartTime=1;
	public static final int isFullTime=2;
	
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public empWageCalculation_DAY23(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {
		//Variables
		
		this.company = company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	
	public void computeEmpWage() {
	
		int empHrs=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;
		//Computation
		while (totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numOfWorkingDays) {
			totalWorkingDays=totalWorkingDays+1;
			int empCheck = (int) Math.floor(Math.random()*10)%3;
			switch (empCheck) {							// checking whether employee is full time ,part time or absent
				case isFullTime:
					empHrs=8;
					break;
				case isPartTime:
					empHrs=4;
					break;
				default:
					empHrs=0;
			}
			totalEmpHrs=totalEmpHrs+empHrs;
			System.out.println("Days :"+totalWorkingDays + "Emp Hr: " +empHrs);
					
		}	
		totalEmpWage=totalEmpHrs * empRatePerHour;
		
	}	
		public String toString() {
			return "total Emp Wage for Company:" +company+ " is :"+totalEmpWage;
	}
	
	public static void main(String[] args) {
		empWageCalculation_DAY23 bazar=new empWageCalculation_DAY23("bazar",20,2,10);  //creating object
		empWageCalculation_DAY23 mall=new empWageCalculation_DAY23("mall",20,2,10);  //creating a object reliance
		bazar.computeEmpWage();
		System.out.println(bazar);
		mall.computeEmpWage();
		System.out.println(mall);
		
	}

}