package edu.uah.cs.cs321.hangman.view;
import javax.swing.*;

/**
 *This class is responsible for displaying a menu that allows the user to choose whether or not to play again, go to menu, go back to the game or quit the game.
 */
public class ExitMenu {
    //0- Play Again, 1- Back to Game, 2- Back to Menu , 3- Quit Game
    private int exitChoice;

    /**
     * Constructor for ExitMenu that initializes exitChoice to -1
     */
    public ExitMenu(){
        exitChoice = -1;
    }

    /**
     * This method is responsible for displaying the menu and storing the user's selection.
     */
    public void presentExitMenu(){
        String[] options = {"Play Again", "Back to Game", "Back to Menu", "Quit Game"};
        JComboBox menuOptions = new JComboBox(options);

        JOptionPane.showMessageDialog(null, menuOptions, "Choose an Option", JOptionPane.QUESTION_MESSAGE);

        exitChoice = menuOptions.getSelectedIndex();
    }

    /**
     * This method is responsible for displaying the menu when the user wins the game.
     */
    public void presentExitMenuWin(){
        String[] options = {"Play Again", "Back to Menu", "Quit Game"};
        JComboBox menuOptions = new JComboBox(options);

        JOptionPane.showMessageDialog(null, menuOptions, "You Win!", JOptionPane.QUESTION_MESSAGE);
        if (menuOptions.getSelectedIndex() == 0){
            exitChoice = 0;
        }
        else if(menuOptions.getSelectedIndex() == 1){
            exitChoice = 2;
        }
        else{
            exitChoice = 3;
        }
    }

    /**
     * This method is responsible for displaying the menu when the user loses the game.
     */
    public void presentExitMenuLose(){
        String[] options = {"Play Again", "Back to Menu", "Quit Game"};
        JComboBox menuOptions = new JComboBox(options);

        JOptionPane.showMessageDialog(null, menuOptions, "You Lose!", JOptionPane.QUESTION_MESSAGE);
        if (menuOptions.getSelectedIndex() == 0){
            exitChoice = 0;
        }
        else if(menuOptions.getSelectedIndex() == 1){
            exitChoice = 2;
        }
        else{
            exitChoice = 3;
        }
    }

    /**
     * This method returns the user's choice to GameGUI to control the flow of the game
     * @return exitChoice, an integer corresponding to the user's exit menu choice
     */
    public int getExitChoice(){
        return exitChoice;
    }

}

