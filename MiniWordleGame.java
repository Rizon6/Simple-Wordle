// Rizon Takabe
// 6-10-2023
// CS 145
// Assignment 3
// This program chooses a random 5 letter word and the user tries to guess it
// Each guess gets a report if a letter is correct, or misplaced

import java.util.*;

public class MiniWordleGame {
    private static final String[] wordList = { // All the possible answers
        "apple", "aisle", "bread", "blend", "chair", "click", "dance", "drive", "earth", "elite", "flame", "fable",
        "ghost", "giant", "house", "happy", "image", "ivory", "jelly", "juice", "knees", "known", "light", "laser",
        "magic", "movie", "noise", "nylon", "oasis", "onion", "party", "piano", "quiet", "quilt", "round", "radar",
        "smart", "snake", "tiger", "toast", "unity", "urban", "vital", "voice", "water", "woman", "xenon", "xerox",
        "youth", "yield", "zebra", "zesty"
    };

    private static final int MAX_ATTEMPTS = 10;
    private static final int WORD_LENGTH = 5;

    public static void main(String[] args) {
        MiniWordleGame game = new MiniWordleGame();
        game.start();
    }

    private void start() {
        System.out.println("Welcome to Mini Wordle!");
        System.out.println("Try and guess the five letter word.");
        System.out.println("You have " + MAX_ATTEMPTS + " guesses.");

        Random random = new Random();
        String correctWord = wordList[random.nextInt(wordList.length)]; // Picks a random word from the wordList array

        Scanner scanner = new Scanner(System.in);

        int guesses = 0;
        while (guesses < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != WORD_LENGTH) { // Check if the guess has the correct length
                System.out.println("Invalid guess. Please enter a five letter word.");
                continue;
            }

            if (guess.equals(correctWord)) { // Check if the guess matches the correct word
                System.out.println("Good job, you guessed the word correctly!");
                break;
            }

            GuessResult result = checkGuess(guess, correctWord); // Compare the guess with the correct word
            printGuessResult(result);

            guesses++;
            int guessesLeft = MAX_ATTEMPTS - guesses;
            if (guessesLeft > 0) {
                System.out.println("Remaining guesses: " + guessesLeft);
            } else {
                System.out.println("Game over! You ran out of guesses.");
                System.out.println("The word was: " + correctWord);
            }
        }

        scanner.close();
    }
    // Checks the guess with the correct word and returns a GuessResult object
    // with the correct letters and misplaced letters
    private GuessResult checkGuess(String guess, String correctWord) { 
        List<Character> correctLetters = new ArrayList<>();
        List<Character> misplacedLetters = new ArrayList<>();

        for (int i = 0; i < WORD_LENGTH; i++) {
            char targetLetter = correctWord.charAt(i);
            char guessLetter = guess.charAt(i);

            if (guessLetter == targetLetter) {
                correctLetters.add(guessLetter); // Letter is correct
            } else if (correctWord.contains(String.valueOf(guessLetter))) { 
                misplacedLetters.add(guessLetter); // Letter's in wrong spot
            }
        }

        return new GuessResult(correctLetters, misplacedLetters); // Create a GuessResult object with the correct and misplaced letters
    }
    // Print the arrays of correct and misplaced letters
    private void printGuessResult(GuessResult result) {
        System.out.println("Correct letters in correct position: " + result.getCorrectLetters());
        System.out.println("Misplaced letters: " + result.getMisplacedLetters());
        System.out.println();
    }
}
