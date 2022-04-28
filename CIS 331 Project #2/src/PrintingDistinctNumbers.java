/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 7.5-Printing distinct numbers
 */

/*
 *
 * @author tofig
 */


/*
(Print distinct numbers) Write a program that reads in ten numbers and displays the number of distinct numbers and
the distinct numbers separated by exactly one space (i.e., if a number appears multiple times, it is displayed only
once)
Enter ten numbers: 1 2 3 2 1 6 3 4 5 2
The number of distinct number is 6
The distinct numbers are: 1 2 3 6 4 5
 */

import java.util.Scanner;

public class PrintingDistinctNumbers {
    public static void main(String[] args) {

        //Creating scanner object for input
        Scanner scanner = new Scanner(System.in);

        //Instantiating two arrays
        int[] array = new int[10];
        int[] distinctArray = new int[10];

        //Prompting user to enter numbers
        //Reading numbers into array
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        //Integer variable to increment array index
        int index = 0;

        // Looping through first array
        for (int i = 0; i < array.length; i++) {
            int flag = 0;
            //Innermost loop to make comparison between elements and skip duplicate elements
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    flag = 1;
                    break;
                }
            }
            //Store the element if it is not present in the distinctArray
            if (flag == 0) {
                distinctArray[index] = array[i];
                index++;    //increment index value
            }
        }

        //Displaying Results
        System.out.println("The number of distinct number is " + index);
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < index; i++) {
            System.out.print(distinctArray[i] + " ");
        }


    }
}


