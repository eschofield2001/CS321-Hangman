import javax.swing.*;
import java.awt.*;

public class LetterIcon implements Icon {

    private int width;
    private int height;
    private Character currentLetter;
    private int fontSize;

    public LetterIcon(Character c, int width, int height, int fontSize) {
        this.width = width;
        this.height = height;
        this.currentLetter = c;
        this.fontSize = fontSize;
    }

    /**
     * Responsible for painting the letter
     * @param c component
     * @param g graphics component
     * @param x x-coordinate
     * @param y y-coordinate
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Serif", Font.BOLD, fontSize);

        g2.setFont(font);
        g2.setColor(Color.black);

        g2.drawString(currentLetter.toString(), width/4, (3 * height)/4);
    }

    /**
     * Returns the icon's width
     * @return width
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * Returns the icon's height
     * @return height
     */
    @Override
    public int getIconHeight() {
        return height;
    }
}
