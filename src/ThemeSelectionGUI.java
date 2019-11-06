import javax.swing.*;

/**
 *This class is responsible for displaying a menu that allows the user to choose which theme they would like to play.
 */
public class ThemeSelectionGUI {
    //0-classic, 1-multiplayer, 2-under the sea, 3-halloween
    private int themeChoice;

    /**
     * Constructor for ThemeSelectionGUI that initializes themeChoice to -1
     */
    ThemeSelectionGUI(){
        themeChoice = -1;
    }

    /**
     * This method is responsible for displaying the menu and storing the user's selection.
     */
    public void displayThemeMenu(){
        java.lang.String[] options = {"Classic", "Multi-player", "Under the Sea", "Halloween"};
        JComboBox themes = new JComboBox(options);

        JOptionPane.showMessageDialog(null, themes, "Select Theme", JOptionPane.QUESTION_MESSAGE);

        themeChoice = themes.getSelectedIndex();
    }

    /**
     * This method returns the user's choice of theme to initialize the animations in GameGUI and the list to be used by WordList
     * @return themeChoice, an integer corresponding to the user's theme choice
     */
    public int getThemeChoice(){
        return themeChoice;
    }

}

