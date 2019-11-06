import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class WordList {
    // WordList will have access to txt files containing words to guess
    // Only exception is Multiplayer
    // Each txt file will be named after each theme
    // txt files will be named Classic.txt, UnderTheSea.txt, and Halloween.txt

    private int chosenTheme;
    private String word;
    private ArrayList<String> playerList = new ArrayList<>();
    private ArrayList<String> oceanList = new ArrayList<>();
    private ArrayList<String> halloweenList = new ArrayList<>();
    private ArrayList<String> normalList = new ArrayList<>();

    public void setGameList(int theme) throws FileNotFoundException {
        chosenTheme = theme;
        if(theme == 0) {
            FileReader classicFile = new FileReader("Classic.txt");  //open Classic.txt
            Scanner inClassic = new Scanner(classicFile);
            while(inClassic.hasNextLine()) {
                String classicLine = inClassic.nextLine();                      //each line represents a word
                normalList.add(classicLine);                                    //add words individually to normalList
            }
        }
        else if(theme == 1) {
            Scanner inMulti = new Scanner(System.in);
            /*
                Display option to input 4 words - through GameGUI
                Receive words from GameGUI and add to playerList
             */
        }
        else if(theme == 2) {
            FileReader oceanFile = new FileReader("UnderTheSea.txt");   //open UnderTheSea.txt
            Scanner inOcean = new Scanner(oceanFile);
            while(inOcean.hasNextLine()) {
                String oceanLine = inOcean.nextLine();                           //each line represents a word
                oceanList.add(oceanLine);                                        //add words individually to oceanList
            }
        }
        else if(theme == 3) {
            FileReader halloweenFile = new FileReader("Halloween.txt"); //open Halloween.txt
            Scanner inHalloween = new Scanner(halloweenFile);
            while(inHalloween.hasNextLine()) {
                String halloweenLine = inHalloween.nextLine();               //each line will represent a word
                halloweenList.add(halloweenLine);                            //add words individually to halloweenList
            }
        }
    }

    public String getRandomWord() {
        Random generator = new Random();
        int index = 0;
        if(chosenTheme == 0) {                              // if theme is Classic
            for(int i = 0; i < normalList.size(); i++)
                index = generator.nextInt();                // generate random index num in normalList
            word = normalList.get(index);                   // word returned will be random word in normalList
        }
        if(chosenTheme == 1) {                              // if theme is Multiplayer
            for(int i = 0; i < playerList.size(); i++)
                index = generator.nextInt();                //generate random index num in playerList
            word = playerList.get(index);                   // word returned will be random word in playerList
        }
        if(chosenTheme == 2) {                              // if theme is Under The Sea
            for(int i = 0; i < oceanList.size(); i++)
                index = generator.nextInt();                // generate random index num in oceanList
            word = oceanList.get(index);                    // word returned will be random word in oceanList
        }
        if(chosenTheme == 3) {                              // if theme is Halloween
            for(int i = 0; i < halloweenList.size(); i++)
                index = generator.nextInt();                // generate random index num in halloweenList
            word = halloweenList.get(index);                //word returned will be random word in halloweenList
        }

        return word;
    }

    public ArrayList<String> getBlanks() {
        ArrayList<String> blanks = new ArrayList<String>();
        for(int i = 0; i < word.length(); i++) {
            String c = word.substring(i, i+1);
            blanks.add(c);
        }
        return blanks;
    }
}
