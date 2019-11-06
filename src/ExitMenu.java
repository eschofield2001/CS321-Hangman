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
    ExitMenu(){
        exitChoice = -1;
    }

    /**
     * This method is responsible for displaying the menu and storing the user's selection.
     */
    public void presentExitMenu(){
        String[] options = {"Play Again", "Back to Game", "Back to Menu", "Quit Game"};
        JComboBox menuOptions = new JComboBox(options);

        JOptionPane.showMessageDialog(null, options, "Choose an Option", JOptionPane.QUESTION_MESSAGE);

        exitChoice = menuOptions.getSelectedIndex();
    }

    /**
     * This method returns the user's choice to GameGUI to control the flow of the game
     * @return exitChoice, an integer corresponding to the user's exit menu choice
     */
    public int getThemeChoice(){
        return exitChoice;
    }

}

