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

    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double head = new Ellipse2D.Double(x, y, width, width);
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width/2, width, 3*height/5);
        Ellipse2D.Double leftEye = new Ellipse2D.Double(x, y + width/2, width/3, height/5);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(x + 2*width/3, y + width/2, width/3, height/5);
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

    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int num) {
        x = num;
    }

    @Override
    public void setY(int num) {
        y = num;
    }
}
