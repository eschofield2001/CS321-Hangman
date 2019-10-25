import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *This class is responsible for displaying a menu that allows the user to choose which theme they would like to play.
 */
public class ThemeSelectionGUI {
    //1-classic, 2-multiplayer, 3-under the sea, 4-halloween
    private int themeChoice = -1;
    private JFrame themeMenu = new JFrame();

    /**
     * This method is responsible for displaying the menu and storing the user's selection.
     */
    public void displayThemeMenu(){
        //JFrame themeMenu = new JFrame();

        //Text field set up
        final int FIELD_WIDTH = 30;
        final JTextField textField = new JTextField(FIELD_WIDTH);
        textField.setText("Choose which theme you would like to play.");

        //Classic button set up
        JButton classicButton = new JButton("Classic");
        classicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                themeChoice = 1;
                themeMenu.dispose();
                //System.out.println("closed"); for testing
            }
        });

        //Multiplayer button set up
        JButton multiButton = new JButton("Multiplayer");
        multiButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                themeChoice = 2;
                themeMenu.dispose();
            }
        });

        //Under the sea button set up
        JButton seaButton = new JButton("Under the Sea");
        seaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                themeChoice = 3;
                themeMenu.dispose();
            }
        });

        //Halloween button set up
        JButton halloweenButton = new JButton("Halloween");
        halloweenButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                themeChoice = 4;
                themeMenu.dispose();
            }
        });

        themeMenu.setLayout(new FlowLayout());

        themeMenu.add(classicButton);
        themeMenu.add(multiButton);
        themeMenu.add(seaButton);
        themeMenu.add(halloweenButton);
        themeMenu.add(textField);

        themeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        themeMenu.pack();
        themeMenu.setLocationRelativeTo(null);
        themeMenu.setVisible(true);
    }

    /**
     * The purpose of this method is to return whether or not themeMenu is still active.
     * This can be used to prevent the main program from continuing its execution while themeMenu is still open.
     * @return boolean, true if themeMenu is active, false if it isn't
     */
    public boolean isThemeMenuActive(){
        return themeMenu.isActive();
    }

    /**
     * This method returns the user's choice of theme to initialize the animations in GameGUI and the list to be used by WordList
     * @return themeChoice, an integer corresponding to the user's theme choice
     */
    public int getThemeChoice(){
        return themeChoice;
    }

}
