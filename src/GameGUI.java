

public class GameGUI {
    public static void main(String[] args){
        ThemeSelectionGUI test = new ThemeSelectionGUI();
        test.displayThemeMenu();

        // idk if this is a valid way to do this, but this chunk of code is meant to keep the program from continuing
        // while the frame is active
        int hold = 0;
        do {
            if (test.isThemeMenuActive()) {
            } else {
                hold = 1;
            }
        } while (hold != 1);
        System.out.println(test.getThemeChoice());

        ExitMenu exit = new ExitMenu();
        exit.presentExitMenu();
        hold = 0;

        do {
            if (!exit.isExitMenuActive()) {
                hold = 1;
            }
        } while(hold != 1);


    }
}
