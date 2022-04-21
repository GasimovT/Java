/*
 * Tofig Gasimov
 * Date: Fall 2020
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 7.1-Assigning grades
 */

/*
 *
 * @author tofig
 */


/*
(Assign grades) Write a program that reads student scores, gets the best score, and
then assigns grades based on the following scheme:
Grade is A if score is >= best -5
Grade is B if score is >= best -10;
Grade is C if score is >= best -15;
Grade is D if score is >= best -20;
Grade is F otherwise.
The program prompts the user to enter the total number of students, and then
prompts the user to enter all of the scores, and concludes by displaying the grades.


 */

import java.util.Scanner;

public class AssigningGrades {
    public static void main(String[] args) {

        //Creating scanner object for input
        Scanner scanner = new Scanner(System.in);

        //Prompting user to enter the number(the number of total elements) of students
        System.out.print("Enter the number of students: ");
        int index = scanner.nextInt();

        //Instantiating an array
        int[] array = new int[index];

        //Prompting user to enter scores
        System.out.print("Enter " + index + " scores: ");

        //Declaring and initializing best variable
        int best = 0;

        //Inputting scores into array until 0 entered
        //Assigning the best score to best variable
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

            if (array[i] == 0) {
                break;
            }

            if (array[i] > best) {
                best = array[i];
            }
        }

        //Looping through array to assign and display grades
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= best - 5) {
                System.out.println("Student " + i + " score is " + array[i] + " and grade is A");
            } else if (array[i] >= best - 10) {
                System.out.println("Student " + i + " score is " + array[i] + " and grade is B");

            } else if (array[i] >= best - 15) {
                System.out.println("Student " + i + " score is " + array[i] + " and grade is C");

            } else if (array[i] >= best - 20) {
                System.out.println("Student " + i + " score is " + array[i] + " and grade is D");

            } else {
                System.out.println("Student " + i + " score is " + array[i] + " and grade is F");

            }
        }


    }

}

