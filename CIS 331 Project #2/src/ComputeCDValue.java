/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Exercise 5.31-Financial application: Compute CD value
 */

/*
 *
 * @author tofig
 */

/*
 (Financial application: compute CD value) Suppose you put $10,000 into a CD
with an annual percentage yield of 6.15%. After one month, the CD is worth
10000 + 10000 * 6.15 / 1200 = 10051.25
 After two months, the CD is worth
10051.25 + 10051.25 * 6.15 / 1200 = 10102.76
and so on.
Write a program that prompts the user to enter an amount (e.g., 10000), the annual
percentage yield (e.g., 6.15), and the number of months (e.g., 18)

 */

import java.util.Scanner;

public class ComputeCDValue {
    public static void main(String[] args) {
        //Creating Scanner object for input
        Scanner scanner = new Scanner(System.in);

        //Prompting user to enter values and reading those values

        System.out.println("Enter the initial deposit amount: ");
        double depositAm = scanner.nextInt();

        System.out.println("Enter annual percentage yield: ");
        double annualYield = scanner.nextDouble();

        System.out.println("Enter maturity period (number of months): ");
        int maturityMon = scanner.nextInt();

        //Calculating monthly yield %
        double monthlyYield = annualYield / 1200;

        //Displaying Results
        System.out.println(" ");
        System.out.println("Month\t" + "CD Value");
        for (int i = 1; i <= maturityMon; i++) {

            //Calculating CD Value for each month
            double cdValue = depositAm + (depositAm * monthlyYield);

            //Incrementing deposit amount for each month
            depositAm += (depositAm * monthlyYield);
            System.out.println(i + "\t\t" + String.format("%.2f", cdValue));
        }
    }
}
