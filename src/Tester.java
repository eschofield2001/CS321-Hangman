import java.util.ArrayList;

/**
 * The purpose of this class is to test Hangman, WordList, ThemeSelectionGUI, and ExitMenu
 */
public class Tester {
    /**
     * The purpose of this method is to test the ExitMenu class
     */
    public void testExitMenu(){
        ExitMenu exit = new ExitMenu();

        //Test presentExitMenu and getExitChoice x4
        exit.presentExitMenu();
        int t1 = exit.getExitChoice();
        exit.presentExitMenu();
        int t2 = exit.getExitChoice();
        exit.presentExitMenu();
        int t3 = exit.getExitChoice();
        exit.presentExitMenu();
        int t4 = exit.getExitChoice();

        if(t1 == 0 && t2 == 1 && t3 == 2 && t4 == 3){
            System.out.println("presentExitMenu() and getExitChoice() work");
        }
        else{
            System.out.println("There is an issue with presentExitMenu() and getExitChoice()");
        }

        exit.presentExitMenuWin();
        t1 = exit.getExitChoice();
        exit.presentExitMenuWin();
        t2 = exit.getExitChoice();
        exit.presentExitMenuWin();
        t3 = exit.getExitChoice();
        if(t1 == 0 && t2 == 2 && t3 ==3){
            System.out.println("presentExitMenuWin() works");
        }
        else{
            System.out.println("There is an issue with presentExitMenuWin()");
        }

        exit.presentExitMenuLose();
        t1 = exit.getExitChoice();
        exit.presentExitMenuLose();
        t2 = exit.getExitChoice();
        exit.presentExitMenuLose();
        t3 = exit.getExitChoice();
        if(t1 == 0 && t2 == 2 && t3 ==3){
            System.out.println("presentExitMenuLose() works");
        }
        else{
            System.out.println("There is an issue with presentExitMenuLose()");
        }

    }

    /**
     * The purpose of this method is to test the ThemeSelectionGUI class
     */
    public void testThemeSelectionGUI(){
        //This piece of code isn't fully automated, requires user to enter classic, multiplayer, under the sea, and halloween in that order for it to be accurate
        ThemeSelectionGUI themeMenu = new ThemeSelectionGUI();

        //Test displayThemeMenu and getThemeChoice x4
        themeMenu.displayThemeMenu();
        int t1 = themeMenu.getThemeChoice();
        themeMenu.displayThemeMenu();
        int t2 = themeMenu.getThemeChoice();
        themeMenu.displayThemeMenu();
        int t3 = themeMenu.getThemeChoice();
        themeMenu.displayThemeMenu();
        int t4 = themeMenu.getThemeChoice();
        if(t1 == 0 && t2 == 1 && t3 == 2 && t4 == 3){
            System.out.println("ThemeSelectionGUI works");
        }
        else{
            System.out.println("There is an issue with ThemeSelectionGUI");
        }

    }

    /**
     * The purpose of this method is to test the WordList class
     */
    public void testWordList(){
        WordList w = new WordList();
        ArrayList<String> testList;

        //Test setGameList
        w.setGameList(0); //uses Classic.txt for testing
        testList = w.getWordList();
        for(String word : testList){
            System.out.println(word); //should print all of the words in Classic.txt
        }

        //Test setRandomWord and getWord
        w.setRandomWord();
        System.out.println("The word of the game is:" + w.getWord());
        testList = w.getWordList();
        for(String word : testList){
            System.out.println(word); //should print all of the words but one in Classic.txt
        }

        //Test getBlanks
        if((w.getBlanks()).size() == (w.getWord()).length()){
            System.out.println("getBlanks() works");
        }
        else{
            System.out.println("There is a problem with getBlanks()");
        }

    }

    /**
     * The purpose of this method is to test the Hangman class
     */
    public void testHangman(){
        WordList w = new WordList("Test");
        Hangman h = new Hangman();
        h.initializeHangman(w);
        ArrayList<Character> testerBlanks;
        ArrayList<Character> testerBox;

        //Test initializeHangman()
        System.out.println("Testing initializeHangman():");
        System.out.println("numLimbs = " + h.getNumLimbs()); //should be 0
        testerBlanks = h.getBlanks();
        System.out.println("The blanks currently filled in:"); //none should be
        for (Character testerBlank : testerBlanks) {
            System.out.println(testerBlank);
        }
        System.out.println("gWord = " + h.getgWord()); //should be "tester"

        //Test isLetterPresent()
        if(h.isLetterPresent('t') && !h.isLetterPresent('z')){
            System.out.println("isLetterPresent works");
        }
        else{
            System.out.println("There is a problem with isLetterPresent");
        }

        testerBlanks = h.getBlanks();

        //Test updateBlanks()
        h.updateBlanks('t');
        for (Character testerBlank : testerBlanks) {
            System.out.println(testerBlank); //should print with two ts
        }

        //Test updateBox(), updateLimbs()
        h.updateLimbs();
        h.updateBox('z');
        System.out.println("numLimbs = " + h.getNumLimbs());
        testerBox = h.getBoxLetters();
        for(Character c : testerBox){
            System.out.println(c); //should print out z
        }

        //Test isBlanksFull() and isHangmanComplete()
        if(!h.isBlanksFull() && !h.isHangmanComplete()){
            h.updateBlanks('e');
            h.updateBlanks('s');
            if(h.isBlanksFull()){
                System.out.println("isBlanksFull() works");
            }
            else{
                System.out.println("There is a problem with isBlanksFull()");
            }
            h.initializeHangman(new WordList("To"));
            h.updateLimbs();
            h.updateLimbs();
            h.updateLimbs();
            h.updateLimbs();
            h.updateLimbs();
            h.updateLimbs();
            if(h.isHangmanComplete()){
                System.out.println("isHangmanComplete() works");
            }
            else{
                System.out.println("There is a problem with isHangmanComplete()");
            }
        }
    }
}
