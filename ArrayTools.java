/*
-----------------Readme--------------------
Student Name- Aakash Sadnani

Student ID - A00235504

Program Description - This program is written to perform the following task:.
1) Encrypt a string and then prints the encrypted string
2) Finding the average of array
3) Checking if array contains a particular value
4) Reversing the input array of integer values

Menu created for selection
1 - For selecting the Encrypt option
2- For array average, searching array, reversing array

-----------------x------------------------
*/

import java.util.Scanner;

public class ArrayTools {
    public static void main(String[] args) {
        // Defining a scanner for taking inputs from user
        Scanner inputScannerValue = new Scanner(System.in);

        // Printing Menu Options
        System.out.println("Enter the operation number you want to do: ");
        System.out.println("Encrypt a String - 1");
        System.out.println("Average of Array, Searchh in Array and Reverse Array - 2");

        // Taking user input of menu selection
        int operationIndex = inputScannerValue.nextInt();
        inputScannerValue.nextLine();

        // Creating menu using switch statement
        switch (operationIndex) {
            // Case 1 define: Encrypt string
            case 1:
                // initializing variable
                String inputString = "";
                System.out.println("Enter a string to encrypt: ");
                // saving user input to the variable
                inputString = inputScannerValue.nextLine();

                System.out.println("Enter a value to encrypt with: ");

                // taking user input for the value/amount of shift in encryption
                int shiftingvalue = inputScannerValue.nextInt();
                inputScannerValue.nextLine();

                // calling and saving the return value of encryptfunction
                String encryptedText = encryptFunction(inputString, shiftingvalue);

                System.out.println("The encrypted string is: " + encryptedText);

                System.out.println("Decrypting " + encryptedText + " with " + shiftingvalue + "\n" + inputString);

                break;

            // Case 2 define: Array operations like average, search and reverse
            case 2:
                // initializing variable
                String reverseArrayString = "";
                String arrayCreated = "";
                int lengthofarray;
                System.out.println("Enter the length of number of items in the array : ");

                // saving the user input to the variable
                lengthofarray = inputScannerValue.nextInt();
                inputScannerValue.nextLine();

                // defining an array for saving the user array inputs and
                // giving array length same as the array size by the user
                int[] orignalArray = new int[lengthofarray];

                // getting array data from user and saving in array
                for (int i = 0; i < lengthofarray; i++) {
                    System.out.println("Enter the data of item in integer " + (i + 1) + " in the array");

                    orignalArray[i] = inputScannerValue.nextInt();
                    inputScannerValue.nextLine();
                    arrayCreated = arrayCreated + " " + orignalArray[i];
                }

                System.out.println("The array created is : [" + arrayCreated + "]");

                System.out.println("Enter search value");

                // taking the user input of searching the element in array
                int searchnumber = inputScannerValue.nextInt();
                inputScannerValue.nextLine();

                // calling the search function and returning boolean value
                boolean search = arrayContains(orignalArray, searchnumber);

                System.out.println("The search is: " + search);

                // comparing the return value if true/false then printing appropriate statements
                if (search == true) {
                    System.out.println("The array contains: " + searchnumber);
                } else {
                    System.out.println("The array doesn't contain: " + searchnumber);
                }

                // calling and saving the reverse array method in an array
                int[] reverseArray = reverseArray(orignalArray);

                // saving the reverse array to a string
                for (int i = 0; i < reverseArray.length; i++) {
                    reverseArrayString = reverseArrayString + " " + reverseArray[i];
                }

                System.out.println("The Reverse of Testing array is :" + reverseArrayString);

                // calling and saving the average array in a integer variable
                int averageValue = averageArray(orignalArray);

                System.out.println("The average value of Array is: " + averageValue);
                break;

            default:
                // default case if error in menu selection
                System.out.println("Error in selection! Select between 1 and 2 options! ");
                break;

        }

    }

    // method for encrypting text
    public static String encryptFunction(String unencryptedText, int encryptionIndex) {
        char unencryptedCharacter;
        String encryptedText = "";
        for (int i = 0; i < unencryptedText.length(); i++) {

            // Shift one character at a time
            unencryptedCharacter = unencryptedText.charAt(i);

            // if alphabet lies between a and z
            if (unencryptedCharacter >= 'a' && unencryptedCharacter <= 'z') {

                // shifting the alphabet
                unencryptedCharacter = (char) (unencryptedCharacter + encryptionIndex);

                // if shift alphabet greater than 'z'
                if (unencryptedCharacter > 'z') {

                    // reshift to starting position
                    unencryptedCharacter = (char) (unencryptedCharacter + 'a' - 'z' - 1);
                }

                encryptedText = encryptedText + unencryptedCharacter;
            }

            // if alphabet lies between 'A'and 'Z'
            else if (unencryptedCharacter >= 'A' && unencryptedCharacter <= 'Z') {

                // shift alphabet
                unencryptedCharacter = (char) (unencryptedCharacter + encryptionIndex);

                // if shift alphabet greater than 'Z'
                if (unencryptedCharacter > 'Z') {

                    // reshift to starting position
                    unencryptedCharacter = (char) (unencryptedCharacter + 'A' - 'Z' - 1);
                }

                encryptedText = encryptedText + unencryptedCharacter;
            } else {
                encryptedText = encryptedText + unencryptedCharacter;
            }

        }
        return encryptedText;
    }

    // method for reversing array and it takes one parameter - arrayInput only
    public static int[] reverseArray(int[] inputArray) {
        // new reverse array with length of inputarray
        int reversingArray[] = new int[inputArray.length];
        int j = inputArray.length;

        // one by one saving the input array with reverse array indexes which move from
        // last index to first
        for (int i = 0; i < inputArray.length; i++) {
            reversingArray[j - 1] = inputArray[i];
            j = j - 1;
        }
        return reversingArray;
    }

    // method for average array and it takes one parameter - arrayInput only
    public static int averageArray(int[] inputArray) {
        int resultAnswer = 0;

        // one by one adding the inputarray values to answer
        for (int i = 0; i < inputArray.length; i++) {
            resultAnswer = (resultAnswer + inputArray[i]) / inputArray.length;
        }
        return resultAnswer;
    }

    // method for searching array and it takes two parameter - arrayInput and search
    // item
    public static boolean arrayContains(int[] inputArray, int searchItem) {
        boolean mybool = false;
        // looping the array to find the item
        for (int i = 0; i < inputArray.length; i++) {
            // comparing the search item with input value
            if (searchItem == inputArray[i]) {
                mybool = true;
            } else {
                mybool = false;
            }
        }
        return mybool;
    }

}