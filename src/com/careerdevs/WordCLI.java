package com.careerdevs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WordCLI {
    private static Scanner scanner = new Scanner(System.in);


    public  static  int readInt (String question, int min, int max) {
        while (true) {
            try {
                System.out.println(question);
                System.out.println("Number (" + min + " - " + max + "): ");
                int userInt = scanner.nextInt();// checking for type : exception risk

                if (userInt >= min && userInt <= max) { //checking for valid range
                    return userInt;
                }

                //these lines will not run if a valid input is given
                System.out.println("Number must be un the range (" + min + " - " + max + ")");



            }catch (InputMismatchException e) {
                System.out.println("You Must enter a whole number, try again...");
                scanner.nextLine();}catch (Exception e) {
                System.out.println("An error unknown occurred");
                System.out.println(e + "\n" + e.getMessage());
                return 0;
            }

        }
        }
    }