import java.awt.*;
import java.awt.geom.*;

/**
 * A Ghost that can be moved
 */
public class GhostShape implements MoveableShape {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructs a ghost item
     * @param x the left of the bounding rectangle
     * @param y the top of the bounding rectangle
     * @param width the width of the bounding rectangle
     * @param height the height of the bounding rectangle
     */
    public GhostShape(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * This method is responsible for drawing the ghost
     * @param g2 the graphics context
     */
    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double head = new Ellipse2D.Double(x, y, width, width);
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width/2, width, 3*height/5);
        Ellipse2D.Double leftEye = new Ellipse2D.Double(x + width/5, y + width/2, width/5, height/5);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(x + 3*width/5, y + width/2, width/5, height/5);
        g2.setColor(Color.WHITE);
        g2.fill(head);
        g2.fill(body);
        g2.fillPolygon(new int[]{x,x,x + width/3}, new int[]{y + 4*height/5, y + height, y + 4*height/5},3); //foot #1
        g2.fillPolygon(new int[]{x + width/3, x + width/2, x + 2*width/3}, new int[]{y + 4*height/5, y + height, y + 4*height/5},3); //foot #2
        g2.fillPolygon(new int[]{x + 2*width/3, x + width, x + width}, new int[]{y + 4*height/5, y + height, y + 4*height/5},3); //foot #3
        g2.setColor(Color.BLACK);
        g2.fill(leftEye);
        g2.fill(rightEye);
    }

    /**
     * Moves the ghost by a given amount
     * @param dx the amount to translate in the x-direction
     * @param dy the amount to translate in the y-direction
     */
    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Returns x-coordinate
     * @return current x-coordinate
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Returns y-coordinate
     * @return current y-coordinate
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Sets x-coordinate equal to num
     * @param num new x-coordinate
     */
    @Override
    public void setX(int num) {
        x = num;
    }

    /**
     * Sets y-coordinate equal to num
     * @param num new y-coordinate
     */
    @Override
    public void setY(int num) {
        y = num;
    }
}
