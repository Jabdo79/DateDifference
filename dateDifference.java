/*Jonathan Abdo
This class will ask for two dates and then
calculate the amount of time between them.
*/

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dateDifference {

	public static void main(String[] args) {
		
		LocalDate dateOne = dateCheck();
		System.out.println("Your first date is: "+dateOne);
		LocalDate dateTwo = dateCheck();
		System.out.println("Your second date is: "+dateTwo);
		//correct the chronological order of the users' dates and give the difference
		Period timeDiff=null;
		if (dateOne.isBefore(dateTwo)) {
			timeDiff = Period.between(dateOne, dateTwo);
		}
		else{
			timeDiff = Period.between(dateTwo, dateOne);
		}
		System.out.println("Your dates are "+timeDiff.getYears()+" years "+timeDiff.getMonths()+" months "+timeDiff.getDays()+" days apart.");
		
	}
	
	//Ask user for dates and parse to correct format, return the date object
	static LocalDate dateCheck(){
		LocalDate formattedDate;
		formattedDate = null;
		
		while (formattedDate==null) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter a date(ie:2016/08/23)");
			String userDate = input.nextLine();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			try {
				formattedDate = LocalDate.parse(userDate, dateFormat);
			} catch (Exception e) {
				System.out.println("Your date is invalid, try again.");
			}
		}
		return formattedDate;		
	}

}
