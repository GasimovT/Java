/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.

   Exercise 5.41-Occurrence of max numbers
 */

/*
 *
 * @author tofig
 */

/*
Write a program that reads integers, finds the largest
of them, and counts its occurrences. Assume the input ends with number 0.
Suppose you entered 3 5 2 5 5 5 0; the program finds that the largest is 5 and the
occurrence count for 5 is 4.
 */

import java.util.Scanner;

public class MaxNumberOccurrence {
    public static void main(String[] args) {

        //Declaring and initializing variables
        int number;
        int max = 0;
        int count = 0;

        //Creating Scanner object for input
        Scanner scanner = new Scanner(System.in);

        //Prompting user to enter numbers
        System.out.println("Enter numbers: ");

        //While input does not equal to 0
        while ((number = scanner.nextInt()) != 0) {

            //If input is larger than max variable
            if (number > max) {

                //Assign input to max
                max = number;

                //Assign 1 to count
                count = 1;

                //If input is equal to max
                //Increment count variable by one
            } else if (number == max) {
                count++;
            }

        }

        //Displaying Results
        System.out.println("The largest number is " + max);
        System.out.println("The occurrence count of the largest number is " + count);


    }
}
