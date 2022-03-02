package com.careerdevs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Word Play Game");
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1 play game");
        System.out.println("2 display rules");
        System.out.println("3 exit");

        int userSelection = WordCLI.readInt("Select a menu option", 1, 3);

        switch (userSelection) {
            case 1:
                //play game
                playGame();
                mainMenu();
                break;
            case 2:
                //displayRules
                displayRules();
                mainMenu();
                break;
            case 3:
                System.out.println( "\n\nThank you for using this game..." );
        }
    }

    private static void playGame() {
        System.out.println("Starting Game");

        String lettersNotUsed = "abcdefghijklmnopqrstuvwxyz";
       // the list of characters we've guessed

        String[] words = new String[] { "guessing", "these","words","is","very"};

        String  arrayWords = words [ (int) (Math.random() * words.length)];
        //Int gives value a whole number
        //math.random gives a number 0-
        //.length gives of array
        System.out.println("The word has " + arrayWords.length() + " letters. ");

        char[] letters = new char[arrayWords.length()];
        // char letter is where the user guessing are being stored


        for (int i = 0; i < letters.length; i++) {
            letters[i] = '.';

        }

        int lives = 3;

        Scanner scanner = new Scanner(System.in);

        while (lives > 0 ) {
            System.out.print("Lives: ");

            for (int i = 0; i < lives; i++){
                System.out.print("O");
            }
            System.out.println();

            System.out.println("Input: ");

            String input = scanner.nextLine();

            char letter = input.charAt(0);


            boolean isGuessedCorrect =  false;

            for (int i = 0; i < arrayWords.length(); i++)   {
                char l = arrayWords.charAt(i);

                if (l == letter){
                    letters[i] = l;
                    isGuessedCorrect = true;
                }
                // forloop seeing if any of the user guess adds up to random word length

            }
            if (!isGuessedCorrect) {
                lives = lives - 1;
                //this if statement is stating if guess is wrong  take away a life (lives = lives - 1)
            }

            boolean isGameFinished = true;
            //boolean isGameFinished will end game

            System.out.print("word: ");

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == '.') {
                    isGameFinished = false;
                    //print each letter
                    //if any '.' are left game is not finished
                }
                System.out.print(letters[i]);
                //prints out correct guesses
            }

            System.out.println();

            lettersNotUsed = lettersNotUsed.replace(letter, '.');

            System.out.println("Not used: " + lettersNotUsed);


            System.out.println("---------");
            if (isGameFinished) {
                System.out.println("You Won!");
                break;
                //if finished print you won
            }
        }
        if (lives == 0 ){
            System.out.println("You lost! The word was: " + arrayWords);
            // if no more lives print you lost and Word
        }
        System.out.println("Exiting Game" );
    }


    private static void displayRules() {
        System.out.println("\nRULES\n-----------\n");
        System.out.println("\nPlease Guess Only One Letter At A Time");
        System.out.println("\nEach Round You Only Get 3 guesses :xxx AND YOU LOSE" + "!!!!");
        System.out.println( "\nHave Fun And Don't Try To Hard" );

    }
}


/*
* create a main menu
// main menu: play, rules, exit // show to user
// switch statement (userSelection) //give the user options
// play: lives lost, letters,words,win or lose,//show to the user
// ArrayList<String> words; //a list of words to pick from
// char[] arrayWords; //the target word we're trying to guess
// char[] letters; //the word we've guessed so far (starts out as underscores!)
// ArrayList<Character> alreadyGuessed; //the list of characters we've guessed
// int totalLives = 5; //total number of lives per game; set in the fields so that it's always the same
// int lives; //current lives
// Random gen = new Random(); //a random generator for generating random numbers
*
* rules: display rules and Exit to main menu
*
* exit: end game when you or lose display message
*
*/