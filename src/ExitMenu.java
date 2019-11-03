import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * Exit menu is a window that will provide the user with options to either play again, continue, go to menu, or quit the game
 */

public class ExitMenu {


        //1-back to game, 2-play again, 3-go to menu, 4-quit game
        private int exitOption;
        private JFrame exitMenu = new JFrame("Choose an Option");

        ExitMenu(){
            exitOption = -1;
        }
        /**
         * This method is responsible for displaying the menu options and storing the user's selection.
         */
        public void presentExitMenu(){

            //Back to Game button set up
            JButton backButton = new JButton("Back to Game");
            exitMenu.add(backButton);
            backButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    exitOption = 1;
                    exitMenu.dispose();
                }
            });

            //Play Again button set up
            JButton playAgainButton = new JButton("Play Again");
            exitMenu.add(playAgainButton);
            playAgainButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    exitOption = 2;
                    exitMenu.dispose();
                }
            });

            //Go to Menu button set up
            JButton goToMenuButton = new JButton("Go to Menu");
            exitMenu.add(goToMenuButton);
            goToMenuButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    exitOption = 3;
                    exitMenu.dispose();
                }
            });

            //Quit Game button set up
            JButton quitButton = new JButton("Quit Game");
            exitMenu.add(quitButton);
            quitButton.addActionListener(new endGame() {
                public void actionPerformed(ActionEvent event) {
                    exitOption = 4;
                    exitMenu.dispose();
                }
            });

            exitMenu.setLayout(new FlowLayout());

            exitMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            exitMenu.pack();
            exitMenu.setLocationRelativeTo(null);
            exitMenu.setVisible(true);
        }

        /**
         * The purpose of this method is to return whether or not exitMenu is still active.
         * This can be used to prevent the main program from continuing its execution while exitMenu is still open.
         * @return boolean, true if exitMenu is active, false if it isn't
         */
        public boolean isExitMenuActive(){
            return exitMenu.isActive();
        }

        public class endGame implements ActionListener{

            public void actionPerformed(ActionEvent e){

                exitOption = 4;
                System.exit(0);
            }

        }
        /**
         * This method returns the user's choice
         * @return exitOption, an integer corresponding to the user's exitMenu choice
         */
        public int getExit(){
            return exitOption;
        }
        /**
         * This will allow the user to play again
         */
       //public void playAgain(Hangman h, WordList w){

       // }
        /**
        * This will allow the user to go back to the start menu
        */
       /*
        public void goToStart(StartMenu s){

        }*/

    }



