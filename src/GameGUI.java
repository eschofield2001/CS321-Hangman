

public class GameGUI {
    public static void main(String[] args){
        ThemeSelectionGUI test = new ThemeSelectionGUI();
        test.displayThemeMenu();

        System.out.println("The user chose theme: " + test.getThemeChoice());
    }
}


