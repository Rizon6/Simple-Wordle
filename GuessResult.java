import java.util.List;

// Stores the correct letters in correct position and the misplaced letters from guesses
public class GuessResult {
    private List<Character> correctLetters;
    private List<Character> misplacedLetters;

    // Constructor for correct letters and misplaced letters object
    public GuessResult(List<Character> correctLetters, List<Character> misplacedLetters) {
        this.correctLetters = correctLetters;
        this.misplacedLetters = misplacedLetters;
    }

    public List<Character> getCorrectLetters() {
        return correctLetters;
    }

    public List<Character> getMisplacedLetters() {
        return misplacedLetters;
    }
}