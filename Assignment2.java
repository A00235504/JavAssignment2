/*
-----------------Readme--------------------
Student Name- Aakash Sadnani

Student ID - A00235504

Program Description - This program is written to perform the following task:.
1) It will accept an integer value which is to be converted
2) Next we have to enter the unit we want to convert
3) Arithmatic calculations will determine the output
4) After calculations the output will be displayed to the user on the terminal console.
-----------------x------------------------
*/

import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner inputScannerValue = new Scanner(System.in);

        System.out.println("Enter search value");
        int searchnumber = inputScannerValue.nextInt();

        int[] myOrignalArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int[] myReverseArray = reverseArray(myOrignalArray);

        for (int i = 0; i < myReverseArray.length; i++) {
            System.out.println(myReverseArray[i]);

        }
        int averageValue = averageArray(myOrignalArray);

        System.out.println("The average value of Array is: " + averageValue);

        boolean search = arrayContains(myOrignalArray, searchnumber);

        System.out.println("The search is: " + search);
    }

    public static int[] reverseArray(int[] inputarray) {
        int reversingArray[] = new int[inputarray.length];
        int j = inputarray.length;
        for (int i = 0; i < inputarray.length; i++) {
            reversingArray[j - 1] = inputarray[i];
            j = j - 1;
        }
        return reversingArray;
    }

    public static int averageArray(int[] averagearray) {
        int result = 0;
        for (int i = 0; i < averagearray.length; i++) {
            result = result + averagearray[i];
        }
        return result;
    }

    public static boolean arrayContains(int[] arrayContaining, int searchnu) {
        boolean mybool = false;
        for (int i = 0; i < arrayContaining.length; i++) {
            if (searchnu == arrayContaining[i]) {
                mybool = true;
            } else {
                
            }

        }
        return mybool;
    }

}