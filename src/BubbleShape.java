import java.awt.*;
import java.awt.geom.*;

/**
 * A Bubble that can be moved
 */
public class BubbleShape implements MoveableShape {
    private int x;
    private int y;
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
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns x-coordinate
     * @return current x-coordinate
     */
    @Override
    public int getX(){
        return x;
    }

    /**
     * Returns y-coordinate
     * @return current y-coordinate
     */
    @Override
    public int getY(){
        return y;
    }

    /**
     * Sets y-coordinate equal to num
     * @param num new y-coordinate
     */
    @Override
    public void setY(int num){
        this.y = num;
    }

    /**
     * Sets x-coordinate equal to num
     * @param num new x-coordinate
     */
    @Override
    public void setX(int num){
        this.x = num;
    }

    /**
     * Draws the bubble
     * @param g2 the graphics context
     */
    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double bubble = new Ellipse2D.Double(x, y, width, width);
       // g2.setColor(new Color(0, 102, 204));
        //g2.fillRect(x, y, width, height);
        g2.setColor(new Color(51,153,255));
        g2.fill(bubble);
    }

    /**
     * Moves the bubble by a given amount
     * @param dx the amount to translate in the x-direction
     * @param dy the amount to translate in the y-direction
     */
    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
