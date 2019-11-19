
import javax.swing.*;
import java.awt.geom.Point2D;
import java.awt.geom.*;
import java.awt.*;

public class HangmanGUI extends JPanel{
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        // Create the gallows

        // Define each point
        Point2D.Double gallows1 = new Point2D.Double(200, 160);
        Point2D.Double gallows2 = new Point2D.Double(200, 120);

        Point2D.Double gallows3 = new Point2D.Double(240, 120);

        Point2D.Double gallows4 = new Point2D.Double(240, 470);
        Point2D.Double gallows5 = new Point2D.Double(220, 470);
        Point2D.Double gallows6 = new Point2D.Double(260, 470);

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


        // Create the hangman limbs

        // Hangman's head
        Ellipse2D.Double head = new Ellipse2D.Double(190, 160, 20, 20);

        // Hangman's right arm starting and ending points
        Point2D.Double ra1 = new Point2D.Double(200, 180);
        Point2D.Double ra2 = new Point2D.Double(300, 230);

        // Hangman's left arm starting and ending points
        Point2D.Double la1 = new Point2D.Double(200, 180);
        Point2D.Double la2 = new Point2D.Double(100, 230);

        // Hangman's body starting and ending points
        Point2D.Double b1 = new Point2D.Double(200, 180);
        Point2D.Double b2 = new Point2D.Double(200, 380);

        // Hangman's right leg starting and ending points
        Point2D.Double rl1 = new Point2D.Double(200, 380);
        Point2D.Double rl2 = new Point2D.Double(300, 430);

        // Hangman's left leg starting and ending points
        Point2D.Double ll1 = new Point2D.Double(200, 380);
        Point2D.Double ll2 = new Point2D.Double(100, 430);

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

    }

}
