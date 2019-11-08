import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGUI {
    public static void main(String[] args){
        int userTheme = -1;
        String gameWord = null;
        ArrayList<Character> blanks = new ArrayList<>();

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
        gameWord = words.getWord();
        blanks = words.getBlanks();

        //Third: Set up animations based on userTheme
        if(userTheme == 2 || userTheme ==3){
            final MoveableShape shapeEAST;
            final MoveableShape shapeWEST;
            if(userTheme == 2){
                shapeEAST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH);
                shapeWEST = new BubbleShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH);
            }
            else{
                shapeEAST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
                shapeWEST = new GhostShape((ICON_WIDTH - SHAPE_WIDTH)/2, ICON_HEIGHT, SHAPE_WIDTH, SHAPE_HEIGHT);
            }
            ShapeIcon iconEAST = new ShapeIcon(shapeEAST, ICON_WIDTH, ICON_HEIGHT);
            ShapeIcon iconWEST = new ShapeIcon(shapeWEST, ICON_WIDTH, ICON_HEIGHT );

            final JLabel labelEast = new JLabel(iconEAST);
            final JLabel labelWest = new JLabel(iconWEST);

            frame.add(labelEast, BorderLayout.EAST);
            frame.add(labelWest, BorderLayout.WEST);

            final int DELAY = 100;
            Timer t = new Timer(DELAY, new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    if(shapeEAST.getY() == 0){
                        shapeEAST.setY(400);
                    }
                    shapeEAST.translate(0,-1);
                    labelEast.repaint();
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


