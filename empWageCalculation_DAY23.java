package javaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/************************************************************************************************
 * purpose: To perform Employee wage calculation
 *
 * 
 * @author asmita thorat
 *
 *
 *since 25/08/2020
 ***********************************************************************************************/
interface IComputeEmpWage{
	public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

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
		totalEmpWage=0;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	
	public String toString() {
		return "Total Emp Wage for Company:" +company+ " is :"+totalEmpWage;
	}
}	

public class empWageCalculation_DAY23 implements IComputeEmpWage {
	public static final int isPartTime=1;
	public static final int isFullTime=2;
	
	private int numOfCompany=0;
	private ArrayList<CompanyEmpWage> companyEmpWageList;
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
		
	public empWageCalculation_DAY23() {
		companyEmpWageList=new ArrayList<>();				//using array list to manage company employee list
		companyToEmpWageMap=new HashMap<>();
	}
	
public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
		
		
	}
	
public void computeEmpWage() {
		for (int i=0; i< companyEmpWageList.size(); i++) {
			CompanyEmpWage companyEmpWage=companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	
public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
		
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
		IComputeEmpWage empWageCalculation_DAY23 = new empWageCalculation_DAY23();
		empWageCalculation_DAY23.addCompanyEmpWage("HFBazzar", 20,2,10);
		empWageCalculation_DAY23.addCompanyEmpWage("AZBazzar", 20,2,10);
		empWageCalculation_DAY23.computeEmpWage();
		System.out.println("total Wage for HFBazzar  :"+empWageCalculation_DAY23.getTotalWage("HFBazzar"));
	}
}