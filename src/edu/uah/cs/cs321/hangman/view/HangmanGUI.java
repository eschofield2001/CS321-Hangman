package edu.uah.cs.cs321.hangman.view;
import edu.uah.cs.cs321.hangman.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class acts a view for the Hangman model. It displays and updates the graphical components of the games.
 */
public class HangmanGUI {

    private JPanel gamePanel;
    private HangmanPanel hangmanPic;
    private JPanel boxPanel;
    private JPanel blanksPanel;
    private ArrayList<JLabel> blankLabels;

    /**
     * Constructs a HangmanGUI object with default values.
     */
    public HangmanGUI() {
        gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        hangmanPic = new HangmanPanel();
        hangmanPic.setMinimumSize(new Dimension(500, 500));
        hangmanPic.setPreferredSize(new Dimension(500, 500));

        boxPanel = new JPanel();
        boxPanel.setPreferredSize(new Dimension(250, 150));
        boxPanel.setMaximumSize(new Dimension(250, 150));
        boxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        boxPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        blanksPanel = new JPanel();
        blanksPanel.setPreferredSize(new Dimension(700, 50));
        blanksPanel.setMaximumSize(new Dimension(700, 50));
        blanksPanel.setLayout(new FlowLayout());

        blankLabels = new ArrayList<>();
    }

    /**
     * Updates the view of the box of letters and the blanks.
     * @param h The Hangman object used to update the view.
     * @param c The Character used to update the view.
     */
    public void updateStateCorrect(Hangman h, Character c) {
        //Update the box of letters.
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(30, 30));
        label.setMaximumSize(new Dimension(30, 30));
        boxPanel.add(label);
        label.setIcon(new LetterIcon(Character.toUpperCase(c), 30, 30, 20));

        //Update the blanks.
        for(int i = 0; i < h.getgWord().length(); i++) {
            if(Character.toUpperCase(c) == Character.toUpperCase(h.getgWord().charAt(i)))
                blankLabels.get(i).setIcon(new LetterIcon(Character.toUpperCase(c), 50, 50, 45));
        }
    }

    /**
     * Updates the view of the box of letters and the limbs of the hangman.
     * @param h The Hangman object used to update the view.
     * @param c The Character used to update the view.
     */
    public void updateStateIncorrect(Hangman h, Character c) {
        //Update the box of letters.
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(30, 30));
        label.setMaximumSize(new Dimension(30, 30));
        boxPanel.add(label);
        label.setIcon(new LetterIcon(Character.toUpperCase(c), 30, 30, 20));

        //Update the limbs of the hangman.
        hangmanPic.setCurrentLimbs(h.getNumLimbs());
        hangmanPic.repaint();
        hangmanPic.setSize(500, 500);
    }

    /**
     * Initializes the view using the initial values of Hangman h.
     * @param h The Hangman object used to initialize the view.
     */
    public void initializeHangmanView(Hangman h) {
        //Remove any previous components from boxPanel and blanksPanel
        boxPanel.removeAll();
        blanksPanel.removeAll();
        blankLabels.clear();

        hangmanPic.setSize(500, 500);
        blanksPanel.setSize(700, 50);
        boxPanel.setSize(250, 250);

        //Add letters to box if needed
        if(h.getBoxLetters().size() != 0) {
            for(int i = 0; i < h.getBoxLetters().size(); i++) {
                JLabel letter = new JLabel();
                letter.setPreferredSize(new Dimension(30, 30));
                letter.setMaximumSize(new Dimension(30, 30));
                boxPanel.add(letter);
                letter.setIcon(new LetterIcon(Character.toUpperCase(h.getBoxLetters().get(i)), 30, 30, 20));
            }
        }
        gamePanel.add(boxPanel);

        //Reset limb count of hangman
        int cl = 0;
        hangmanPic.setCurrentLimbs(cl);
        gamePanel.add(hangmanPic);

        //Create view of blanks
        for(int i = 0; i < h.getBlanks().size(); i++) {
            if(h.getBlanks().get(i) == '_') {
                JLabel blank = new JLabel(new LetterIcon('_', 40, 40, 50));
                blank.setPreferredSize(new Dimension(50, 50));
                blank.setMaximumSize(new Dimension(50, 50));
                blankLabels.add(blank);
                blanksPanel.add(blank);
            }
            else {
                JLabel blank = new JLabel(new LetterIcon(Character.toUpperCase(h.getBlanks().get(i)), 50, 50, 45));
                blank.setPreferredSize(new Dimension(50, 50));
                blank.setMaximumSize(new Dimension(50, 50));
                blankLabels.add(blank);
                blanksPanel.add(blank);
            }
        }
        gamePanel.add(blanksPanel);
        gamePanel.revalidate();
    }

    /**
     * Returns a JPanel of the view.
     * @return gamePanel, JPanel of the view.
     */
    public JPanel getGamePanel() { return gamePanel; }
}
