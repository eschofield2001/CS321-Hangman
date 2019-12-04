package edu.uah.cs.cs321.hangman.view;
import java.awt.*;
import java.awt.geom.*;

/**
 * A Bubble that can be moved
 */
public class BubbleShape extends AbstractMoveableShape {
    private int width;
    private int height;

    /**
     * Constructs a bubble item
     * @param x the left of the bounding rectangle
     * @param y the top of the bounding rectangle
     * @param width the width of the bounding rectangle
     * @param height the height of the bounding rectangle
     */
    public BubbleShape(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Draws the bubble
     * @param g2 the graphics context
     */
    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double bubble = new Ellipse2D.Double(super.getX(), super.getY(), width, height);
        g2.setColor(new Color(51,153,255));
        g2.fill(bubble);
    }

}
