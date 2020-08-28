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

public class empWageCalculation_DAY22 {

	public static void main (String[] args) {
		int CheckPresence = 1;
		double empCheck = Math.floor(Math.random()*10)%2;
		if (empCheck == CheckPresence) {						//checking whether employee is present or absent
			System.out.println("employee is present");
		}
		else {
			System.out.println("employee is absent");
		}
	}

}
