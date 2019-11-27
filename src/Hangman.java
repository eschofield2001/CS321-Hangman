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
        gWord = "";
    }

    /**
     * Initializes the attributes af a Hangman using the information of a WordList.
     */
    public void initializeHangman(WordList w ) {
        gWord = w.getWord();
        numLimbs = 0;
        blanks = w.getBlanks();
        boxLetters.clear();
    }

    /**
     * Initializes the attributes of the Hangman used during the starting screen of the game.
     */
    public void initializeHangmanStart() {
        gWord = "HangmanStart";
        numLimbs = 0;
        boxLetters.clear();
        blanks.clear();
        for(int i = 0; i < gWord.length(); i++){
            blanks.add('_');
        }
        updateBlanks('H');
        updateBlanks('A');
        updateBlanks('N');
        updateBlanks('G');
        updateBlanks('M');

    }

    /**
     * Updates blanks with Character c that correspond to gWord.
     * @param c Character used to update blanks.
     */
    public void updateBlanks(Character c) {
        for(int i = 0; i < gWord.length(); i++) {
            if(Character.toUpperCase(c) == Character.toUpperCase(gWord.charAt(i)))
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
     * Adds Character c to boxLetters.
     * @param c Character to be added to boxLetters.
     */
    public void updateBox(Character c) {
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
     * @param c char that is used to check gWord.
     * @return true if char c is found anywhere in gWord or false otherwise.
     */
    public boolean isLetterPresent(Character c) {
        for(int i = 0; i < gWord.length(); i++) {
            if(Character.toUpperCase(c) == Character.toUpperCase(gWord.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean inBoxLetters(Character c) {
        for(int i = 0; i < boxLetters.size(); i++) {
            if(Character.toUpperCase(c) == Character.toUpperCase(boxLetters.get(i)))
                return true;
        }
        return false;
    }

    //For Testing********************************************************************************
    /**
     * Returns numLimbs, to be used for testing
     * @return numLimbs, the number of limbs on the hangman
     */
    public int getNumLimbs(){
        return numLimbs;
    }

    /**
     * Returns blanks, to be used for testing
     * @return blanks, ArrayList of Characters correctly guessed
     */
    public ArrayList<Character> getBlanks(){
        return blanks;
    }

    /**
     * Returns gWord, to be used for testing
     * @return gWord, current String being used in the game
     */
    public String getgWord(){
        return gWord;
    }

    /**
     * Returns boxLetters, to be used for testing
     * @return boxLetters, ArrayList of Characters incorrectly guessed
     */
    public ArrayList<Character> getBoxLetters(){
        return boxLetters;
    }

}
