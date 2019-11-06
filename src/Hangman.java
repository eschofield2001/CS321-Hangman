import java.util.ArrayList;

/**
 * This class acts as a model that contains the information for a game of hangman.
 */
public class Hangman {

    private int numLimbs;
    private ArrayList<Character> boxLetters;
    private ArrayList<Character> blanks;
    private String gWord;

    /**
     * Constructs a Hangman object with default values.
     */
    public Hangman() {
        numLimbs = 0;
        boxLetters = new ArrayList<>();
        blanks = new ArrayList<>();
        gWord = null;
    }

    /**
     * Initializes the attributes af a Hangman using the information of a WordList.
     */
    public void initializeHangman(/*WordList w */) {
        /*
        gWord = w.getWord();
        numLimbs = 0;
        blanks = w.getBlanks();
         */
    }

    /**
     * Initializes the attributes of the Hangman used during the starting screen of the game.
     */
    public void initializeHangmanStart() {
        gWord = "HangmanStart";
        numLimbs = 0;
        blanks.add('H');
        blanks.add('A');
        blanks.add('N');
        blanks.add('G');
        for(int i = 1; i <= 8; i++)
            blanks.add('_');
    }

    /**
     * Updates blanks with char c that correspond to gWord.
     * @param c char used to update blanks.
     */
    public void updateBlanks(char c) {
        for(int i = 0; i < gWord.length(); i++) {
            if(c == gWord.charAt(i))
                blanks.set(i, c);
        }
    }

    /**
     * Increases numLimbs by 1.
     */
    public void updateLimbs() {
        numLimbs++;
    }

    /**
     * Adds char c to boxLetters.
     * @param c char to be added to boxLetters.
     */
    public void updateBox(char c) {
        boxLetters.add(c);
    }

    /**
     * Checks if blanks is has any '_' still in it.
     * @return false if any '_' are found in blank or true otherwise.
     */
    public boolean isBlanksFull() {
        for(int i = 0; i < blanks.size(); i++) {
            if(blanks.get(i).equals('_'))
                return false;
        }
        return true;
    }

    /**
     * Checks if the hangman is complete using numLimbs.
     * @return true if numLimbs is six ore greater or false otherwise.
     */
    public boolean isHangmanComplete() {
        if(numLimbs >= 6)
            return true;
        return false;
    }

    /**
     * Checks if char c is present anywhere in gWord.
     * @param c char that is used to check gWOrd.
     * @return true if char c is found anywhere in gWord or false otherwise.
     */
    public boolean isLetterPresent(char c) {
        for(int i = 0; i < gWord.length(); i++) {
            if(c == gWord.charAt(i))
                return true;
        }
        return false;
    }

}
