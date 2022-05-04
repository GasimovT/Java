/*
 * Tofig Gasimov
 * Date: Spring 2021
 *
 * CIS 331
 * My submission of this program indicates that I have neither received nor
given substantial or unauthorized assistance in writing this program.
*
   Assignment 4- Working with methods and cryptographic hashing
 */

/*
 *
 * @author tofig
 */

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class WorkingWithMethods {
    //Creating a constant maxIndex variable
    static final int maxIndex = 100;
    //Instantiating static array
    static String[] usersArray = new String[maxIndex];

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);
        //Looping continuously until option (7) is chosen to terminate the program
        while (true) {
            //Assigning returned menu choice to menuChoice variable
            int menuChoice = menu();

            switch (menuChoice) {
                //Testing password choice
                case 1:
                    //If returned value is true, display success
                    System.out.print("\nEnter password to test: ");
                    String password = scanner.nextLine();
                    if (isValidPassword(password)) {
                        System.out.println(password + " is a GOOD password\n");
                    } else if (!(isValidPassword(password))) {
                        System.out.println(password + " is a BAD password\n");
                        System.out.println("    • Length should be at least 8 characters\n" +
                                "    • Must include at least one upper case character\n" +
                                "    • Must include at least one lower case character\n" +
                                "    • Must include at least one numeric digit\n" +
                                "    • Must include at least one special character\n" +
                                "    • Cannot contain a space\n");
                    }
                    break;
                //Reading file choice
                case 2:
                    //If returned value does not equal to null,
                    // display success message and store values of returned array to usersArray
                    System.out.print("\nEnter file name (or full file path) to read: ");
                    String fileNameR = scanner.nextLine();
                    if (readUserFile(fileNameR) != null) {
                        System.out.println("\nUser file " + fileNameR + " has been read successfully!\n");
                        usersArray = readUserFile(fileNameR);
                    }
                    break;
                //Writing into file choice
                case 3:
                    System.out.print("Enter file name or (full file path) for write: ");
                    String fileNameW = scanner.nextLine();
                    if (writeUserFile(fileNameW, usersArray)) {
                        System.out.println("User file " + fileNameW + " has been successfully written\n");
                    } else if (!(writeUserFile(fileNameW, usersArray))) {
                        System.out.println();
                    }
                    break;
                //Listing users choice
                case 4:
                    //If returned value is empty string, display message
                    //Else list users
                    if ((listUsers(usersArray).equals(""))) {
                        System.out.println("\nFile has not been read yet, please read file!\n");
                    } else {
                        System.out.println("\nUser List: ");
                        System.out.println(listUsers(usersArray));
                    }
                    break;
                //Testing user login
                case 5:
                    //Users to test with after reading file (username password):
                    // xxx 1Password!
                    // abcd jmuDukes12!
                    System.out.print("Enter User ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String userPW = scanner.nextLine();

                    String checkLogin = userLogin(userID, userPW, usersArray);
                    switch (checkLogin) {
                        case "" -> System.out.println("\nFile has not been read yet, please read file!\n");
                        case "invalid" -> System.out.println("Username or password is invalid.\n");
                        case "loginSuccess" -> System.out.println("Login successful!\n");
                        case "userDoesNotExist" -> System.out.println("User " + userID + " does not exist.\n");
                    }
                    break;
                //Adding new user
                case 6:
                    System.out.print("Enter User ID: ");
                    String newUserID = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newUserPW = scanner.nextLine();
                    String addUser = addNewUser(newUserID, newUserPW, usersArray);
                    switch (addUser) {
                        case "" -> System.out.println("\nFile has not been read yet, please read file!\n");
                        case "userAdded" -> System.out.println("User " + newUserID + " has been successfully added.\n");
                        case "userExists" -> System.out.println("User " + newUserID + " already exists.\n");
                        case "badPassword" -> System.out.println(newUserPW +
                                " is a BAD password.\n" + "    • Length should be at least 8 characters\n" +
                                "    • Must include at least one upper case character\n" +
                                "    • Must include at least one lower case character\n" +
                                "    • Must include at least one numeric digit\n" +
                                "    • Must include at least one special character\n" +
                                "    • Cannot contain a space\n");
                    }
                    break;

                case 7:
                    System.out.println("\nGoodbye!");
                    System.exit(0);
            }

        }

    }

    //Methods start here


    //Method to loop menu repeatedly
    /*
    @return menu choice
     */
    static int menu() {
        String choice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Welcome to User Management System");
            System.out.print("\n\t1) Test a password\n" + "\t2) Read user file\n"
                    + "\t3) Write user file\n" + "\t4) List users\n" + "\t5) User Login\n" + "\t6) Add user\n" +
                    "\t7) Quit\n");
            System.out.print("Enter the number for your choice: ");
            choice = scanner.nextLine();
            if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") ||
                    choice.equals("5") || choice.equals("6") || choice.equals("7")) {
                break;
            } else {
                System.out.println("\nInvalid choice, please try again.\n");
            }
        }
        return Integer.parseInt(choice);
    }


    //Method to check validness of password

    /*
    • length is at least 8 characters
    • includes at least one upper case character
    • includes at least one lower case character
    • includes at least one numeric digit
    • includes at least one special character
    • cannot contain a space

    @parameter String password - password to be checked against "valid password" conditions
    @return Boolean depending on the condition(s) met
     */
    static boolean isValidPassword(String password) {
        //Declaring and initializing variables
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean numericDigit = false;
        boolean space = false;
        char ch;

        //Length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            //Includes at least one upper case
            if (Character.isUpperCase(ch)) {
                upperCase = true;
                //Includes at least one lower case
            } else if (Character.isLowerCase(ch)) {
                lowerCase = true;
                //Includes at least one numeric digit
            } else if (Character.isDigit(ch)) {
                numericDigit = true;
                //Does not contain space
            } else if (!(Character.isSpaceChar(ch))) {
                space = true;
            }
            //If all conditions are met, return true
            if (upperCase && lowerCase && numericDigit && space) {
                return true;
            }
        }
        return false;
    }

    //Method to read users.txt
    /*
    @parameter String fname - which is the file name or full path of the file to be read
    @return String[] array of file content that was read
    @return null if exception is thrown
     */
    static String[] readUserFile(String fname) {
        String[] dataArray = new String[maxIndex];
        try {
            //If file name does not contain .txt, concat .txt to passed file name
            if (!(fname.contains(".txt"))) {
                fname = fname + ".txt";
            }
            File file = new File(fname);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int count = 0;
            while ((st = br.readLine()) != null) {
                if (count < maxIndex) {
                    dataArray[count] = st;
                    count++;
                } else {
                    break;
                }
            }
            br.close();
            return dataArray;

        } catch (Throwable e) {
            if (e instanceof Exception) {
                System.out.println("\nException occurred: " + e.getMessage() + " . Please try again\n");
            }
            return null;
        }
    }

    //Method to list users
    /*
    @parameter String[] array - array contents to be listed
    @return String of array elements which are not null
     */
    static String listUsers(String[] userArray) {
        String str = "";
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                str = str + userArray[i] + "\n";
            } else {
                break;
            }
        }
        return str;
    }

    //Method to write values to the specified file
    /*
    @parameters String fname - specified file to write contents to,
                String[] userArray - contents to be written
    @return Boolean value
     */
    static boolean writeUserFile(String fname, String[] userArray) {
        try {
            if (!(fname.contains(".txt"))) {
                fname = fname + ".txt";
            }

            File file = new File(fname);
            //String absolutePath = file.getAbsolutePath();
            Path relativePath = Paths.get(fname);

            //Check to see if file already exists or not
            if (file.createNewFile()) {
                //If File does not exist, create file and write into it
                String str = "";
                for (int i = 0; i < userArray.length; i++) {
                    if (userArray[i] != null) {
                        str = str + userArray[i] + "\n";
                        //Create new file and write into it
                        Files.writeString(relativePath, str);
                    } else {
                        break;
                    }
                }

            } else {
                //If file already exists, append to the end of file
                String str = "";
                for (int i = 0; i < userArray.length; i++) {
                    if (userArray[i] != null) {
                        str = "" + userArray[i] + "\n";
                        Files.writeString(relativePath, str, StandardOpenOption.APPEND);
                    } else {
                        break;
                    }
                }
            }
            return true;

        } catch (Throwable e) {
            if (e instanceof Exception) {
                System.out.println("\nException occurred: " + e.getMessage() + " . Please try again\n");
            }
            return false;
        }
    }

    //Method to test user login
    /*
    @parameters String userID, String password, String[] userArray
    @return String based on the conditions met
     */

    static String userLogin(String uid, String pw, String[] userArray) throws NoSuchAlgorithmException {
        String userName;
        String userPassword;
        String hashedPassword;
        String str = "";
        boolean flag;
        //Crypto hashing passed password in order to compare it to array content
        hashedPassword = toHexString(getSHA(pw));

        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String[] parts = userArray[i].split(" ");
                userName = parts[0];
                userPassword = parts[1];

                if (userName.equals(uid)) {
                    if (!userPassword.equals(hashedPassword)) {
                        str = "invalid";
                    } else {
                        str = "loginSuccess";
                    }
                } else {
                    str = "userDoesNotExist";
                }

                flag = true;

                //This statement is always true in order to break out of loop
                if (flag) {
                    break;
                }

            } else {
                return "";
            }
        }
        return str;
    }

    //Method to add new user
    /*
    @parameters String userID, String password, String[] userArray
    @return String based on the conditions met
     */
    static String addNewUser(String uid, String pw, String[] userArray) throws NoSuchAlgorithmException {
        String userName;
        String hashedPassword = "";
        String str = "";
        boolean flag;
        //Keeping track/count of non-null values in the array
        int index = -1;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                index++;
            }
        }

        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String[] parts = userArray[i].split(" ");
                userName = parts[0];
                if (userName.equals(uid)) {
                    str = "userExists";
                } else {
                    if (!isValidPassword(pw)) {
                        str = "badPassword";
                    } else {
                        hashedPassword = toHexString(getSHA(pw));
                        String user = uid + " " + hashedPassword;
                        userArray[index++] = user;
                        str = "userAdded";

                    }
                }

                flag = true;

                //This statement is always true in order to break out of loop
                if (flag) {
                    break;
                }
            } else {
                return "";
            }
        }
        return str;
    }





    /*
    Converts the byte array to a string with hexadecimal notation
    @parameter byte[] hash
    @return String

    @Credits to GeeksForGeeks
     */
    static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }


    /*
    Takes string input, performs a hash algorithm on it, and produces a byte array of the hashed value
    @parameter String input
    @return byte[]

    @Credits to GeeksForGeeks
     */
    static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
}




