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

class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays= numOfWorkingDays;
		this.maxHoursPerMonth=maxHoursPerMonth;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	public String toString() {
		return "Total Emp Wage for Company:" +company+ " is :"+totalEmpWage;
	}
}	

public class empWageCalculation_DAY23{
	public static final int isPartTime=1;
	public static final int isFullTime=2;
	
	private int numOfCompany=0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public empWageCalculation_DAY23() {
		companyEmpWageArray=new CompanyEmpWage[5];
	}
	
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		
		companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		numOfCompany++;
		
	}
	
	private void computeEmpWage() {
		for (int i=0; i<numOfCompany; i++) {
			
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHrs=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;
		//Computation
		while (totalEmpHrs<=companyEmpWage.maxHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays) {
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
		return totalEmpHrs*companyEmpWage.empRatePerHour;
	}
	
	public static void main(String[] args) {
		empWageCalculation_DAY23 obj = new empWageCalculation_DAY23();
		obj.addCompanyEmpWage("Dmart", 20, 2, 10);
		obj.addCompanyEmpWage("Reliance", 10, 4, 10);
		obj.computeEmpWage();
	}
}