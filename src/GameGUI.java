

public class GameGUI {
    public static void main(String[] args){
        ThemeSelectionGUI test = new ThemeSelectionGUI();
        test.displayThemeMenu();
        int hold = 0;
        System.out.println("The user chose theme: " + test.getThemeChoice());

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
