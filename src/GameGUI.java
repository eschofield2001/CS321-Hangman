import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is the main controller for the project. It pieces together all of the components all controls the flow of the game.
 */
public class GameGUI {

    static public void setAnimations(JFrame frame, ThemeSelectionGUI themeMenu){
        if(themeMenu.getThemeChoice() == 2 || themeMenu.getThemeChoice() == 3) {
            final MoveableShape shapeEAST;
            final MoveableShape shapeWEST;
            if (themeMenu.getThemeChoice() == 2) {
                shapeEAST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH) / 2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_WIDTH);
                shapeWEST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH) / 2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_WIDTH);
            } else {
                shapeEAST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH) / 2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
                shapeWEST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH) / 2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
            }
            ShapeIcon iconEAST = new ShapeIcon(shapeEAST, ICON_WIDTH, ICON_HEIGHT);
            ShapeIcon iconWEST = new ShapeIcon(shapeWEST, ICON_WIDTH, ICON_HEIGHT);

            final JLabel labelEast = new JLabel(iconEAST);
            final JLabel labelWest = new JLabel(iconWEST);

            frame.add(labelEast, BorderLayout.EAST);
            frame.add(labelWest, BorderLayout.WEST);

            final int DELAY = 50;
            Timer t = new Timer(DELAY, new ActionListener() {
                int counter = 0;
                int dx = 1;

                public void actionPerformed(ActionEvent event) {
                    if (counter == 20) {
                        dx *= -1;
                        counter = 0;
                    }
                    if (shapeEAST.getY() == 0) {
                        shapeEAST.setY(400);
                    }
                    shapeEAST.translate(dx, -1);
                    labelEast.repaint();
                    counter++;
                }
            });
            t.start();

            Timer t2 = new Timer(DELAY, new ActionListener() {
                int counter = 0;
                int dx = -1;

                public void actionPerformed(ActionEvent event) {
                    if (counter == 20) {
                        dx *= -1;
                        counter = 0;
                    }
                    if (shapeWEST.getY() == 0) {
                        shapeWEST.setY(400);
                    }
                    shapeWEST.translate(dx, -1);
                    labelWest.repaint();
                    counter++;
                }
            });
            t2.start();
        }

        frame.setLocationRelativeTo(null);
        frame.pack();
    }

    static public void startGame(JFrame frame, WordList w, ThemeSelectionGUI themeMenu, Hangman h){
        JFrame start = new JFrame("Hangman Start", null);
        Dimension d = new Dimension();
        d.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        start.setSize(d);
        start.setLayout(new BorderLayout());

        h.initializeHangmanStart();

        final int FIELD_WIDTH = 10;
        JTextField inputText = new JTextField(FIELD_WIDTH);
        inputText.setText("Input");

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> {
            if((inputText.getText().length() > 1)){
                JOptionPane.showMessageDialog(null, "Please only enter one letter at a time.");
            }
            else if(!Character.isLetter(inputText.getText().charAt(0))){
                JOptionPane.showMessageDialog(null, "Please only enter letters.");
            }
            else{
                boolean inWord = h.isLetterPresent((inputText.getText().charAt(0)));
                if(inWord){
                    //System.out.println(inputText.getText().charAt(0)); for testing
                    h.updateBlanks(inputText.getText().charAt(0));
                    //finish when HangmanGUI is done
                    //hangmanGUI.updateCorrect();
                    if(h.isBlanksFull()){
                        start.dispose();

                        themeMenu.displayThemeMenu();

                        w.setGameList(themeMenu.getThemeChoice());
                        w.setRandomWord();

                        h.initializeHangman(w);

                        setAnimations(frame, themeMenu);
                        frame.setVisible(true);
                    }
                }
                else{
                    h.updateBox(inputText.getText().charAt(0));
                    h.updateLimbs();
                    //finish when HangmanGUI is done
                    //hangmanGUI.updateIncorrect();
                    if(h.isHangmanComplete()){
                        start.dispose();

                        themeMenu.displayThemeMenu();

                        w.setGameList(themeMenu.getThemeChoice());
                        w.setRandomWord();

                        h.initializeHangman(w);

                        setAnimations(frame, themeMenu);

                        frame.setVisible(true);
                    }
                }
            }
            inputText.setText("");
        });

        JPanel flowLayout = new JPanel();
        flowLayout.add(inputText);
        flowLayout.add(enterButton);

        start.add(flowLayout, BorderLayout.SOUTH);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.pack();
        start.setLocationRelativeTo(null);
        start.setVisible(true);
    }

    /**
     * This method is responsible for putting together all of the components of the project and controlling the flow of the game.
     */
    public static void main(String[] args){
        //Tester test = new Tester();
        //test.testHangman(); - success
        //test.testWordList(); - success
        //test.testThemeSelectionGUI(); - success
        //test.testExitMenu(); - success
        Hangman hangman = new Hangman();
        HangmanGUI hangmanGUI = new HangmanGUI();
        ExitMenu exit = new ExitMenu();
        ThemeSelectionGUI themeMenu = new ThemeSelectionGUI();
        WordList words = new WordList();

        //Set up frame
        JFrame frame = new JFrame ("Hangman", null);
        Dimension d = new Dimension();
        d.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(d);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        //Fourth: Add control buttons & panel
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            int exitChoice;
            exit.presentExitMenu();
            exitChoice = exit.getExitChoice();
            switch (exitChoice){
                case 0:
                    if(themeMenu.getThemeChoice() == 1){
                        words.setGameList(themeMenu.getThemeChoice());
                    }
                    words.setRandomWord();
                    hangman.initializeHangman(words);
                    break;
                case 2:
                    //i don't know how to implement this yet
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        });

        final int FIELD_WIDTH = 10;
        JTextField inputText = new JTextField(FIELD_WIDTH);
        inputText.setText("Input");

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> {
            if((inputText.getText().length() > 1)){
                JOptionPane.showMessageDialog(null, "Please only enter one letter at a time.");
            }
            else if(!Character.isLetter(inputText.getText().charAt(0))){
                JOptionPane.showMessageDialog(null, "Please only enter letters.");
            }
            else{
                boolean inWord = hangman.isLetterPresent((inputText.getText().charAt(0)));
                if(inWord){
                    //System.out.println(inputText.getText().charAt(0)); for testing
                    hangman.updateBlanks(inputText.getText().charAt(0));
                //finish when HangmanGUI is done
                //hangmanGUI.updateCorrect();
                    if(hangman.isBlanksFull()){
                        int exitChoice;
                        exit.presentExitMenuWin();
                        exitChoice = exit.getExitChoice();
                        switch (exitChoice){
                            case 0:
                                if(themeMenu.getThemeChoice() == 1){
                                    words.setGameList(themeMenu.getThemeChoice());
                                }
                                words.setRandomWord();
                                hangman.initializeHangman(words);
                                break;
                            case 2:
                                //i don't know how to implement this yet
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    }
                }
                else{
                    hangman.updateBox(inputText.getText().charAt(0));
                    hangman.updateLimbs();
                //finish when HangmanGUI is done
                //hangmanGUI.updateIncorrect();
                    if(hangman.isHangmanComplete()){
                        int exitChoice;
                        exit.presentExitMenuLose();
                        exitChoice = exit.getExitChoice();
                        switch (exitChoice){
                            case 0:
                                if(themeMenu.getThemeChoice() == 1){
                                    words.setGameList(themeMenu.getThemeChoice());
                                }
                                words.setRandomWord();
                                hangman.initializeHangman(words);
                                break;
                            case 2:
                                //i don't know how to implement this yet
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            inputText.setText("");
        });

        JPanel flowLayout = new JPanel();
        flowLayout.add(exitButton);
        flowLayout.add(inputText);
        flowLayout.add(enterButton);

        frame.add(flowLayout, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);

        //Call StartMenu
        startGame(frame, words, themeMenu, hangman);

    }
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;
    private static final int SHAPE_WIDTH = 100;
    private static final int SHAPE_HEIGHT = 200;
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 400;

}


