/*
 * Tofig Gasimov
 * Date: Fall 2020
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 2.21-Financial calculator: Calculate future investment value
 */

/*
 *
 * @author tofig
 */


/*

(Financial application: calculate future investment value) Write a program that
reads in investment amount, annual interest rate, and number of years and displays
the future investment value using the following formula:
futureInvestmentValue =
investmentAmount * (1 + monthlyInterestRate)
numberOfYears*12
 For example, if you enter amount 1000, annual interest rate 3.25%, and number
of years 1, the future investment value is 1032.98.

 */

import java.util.Scanner;
import java.lang.Math;

public class CalculatingFutureValue {
    public static void main(String[] args) {

        //Declaring variables
        double investAmount, annualInterestRate, futureValue, monthlyInterestRate;
        int numYears;

        //Creating Scanner object for input
        Scanner scan = new Scanner(System.in);

        //Prompting user to enter investment amount
        System.out.println("Enter investment amount: ");

        //Reading input value
        investAmount = scan.nextDouble();

        System.out.println("Enter annual interest rate in percentage: ");

        annualInterestRate = scan.nextDouble();

        System.out.println("Enter number of years: ");

        numYears = scan.nextInt();

        //Calculating future investment value
        monthlyInterestRate = (annualInterestRate / 12);
        futureValue = investAmount * Math.pow((1 + monthlyInterestRate / 100), numYears * 12);

        //Displaying results
        System.out.println("Future value is $" + String.format("%.2f", futureValue));


    }
}
