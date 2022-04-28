/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 3.11-Find the number of days in a month
 */

/*
 *
 * @author tofig
 */

/*
(Find the number of days in a month) Write a program that prompts the user to enter
the month and year and displays the number of days in the month. For example, if
the user entered month 2 and year 2012, the program should display that February
2012 has 29 days. If the user entered month 3 and year 2015, the program should
display that March 2015 has 31 days.
 */

import java.util.Scanner;

public class NumberOfDaysInMonth {
    public static void main(String[] args) {

        //Declaring variables
        int month, year;
        //Creating Scanner object for input
        Scanner scan = new Scanner(System.in);
        //Prompting user to enter values
        System.out.println("Enter the month number between 1-12:");

        month = scan.nextInt();

        System.out.println("Enter the year:");

        year = scan.nextInt();

        //Based on entered month, display results
        //Checking if it is a leap year or not for February
        switch (month) {
            case 1:
                System.out.println("January " + year +" has 31 days.");
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    System.out.println("February " + year +" has 29 days.");
                } else {
                    System.out.println("February " + year +" has 28 days.");
                }
                break;
            case 3:
                System.out.println("March " + year +" has 31 days.");
                break;
            case 4:
                System.out.println("April " + year +" has 30 days.");
                break;
            case 5:
                System.out.println("May " + year +" has 31 days.");
                break;
            case 6:
                System.out.println("June " + year +" has 30 days.");
                break;
            case 7:
                System.out.println("July " + year +" has 31 days.");
                break;
            case 8:
                System.out.println("August " + year +" has 31 days.");
                break;
            case 9:
                System.out.println("September " + year +" has 30 days.");
                break;
            case 10:
                System.out.println("October " + year +" has 31 days.");
                break;
            case 11:
                System.out.println("November " + year +" has 30 days.");
                break;
            case 12:
                System.out.println("December " + year +" has 31 days.");
                break;


        }



    }
}
