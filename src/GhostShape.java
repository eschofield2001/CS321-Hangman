import java.awt.*;
import java.awt.geom.*;

/**
 * A Ghost that can be moved
 */
public class GhostShape extends AbstractMoveableShape {

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
        super.setX(x);
        super.setY(y);
        this.width = width;
        this.height = height;
    }

    /**
     * This method is responsible for drawing the ghost
     * @param g2 the graphics context
     */
    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double head = new Ellipse2D.Double(super.getX(), super.getY(), width, width);
        Rectangle2D.Double body = new Rectangle2D.Double(super.getX(), super.getY() + width/2, width, 3*height/5);
        Ellipse2D.Double leftEye = new Ellipse2D.Double(super.getX() + width/5, super.getY() + width/2, width/5, height/5);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(super.getX() + 3*width/5, super.getY() + width/2, width/5, height/5);
        g2.setColor(Color.WHITE);
        g2.fill(head);
        g2.fill(body);
        g2.fillPolygon(new int[]{super.getX(), super.getX(), super.getX() + width/3}, new int[]{super.getY() + 4*height/5, super.getY() + height, super.getY() + 4*height/5},3); //foot #1
        g2.fillPolygon(new int[]{super.getX() + width/3, super.getX() + width/2, super.getX() + 2*width/3}, new int[]{super.getY() + 4*height/5, super.getY() + height, super.getY() + 4*height/5},3); //foot #2
        g2.fillPolygon(new int[]{super.getX() + 2*width/3, super.getX() + width, super.getX() + width}, new int[]{super.getY() + 4*height/5, super.getY() + height, super.getY() + 4*height/5},3); //foot #3
        g2.setColor(Color.BLACK);
        g2.fill(leftEye);
        g2.fill(rightEye);
    }

}
