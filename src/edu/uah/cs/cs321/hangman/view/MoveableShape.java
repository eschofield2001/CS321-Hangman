package edu.uah.cs.cs321.hangman.view;
import java.awt.*;

/**
 * A shape that can be moved around
 */
public interface MoveableShape {

    /**
     * Draws the shape
     * @param g2 the graphics context
     */
    void draw(Graphics2D g2);

    /**
     * Moves the shape by a given amount
     * @param dx the amount to translate in the x-direction
     * @param dy the amount to translate in the y-direction
     */
    void translate(int dx, int dy);

    /**
     * Returns x-coordinate
     * @return current x-coordinate
     */
    int getX();

    /**
     * Returns y-coordinate
     * @return current y-coordinate
     */
    int getY();

    /**
     * Sets x-coordinate equal to num
     * @param num new x-coordinate
     */
    void setX(int num);

    /**
     * Sets y-coordinate equal to num
     * @param num new y-coordinate
     */
    void setY(int num);
}
