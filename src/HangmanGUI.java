import javax.swing.*;
import java.awt.geom.Point2D;
import java.awt.geom.*;
import java.awt.*;
// Displays the hangman limbs corresponding to the user input, updates the blanks and letter boxes
public class HangmanGUI extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;

    HangmanGUI(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        // Create the gallows

        // Define each point
        Point2D.Double gallows1 = new Point2D.Double(width * 0.5, height * 0.15);
        Point2D.Double gallows2 = new Point2D.Double(width * 0.5, height * 0.1);

        Point2D.Double gallows3 = new Point2D.Double(width * 0.75, height * 0.15);

        Point2D.Double gallows4 = new Point2D.Double(width * 0.75, height * 0.45);
        Point2D.Double gallows5 = new Point2D.Double(width * 0.5, height * 0.45);
        Point2D.Double gallows6 = new Point2D.Double(width * 0.8, height * 0.45);

        // Connect each point
        Line2D.Double rope = new Line2D.Double(gallows1, gallows2);
        Line2D.Double top = new Line2D.Double(gallows2, gallows3);
        Line2D.Double supportBeam = new Line2D.Double(gallows3, gallows4);
        Line2D.Double lBase = new Line2D.Double(gallows4, gallows5);
        Line2D.Double rBase = new Line2D.Double(gallows4, gallows6);

        // Draw the gallows
        g2.draw(rope);
        g2.draw(top);
        g2.draw(supportBeam);
        g2.draw(lBase);
        g2.draw(rBase);

        // Create the incorrect letters box
        Point2D.Double boxTopLeft = new Point2D.Double(width * 0.3,height * 0.29);
        Point2D.Double boxTopRight  = new Point2D.Double(width * 0.4, height * 0.29);
        Point2D.Double boxBottomLeft = new Point2D.Double(width * 0.3, height * 0.44);
        Point2D.Double boxBottomRight = new Point2D.Double(width * 0.4, height * 0.44);

        // Create outline of the incorrect letters box
        Line2D.Double boxTop = new Line2D.Double(boxTopLeft, boxTopRight);
        Line2D.Double boxRight = new Line2D.Double(boxTopRight, boxBottomRight);
        Line2D.Double boxBottom = new Line2D.Double(boxBottomLeft, boxBottomRight);
        Line2D.Double boxLeft = new Line2D.Double(boxBottomLeft, boxTopLeft);

        // Create the label for the box
        Font incorrectText = new Font("Serif", Font.PLAIN, 15);
        // Set a basic font size for letters to fill in blanks and incorrect letter spots
        int FONT_SIZE = 20;
        Font fontTest = new Font("Serif", Font.BOLD, FONT_SIZE);
        g2.setFont(fontTest);
        g2.setColor(Color.BLACK);
        // Test letters
        String testString = "J";
        int INCORRECTX = (int)(width * 0.34);
        int INCORRECTY1 = (int)(width * 0.31);
        g2.drawString(testString, INCORRECTX, INCORRECTY1);
        String testString1 = "K";
        int INCORRECTY2 = (int)(width * 0.34);
        g2.drawString(testString1, INCORRECTX, INCORRECTY2);
        char test = 'Z';
        String testString2 = "L";
        int INCORRECTY3 = (int)(width * 0.37);
        g2.drawString(Character.toString(test), INCORRECTX, INCORRECTY3);
        String testString3 = "M";
        int INCORRECTY4 = (int)(width * 0.4);
        g2.drawString(testString3, INCORRECTX, INCORRECTY4);
        String testString4 = "N";
        int INCORRECTY5 = (int)(width * 0.43);
        g2.drawString(testString4, INCORRECTX, INCORRECTY5);

        g2.setFont(incorrectText);
        g2.setColor(Color.BLACK);
        g2.drawString("Incorrect Letters", (int)(width * 0.3), (int)(height * 0.25));

        // Draw the incorrect letters box
        g2.draw(boxTop);
        g2.draw(boxRight);
        g2.draw(boxBottom);
        g2.draw(boxLeft);

        // Create the hangman limbs

        // Hangman's head
        Ellipse2D.Double head = new Ellipse2D.Double(width * 0.48, height * 0.15, 40, 40);

        // Hangman's right arm starting and ending points
        Point2D.Double ra1 = new Point2D.Double(width * 0.5, height * 0.21);
        Point2D.Double ra2 = new Point2D.Double(width * 0.52, height * 0.25);

        // Hangman's left arm starting and ending points
        Point2D.Double la1 = new Point2D.Double(width * 0.5, height * 0.21);
        Point2D.Double la2 = new Point2D.Double(width * 0.48, height * 0.25);

        // Hangman's body starting and ending points starting from the top
        Point2D.Double b1 = new Point2D.Double(width * 0.5, height * 0.19);
        Point2D.Double b2 = new Point2D.Double(width * 0.5, height * 0.3);

        // Hangman's right leg starting and ending points
        Point2D.Double rl1 = new Point2D.Double(width * 0.5, height * 0.3);
        Point2D.Double rl2 = new Point2D.Double(width * 0.52, height * 0.35);

        // Hangman's left leg starting and ending points
        Point2D.Double ll1 = new Point2D.Double(width * 0.5, height * 0.3);
        Point2D.Double ll2 = new Point2D.Double(width * 0.48, height * 0.35);

        // Fill the lines
        Line2D.Double rightArm = new Line2D.Double(ra1, ra2);
        Line2D.Double leftArm = new Line2D.Double(la1, la2);
        Line2D.Double body = new Line2D.Double(b1, b2);
        Line2D.Double rightLeg = new Line2D.Double(rl1, rl2);
        Line2D.Double leftLeg = new Line2D.Double(ll1, ll2);

        // Draw each hangman shape
        g2.draw(head);
        g2.draw(rightArm);
        g2.draw(leftArm);
        g2.draw(body);
        g2.draw(rightLeg);
        g2.draw(leftLeg);

        // Create the blanks

        // Define each point
        double blankY = height * 0.6;
        // First Blank
        Point2D.Double p1 = new Point2D.Double(width * 0.35, blankY);
        Point2D.Double p2 = new Point2D.Double(width * 0.38, blankY);

        // Second Blank
        Point2D.Double p3 = new Point2D.Double(width * 0.39, blankY);
        Point2D.Double p4 = new Point2D.Double(width * 0.42, blankY);

        // Third Blank
        Point2D.Double p5 = new Point2D.Double(width * 0.43, blankY);
        Point2D.Double p6 = new Point2D.Double(width * 0.46, blankY);

        // Fourth Blank
        Point2D.Double p7 = new Point2D.Double(width * 0.47, blankY);
        Point2D.Double p8 = new Point2D.Double(width * 0.5, blankY);

        // Fifth Blank
        Point2D.Double p9 = new Point2D.Double(width * 0.51, blankY);
        Point2D.Double p10 = new Point2D.Double(width * 0.54, blankY);

        // Sixth Blank
        Point2D.Double p11 = new Point2D.Double(width * 0.55, blankY);
        Point2D.Double p12 = new Point2D.Double(width * 0.58, blankY);

        // Seventh Blank
        Point2D.Double p13 = new Point2D.Double(width * 0.59, blankY);
        Point2D.Double p14 = new Point2D.Double(width * 0.62, blankY);

        // Eighth Blank
        Point2D.Double p15 = new Point2D.Double(width * 0.63, blankY);
        Point2D.Double p16 = new Point2D.Double(width * 0.66, blankY);

        // Ninth Blank
        Point2D.Double p17 = new Point2D.Double(width * 0.67, blankY);
        Point2D.Double p18 = new Point2D.Double(width * 0.7, blankY);

        // Tenth Blank
        Point2D.Double p19 = new Point2D.Double(width * 0.71, blankY);
        Point2D.Double p20 = new Point2D.Double(width * 0.74, blankY);

        // Eleventh Blank
        Point2D.Double p21 = new Point2D.Double(width * 0.75, blankY);
        Point2D.Double p22 = new Point2D.Double(width * 0.78, blankY);

        // Twelfth Blank
        Point2D.Double p23 = new Point2D.Double(width * 0.79, blankY);
        Point2D.Double p24 = new Point2D.Double(width * 0.82, blankY);

        /*Point2D.Double p25 = new Point2D.Double(width * 0.50, blankY);
        Point2D.Double p26 = new Point2D.Double(width * 0.50, blankY);

        Point2D.Double p27 = new Point2D.Double(width * 0.50, blankY);
        Point2D.Double p28 = new Point2D.Double(width * 0.50, blankY);

        Point2D.Double p29 = new Point2D.Double(width * 0.50, blankY);
        Point2D.Double p30 = new Point2D.Double(width * 0.50, blankY);*/

        // Connect the points for each blank
        Line2D.Double blank1 = new Line2D.Double(p1, p2);
        Line2D.Double blank2 = new Line2D.Double(p3, p4);
        Line2D.Double blank3 = new Line2D.Double(p5, p6);
        Line2D.Double blank4 = new Line2D.Double(p7, p8);
        Line2D.Double blank5 = new Line2D.Double(p9, p10);
        Line2D.Double blank6 = new Line2D.Double(p11, p12);
        Line2D.Double blank7 = new Line2D.Double(p13, p14);
        Line2D.Double blank8 = new Line2D.Double(p15, p16);
        Line2D.Double blank9 = new Line2D.Double(p17, p18);
        Line2D.Double blank10 = new Line2D.Double(p19, p20);
        Line2D.Double blank11 = new Line2D.Double(p21, p22);
        Line2D.Double blank12 = new Line2D.Double(p23, p24);
        /*Line2D.Double blank13 = new Line2D.Double(p25, p26);
        Line2D.Double blank14 = new Line2D.Double(p27, p28);
        Line2D.Double blank15 = new Line2D.Double(p29, p30);*/

        // Draw the blanks
        g2.draw(blank1);
        g2.draw(blank2);
        g2.draw(blank3);
        g2.draw(blank4);
        g2.draw(blank5);
        g2.draw(blank6);
        g2.draw(blank7);
        g2.draw(blank8);
        g2.draw(blank9);
        g2.draw(blank10);
        g2.draw(blank11);
        g2.draw(blank12);
        /*g2.draw(blank13);
        g2.draw(blank14);
        g2.draw(blank15);*/

    }

}
