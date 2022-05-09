/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Assignment 3- Arrays and Text File O/I
 */

/*
 *
 * @author tofig
 */

/*
For this assignment, you will write a program that reads student course and grade data from a text file, and
then calculates GPAs and other information based on this file. The text file will contain one line of text for
each student. Each line consists of the following data (delimited by tabs):
1) student
2) for each class the student takes, there are two values:
    a. the number of credits in the class
    b. the grade for the class (A, B, C, D, or F)
 */


import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class StudentGradeSummary {
    public static void main(String[] args) {
        Scanner file = new Scanner(System.in);

        //Prompting user to enter the file path
        //Input: grades.txt
        System.out.print("Enter full path of input file: ");
        String filePath = file.nextLine();

        //Instantiating lists
        ArrayList<String> students = new ArrayList<>();
        ArrayList<Integer> classes = new ArrayList<>();
        ArrayList<Integer> credits = new ArrayList<>();
        ArrayList<Double> gpa = new ArrayList<>();

        //NumberFormat
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);

        //Open file
        try {
            Scanner scanner = new Scanner(Paths.get(filePath));
            //Checking to see if there is another line in the file
            while (scanner.hasNextLine()) {
                //Assigning each line to variable row
                String row = scanner.nextLine();
                //Splitting each line by space
                String[] line = row.split(" ");
                //Adding elements at index 0 to students list
                students.add(line[0]);
                int classCount = 0;
                int creditSum = 0;
                //Adding total #of classes into classes list and total #of credits into credits list
                for (int i = 1; i < line.length; i += 2) {
                    classCount++;
                    creditSum += Integer.parseInt(line[i]);
                }
                classes.add(classCount);
                credits.add(creditSum);

                //Declaring and initializing grades
                int gradeA = 0;
                int gradeB = 0;
                int gradeC = 0;
                int gradeD = 0;
                int gradeF = 0;
                //Assigning values according to grade letter A(4),B(3),C(2),D(1),F(0)
                for (String s : line) {
                    switch (s) {
                        case "A" -> gradeA += 4;
                        case "B" -> gradeB += 3;
                        case "C" -> gradeC += 2;
                        case "D" -> gradeD += 1;
                        case "F" -> gradeF += 0;
                    }
                }
                //Calculating each student's GPA and adding them into gpa list
                if (classCount > 0) {
                    double gpaCalc = (1.0 * (gradeA + gradeB + gradeC + gradeD + gradeF) / classCount);
                    gpa.add(Double.parseDouble(format.format(gpaCalc)));
                }

            }
            //Displaying student grade summary table
            System.out.println();
            System.out.println("Students\t\t" + "#Class\t" + "#Cred\t" + "GPA");
            System.out.println("--------\t\t" + "------\t" + "------\t" + "----");
            if (students.size() > 0) {
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(students.get(i) + "\t\t" + " " +
                            classes.get(i) + "\t\t" + " " + credits.get(i) + "\t\t" + format.format(gpa.get(i)));
                }
            }
            //Finding index and value of the top student
            int indexOfTopStudent = 0;
            double topStudentGpa = 0;
            for (int i = 0; i < gpa.size(); i++) {
                if (gpa.get(i) > topStudentGpa) {
                    topStudentGpa = gpa.get(i);
                    indexOfTopStudent = i;
                }
            }

            //Displaying top student and gpa
            System.out.println();
            System.out.println("The top student is " + students.get(indexOfTopStudent) +
                    " with GPA " + format.format(topStudentGpa));

            //Calculating and displaying average of all GPAs
            int gpaCount = 0;
            double gpaSum = 0;
            for (Double i : gpa) {
                gpaSum += i;
                gpaCount++;
            }
            double averageOfAllGpa = 0;
            if (gpaCount > 0) {
                averageOfAllGpa = gpaSum / gpaCount;
                System.out.println();
                System.out.println("The average of all GPAs is " + format.format(averageOfAllGpa));
                System.out.println();
            }
            //Displaying students (and their GPAs) whose GPAs are higher than average of all GPAs
            System.out.println("Students with higher than average GPA:");
            for (int i = 0; i < gpa.size(); i++) {
                if (gpa.get(i) > averageOfAllGpa) {
                    System.out.println(students.get(i) + "\t\t" + format.format(gpa.get(i)));
                }
            }

        } catch (Throwable e) {
            if (e instanceof Exception) {
                System.out.println("Exception occurred: " + e.getMessage() + " . Please try again");
                if (e instanceof IOException) {
                    System.out.println("Error reading file " + e.getMessage());
                }
            }
        }
    }
}
