import java.util.ArrayList;

public class WordList {
    // WordList will have access to txt files containing words to guess
    // Only exception is Multiplayer
    // Each txt file will be named after each theme
    // txt files will be named Classic.txt, UnderTheSea.txt, and Halloween.txt

    //0-classic, 1-multiplayer, 2-under the sea, 3-halloween
    private int theme;
    String word;
    ArrayList<String> wordList;


    /**
     * This is the constructor the for the WordList class, which initializes theme, word, and wordList.
     */
    public WordList(){
        theme = -1;
        word = null;
        wordList = new ArrayList<String>();
    }

    /**
     * Updates wordList with words from a file corresponding to User's theme selection
     * @param t integer corresponding to the theme selection: 0-classic, 1-multiplayer, 2-under the sea, 3-halloween
     */
    public void setGameList(int t){
        //reads in file corresponding to theme
    }

    /**
     * Sets word equal to a random String from wordList
     */
    public void setRandomWord(){
        //sets word to a random word from the list
        int random = -1;
        int max = wordList.size() - 1;
        int min = 0;
        random = (int)(Math.random() * ((max - min) + 1)) + min; //this line is supposed to find a random number between 0 and the max index of wordList

        word = wordList.get(random);
    }

    /**
     * Returns the random word selected from gameList
     * @return String word - is the word that will be used for the game
     */
    public String getWord(){
        return word;
    }

    /**
     * Returns a list of underscores which will be used to display how many blank characters are left for User to find
     * @return ArrayList<Character> blanksList - A list of underscores: "_"
     */
    public ArrayList<Character> getBlanks(){
        ArrayList<Character> blanksList = new ArrayList<>();

        for (int i = 0; i < word.length(); i++){
            blanksList.add('_');
        }

        return blanksList;
    }




}
