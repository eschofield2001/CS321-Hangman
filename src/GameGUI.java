import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGUI {

    public static void main(String[] args){
        int userTheme = -1;
        Hangman hangman = new Hangman();
        HangmanGUI hangmanGUI = new HangmanGUI();
        ArrayList<Character> blanks = new ArrayList<>();
        ExitMenu exit = new ExitMenu();

        //Set up frame
        JFrame frame = new JFrame("Hangman", null);
        Dimension d = new Dimension();
        d.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setSize(d);
        frame.setLayout(new BorderLayout());

        //First: Get userTheme
        ThemeSelectionGUI themeMenu = new ThemeSelectionGUI();
        themeMenu.displayThemeMenu();
        userTheme = themeMenu.getThemeChoice();

        //Second: Get WordList setup
        WordList words = new WordList();
        words.setGameList(userTheme);
        words.setRandomWord();

        //Third: Set up animations based on userTheme
        if(userTheme == 2 || userTheme ==3){
            final MoveableShape shapeEAST;
            final MoveableShape shapeWEST;
            if(userTheme == 2){
                //frame.setBackground(new Color(0, 102, 204));
                shapeEAST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
                shapeWEST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
            }
            else{
                //frame.setBackground(new Color(102, 0, 102));
                shapeEAST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
                shapeWEST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
            }
            ShapeIcon iconEAST = new ShapeIcon(shapeEAST, ICON_WIDTH, ICON_HEIGHT);
            ShapeIcon iconWEST = new ShapeIcon(shapeWEST, ICON_WIDTH, ICON_HEIGHT );

            final JLabel labelEast = new JLabel(iconEAST);
            final JLabel labelWest = new JLabel(iconWEST);

            frame.add(labelEast, BorderLayout.EAST);
            frame.add(labelWest, BorderLayout.WEST);

            final int DELAY = 50;
            Timer t = new Timer(DELAY, new ActionListener(){
                int counter = 0;
                int dx = 1;

                public void actionPerformed(ActionEvent event){
                    if(counter == 20){
                        dx *= -1;
                        counter = 0;
                    }
                    if(shapeEAST.getY() == 0){
                        shapeEAST.setY(400);
                    }
                    shapeEAST.translate(dx,-1);
                    labelEast.repaint();
                    counter++;
                }
            });
            t.start();

            Timer t2 = new Timer(DELAY, new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    if(shapeWEST.getY() == 0){
                        shapeWEST.setY(400);
                    }
                    shapeWEST.translate(0,-1);
                    labelWest.repaint();
                }
            });
            t2.start();
        }

        //Fourth: Add control buttons & panel
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int exitChoice = -1;
                exit.presentExitMenu();
                exitChoice = exit.getExitChoice();
                switch (exitChoice){
                    case 0:
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
        });

        final int FIELD_WIDTH = 10;
        JTextField inputText = new JTextField(FIELD_WIDTH);
        inputText.setText("Input");

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //PROBLEM HERE - WILL FIX LATER
               boolean inWord = hangman.isLetterPresent((inputText.getText().charAt(0)));
               if(inWord == true){
                   hangman.updateBlanks(inputText.getText().charAt(0));
                   /*finish when HangmanGUI is done
                   hangmanGUI.updateCorrect();*/
                   if(hangman.isBlanksFull() == true){
                       int exitChoice = -1;
                       exit.presentExitMenuWin();
                       exitChoice = exit.getExitChoice();
                       switch (exitChoice){
                           case 0:
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
                   /*finish when HangmanGUI is done
                   hangmanGUI.updateIncorrect();*/
                   if(hangman.isHangmanComplete() == true){
                       int exitChoice = -1;
                       exit.presentExitMenuLose();
                       exitChoice = exit.getExitChoice();
                       switch (exitChoice){
                           case 0:
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
        });

        JPanel flowLayout = new JPanel();
        flowLayout.add(exitButton);
        flowLayout.add(inputText);
        flowLayout.add(enterButton);


        frame.add(flowLayout, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;
    private static final int SHAPE_WIDTH = 100;
    private static final int SHAPE_HEIGHT = 200;
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 400;

}


