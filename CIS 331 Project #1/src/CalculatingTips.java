/*
 * Tofig Gasimov
 * Date: Fall 2020
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 2.5-Financial Application: Calculating Tips
 */

/*
 *
 * @author tofig
 */

/*

(Financial application: calculate tips) Write a program that reads the subtotal
and the gratuity rate and then computes the gratuity and total. For example, if the
user enters 10 for subtotal and 12% for gratuity rate, the program displays $1.2
as gratuity and $11.2 as total.

 */

import java.util.Scanner;

public class CalculatingTips {
    public static void main(String[] args) {

        //Declaring variables
        double subTotal, gratRate, gratuity, total;
        //Creating scanner object for input
        Scanner scan = new Scanner(System.in);
        //Prompting user to enter values
        System.out.println("Enter the subtotal and a gratuity rate: ");

        //Reading input values
        subTotal = scan.nextDouble();
        gratRate = scan.nextDouble();

        //Calculating gratuity
        gratuity = subTotal * (gratRate / 100);
        //Calculating total
        total = gratuity + subTotal;

        //Displaying results
        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);

    }
}
