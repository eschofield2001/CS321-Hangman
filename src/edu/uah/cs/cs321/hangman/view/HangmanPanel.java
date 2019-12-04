package edu.uah.cs.cs321.hangman.view;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A Panel that displays the hangman picture.
 */
public class HangmanPanel extends JPanel {

    private int currentLimbs;

    /**
     * Constructs a HangmanPanel with the currentLimbs set to 0.
     */
    public HangmanPanel() {
        currentLimbs = 0;
    }

    /**
     * Paints the hangman depending on the number of currentLimbs.
     * @param g Graphics object used to paint.
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        g2.setStroke(new BasicStroke(2));

        // Create the gallows

        // Define each point
        Point2D.Double gallows1 = new Point2D.Double((getWidth()/2) - 140, 160);
        Point2D.Double gallows2 = new Point2D.Double((getWidth()/2) - 140, 120);

        Point2D.Double gallows3 = new Point2D.Double(getWidth()/2, 120);

        Point2D.Double gallows4 = new Point2D.Double(getWidth()/2, 450);
        Point2D.Double gallows5 = new Point2D.Double((getWidth()/2) - 60, 450);
        Point2D.Double gallows6 = new Point2D.Double((getWidth()/2) + 60, 450);

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
        Ellipse2D.Double head = new Ellipse2D.Double((getWidth()/2) - 160, 160, 40, 40);

        // Hangman's right arm starting and ending points
        Point2D.Double ra1 = new Point2D.Double((getWidth()/2) - 140, 210);
        Point2D.Double ra2 = new Point2D.Double((getWidth()/2) - 90, 250);

        // Hangman's left arm starting and ending points
        Point2D.Double la1 = new Point2D.Double((getWidth()/2) - 140, 210);
        Point2D.Double la2 = new Point2D.Double((getWidth()/2) - 190, 250);

        // Hangman's body starting and ending points
        Point2D.Double b1 = new Point2D.Double((getWidth()/2) - 140, 200);
        Point2D.Double b2 = new Point2D.Double((getWidth()/2) - 140, 300);

        // Hangman's right leg starting and ending points
        Point2D.Double rl1 = new Point2D.Double((getWidth()/2) - 140, 300);
        Point2D.Double rl2 = new Point2D.Double((getWidth()/2) - 90, 350);

        // Hangman's left leg starting and ending points
        Point2D.Double ll1 = new Point2D.Double((getWidth()/2) - 140, 300);
        Point2D.Double ll2 = new Point2D.Double((getWidth()/2) - 190, 350);

        // Fill the lines
        Line2D.Double rightArm = new Line2D.Double(ra1, ra2);
        Line2D.Double leftArm = new Line2D.Double(la1, la2);
        Line2D.Double body = new Line2D.Double(b1, b2);
        Line2D.Double rightLeg = new Line2D.Double(rl1, rl2);
        Line2D.Double leftLeg = new Line2D.Double(ll1, ll2);

        // Draw each hangman shape
        if(currentLimbs >= 1)
            g2.draw(head);
        if(currentLimbs >= 2)
            g2.draw(body);
        if(currentLimbs >= 3)
            g2.draw(rightArm);
        if(currentLimbs >= 4)
            g2.draw(leftArm);
        if(currentLimbs >= 5)
            g2.draw(rightLeg);
        if(currentLimbs >= 6)
            g2.draw(leftLeg);
    }

    /**
     * Sets the currentLimbs to a passed in value.
     * @param cl The int value that currentLimbs is going to be set to.
     */
    public void setCurrentLimbs(int cl) {
        this.currentLimbs = cl;
    }
}
