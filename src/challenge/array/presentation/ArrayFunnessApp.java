package challenge.array.presentation;

import challenge.array.business.Console;

import java.util.Arrays;

public class ArrayFunnessApp {
    public static void main(String[] args) {
        // Title
        System.out.println("Welcome to the Array Funness App!\n");

        // Continue loop: y / n choice
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // Set Counter To: 0
            int counter = 0;

            System.out.println("Select three sets of random number with a range");
            // User select a range for 3 sets of number to be generated for the array
            System.out.println("Random number set: 1");
            int set1Min =  Console.getInt("Min: ");
            int set1Max =  Console.getInt("Max: ");

            System.out.println("Random number set: 2");
            int set2Min =  Console.getInt("Min: ");
            int set2Max =  Console.getInt("Max: ");

            System.out.println("Random number set: 3");
            int set3Min =  Console.getInt("Min: ");
            int set3Max =  Console.getInt("Max: ");

            // Ask for magic number for the loop to find
            int magicNumber = Console.getInt("Magic number: ");

            boolean isValid = false;
            while (!isValid) {
                // Generate Random Numbers
                int randomNumber1 = Console.randomNumberGenerated(set1Max, set1Min);
                int randomNumber2 = Console.randomNumberGenerated(set2Max, set2Min);
                int randomNumber3 = Console.randomNumberGenerated(set3Max, set3Min);

                // Placed Generated Number Into Array
                int[] originalArray = {randomNumber1, randomNumber2, randomNumber3};

                // Clone Original Array to Shift Later
                int[] clonedArray = originalArray.clone();

                // Calling rotateArray Method to Shift Number In Array
                Console.rotateArray(clonedArray);

                // Set integer variable to lock into first and last index for cloned array
                int firstNumberInArray = clonedArray[0];
                int lastNumberInArray = clonedArray[clonedArray.length - 1];

                // Print the array to the console
                System.out.println("Original array: " + Arrays.toString(originalArray));
                System.out.println("Left shift array: " + Arrays.toString(clonedArray));

                // Generic message to let user know that array is being check
                System.out.println("Checking shifted array for number " + magicNumber + " at index: 0 || 2");
                if (firstNumberInArray == magicNumber || lastNumberInArray == magicNumber) {
                    isValid = true; // Break out of loop if first or last index contains number: 6
                    counter++;
                    System.out.println("Match!"); // Let the user know a match have been found
                    System.out.println("It took " + counter + " attempts...dang!"); // Shows the user how many attempts it took to find a match
                } else {
                    // Rerun the loop if the match haven't been found
                    System.out.println("Array didn't contain any number " + magicNumber + " at index: 0 || 2");
                    System.out.println("Trying again...");
                    counter++;
                }
            }
            // Reset choice selection
            choice = Console.getString("Run again? ( Y / N): ", "y", "n");
            System.out.println(); // Blank Line
        }
        System.out.println("Exiting Application...");
    }
}