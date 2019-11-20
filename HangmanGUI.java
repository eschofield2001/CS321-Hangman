import javax.swing.*;
import java.awt.geom.Point2D;
import java.awt.geom.*;
import java.awt.*;
// Displays the hangman limbs corresponding to the user input, updates the blanks and letter boxes
public class HangmanGUI extends JPanel {
    final private int blankY = 600;
    final private int fontSize = 20; // Set a basic font size for letters to fill in blanks and incorrect letter spots
    // Set values to display in the incorrect letters box
    final private int incorrectX1 = 50, incorrectY1 = 310;
    final private int incorrectX2 = 50, incorrectY2 = 335;
    final private int incorrectX3 = 50, incorrectY3 = 360;
    final private int incorrectX4 = 50, incorrectY4 = 385;
    final private int incorrectX5 = 50, incorrectY5 = 410;

    // Test letters
    private String testString = "J";
    private String testString1 = "K";
    private String testString2 = "L";
    private String testString3 = "M";
    private String testString4 = "N";

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        // Create the gallows

        // Define each point
        Point2D.Double gallows1 = new Point2D.Double(200, 160);
        Point2D.Double gallows2 = new Point2D.Double(200, 120);

        Point2D.Double gallows3 = new Point2D.Double(340, 120);

        Point2D.Double gallows4 = new Point2D.Double(340, 450);
        Point2D.Double gallows5 = new Point2D.Double(220, 450);
        Point2D.Double gallows6 = new Point2D.Double(360, 450);

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
        Point2D.Double boxTopLeft = new Point2D.Double(30,290);
        Point2D.Double boxTopRight  = new Point2D.Double(90, 290);
        Point2D.Double boxBottomLeft = new Point2D.Double(30, 430);
        Point2D.Double boxBottomRight = new Point2D.Double(90, 430);

        // Create outline of the incorrect letters box
        Line2D.Double boxTop = new Line2D.Double(boxTopLeft, boxTopRight);
        Line2D.Double boxRight = new Line2D.Double(boxTopRight, boxBottomRight);
        Line2D.Double boxBottom = new Line2D.Double(boxBottomLeft, boxBottomRight);
        Line2D.Double boxLeft = new Line2D.Double(boxBottomLeft, boxTopLeft);

        // Create the label for the box
        Font incorrectText = new Font("Serif", Font.PLAIN, 15);
        Font fontTest = new Font("Serif", Font.BOLD, fontSize);
        g2.setFont(fontTest);
        g2.setColor(Color.BLACK);
        g2.drawString(testString, incorrectX1, incorrectY1);
        g2.drawString(testString1, incorrectX2, incorrectY2);
        g2.drawString(testString2, incorrectX3, incorrectY3);
        g2.drawString(testString3, incorrectX4, incorrectY4);
        g2.drawString(testString4, incorrectX5, incorrectY5);

        g2.setFont(incorrectText);
        g2.setColor(Color.BLACK);
        g2.drawString("Incorrect Letters", 15, 280);

        // Draw the incorrect letters box
        g2.draw(boxTop);
        g2.draw(boxRight);
        g2.draw(boxBottom);
        g2.draw(boxLeft);

        // Create the hangman limbs

        // Hangman's head
        Ellipse2D.Double head = new Ellipse2D.Double(180, 160, 40, 40);

        // Hangman's right arm starting and ending points
        Point2D.Double ra1 = new Point2D.Double(200, 210);
        Point2D.Double ra2 = new Point2D.Double(250, 250);

        // Hangman's left arm starting and ending points
        Point2D.Double la1 = new Point2D.Double(200, 210);
        Point2D.Double la2 = new Point2D.Double(150, 250);

        // Hangman's body starting and ending points starting from the top
        Point2D.Double b1 = new Point2D.Double(200, 200);
        Point2D.Double b2 = new Point2D.Double(200, 300);

        // Hangman's right leg starting and ending points
        Point2D.Double rl1 = new Point2D.Double(200, 300);
        Point2D.Double rl2 = new Point2D.Double(250, 350);

        // Hangman's left leg starting and ending points
        Point2D.Double ll1 = new Point2D.Double(200, 300);
        Point2D.Double ll2 = new Point2D.Double(150, 350);

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
        Point2D.Double p1 = new Point2D.Double(65, blankY);
        Point2D.Double p2 = new Point2D.Double(95, blankY);

        Point2D.Double p3 = new Point2D.Double(105, blankY);
        Point2D.Double p4 = new Point2D.Double(135, blankY);

        Point2D.Double p5 = new Point2D.Double(145, blankY);
        Point2D.Double p6 = new Point2D.Double(175, blankY);

        Point2D.Double p7 = new Point2D.Double(185, blankY);
        Point2D.Double p8 = new Point2D.Double(215, blankY);

        Point2D.Double p9 = new Point2D.Double(225, blankY);
        Point2D.Double p10 = new Point2D.Double(255, blankY);

        Point2D.Double p11 = new Point2D.Double(265, blankY);
        Point2D.Double p12 = new Point2D.Double(295, blankY);

        Point2D.Double p13 = new Point2D.Double(305, blankY);
        Point2D.Double p14 = new Point2D.Double(335, blankY);

        Point2D.Double p15 = new Point2D.Double(345, blankY);
        Point2D.Double p16 = new Point2D.Double(375, blankY);

        Point2D.Double p17 = new Point2D.Double(385, blankY);
        Point2D.Double p18 = new Point2D.Double(415, blankY);

        Point2D.Double p19 = new Point2D.Double(425, blankY);
        Point2D.Double p20 = new Point2D.Double(455, blankY);

        Point2D.Double p21 = new Point2D.Double(465, blankY);
        Point2D.Double p22 = new Point2D.Double(495, blankY);

        Point2D.Double p23 = new Point2D.Double(505, blankY);
        Point2D.Double p24 = new Point2D.Double(535, blankY);

        Point2D.Double p25 = new Point2D.Double(545, blankY);
        Point2D.Double p26 = new Point2D.Double(575, blankY);

        Point2D.Double p27 = new Point2D.Double(585, blankY);
        Point2D.Double p28 = new Point2D.Double(615, blankY);

        Point2D.Double p29 = new Point2D.Double(625, blankY);
        Point2D.Double p30 = new Point2D.Double(655, blankY);

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
        Line2D.Double blank13 = new Line2D.Double(p25, p26);
        Line2D.Double blank14 = new Line2D.Double(p27, p28);
        Line2D.Double blank15 = new Line2D.Double(p29, p30);




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
        g2.draw(blank13);
        g2.draw(blank14);
        g2.draw(blank15);


    }

}
