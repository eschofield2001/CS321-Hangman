import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordList {
    // WordList will have access to txt files containing words to guess
    // Only exception is Multi-player
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
        String fileName;
        FileReader infile;

        //If the User selects a preset list, this if statement will run and add the words from the proper text file into the wordList
        if(t != 1){
            switch(t){
                case 0:
                    fileName = "Classic.txt";
                    break;
                case 2:
                    fileName = "UnderTheSea.txt";
                    break;
                case 3:
                    fileName = "Halloween.txt";
                    break;
                default:
                    fileName = null;
            }

            try{
                infile = new FileReader(fileName);
            }
            catch(FileNotFoundException ex){
                System.err.println("File could not be located.");
                return;
            }

            Scanner fileIn = new Scanner(infile);

            Scanner tokenScanner = null; //scanner to read in tokens from each line
            ArrayList<String> wordLine = new ArrayList<>();

            while(fileIn.hasNextLine()){
                tokenScanner = new Scanner(fileIn.nextLine());
                while(tokenScanner.hasNext()){
                    wordList.add(tokenScanner.next());
                }
            }

        }

        //If the User chooses Multi-player, this will run and have the User enter a word
        else{
            wordList.add(JOptionPane.showInputDialog(null, "Enter the word you want your opponent to guess!", "Multi-player", JOptionPane.QUESTION_MESSAGE));
        }

    }

    /**
     * Sets word equal to a random String from wordList
     */
    public void setRandomWord(){
        //sets word to a random word from the list
        Random r = new Random();
        word = wordList.get(r.nextInt(wordList.size()));
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
