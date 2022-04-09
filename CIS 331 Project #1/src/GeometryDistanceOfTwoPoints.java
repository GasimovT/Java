/*
 * Tofig Gasimov
 * Date: Fall 2020
 *
 * CIS 331-Section-2
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 2.15-Geometry distance between two points
 */

/*
 *
 * @author tofig
 */

/*
(Geometry: distance of two points) Write a program that prompts the user to enter
two points (x1, y1) and (x2, y2) and displays their distance.
 */

import java.util.Scanner;
import java.lang.Math;

public class GeometryDistanceOfTwoPoints {
    public static void main(String[] args) {

        //Declaring variables
        double x1, y1, x2, y2, calcDistance;
        //Creating scanner object for input
        Scanner scan = new Scanner(System.in);

        //Prompting user to enter values
        System.out.println("Enter x1 and y1:");

        //Reading input values
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();

        System.out.println("Enter x2 and y2:");
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();

        //Calculating distance between two points
        calcDistance = Math.pow(Math.pow((x2-x1),2) + Math.pow((y2-y1),2) ,0.5);
        //Displaying results
        System.out.println("The distance between two points is " + calcDistance);


    }
}
