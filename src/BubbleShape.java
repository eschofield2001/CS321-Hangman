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

    @Override
    public int getX(){
        return x;
    }

    @Override
    public int getY(){
        return y;
    }

    @Override
    public void setY(int num){
        this.y = num;
    }

    @Override
    public void setX(int num){
        this.x = num;
    }

    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double bubble = new Ellipse2D.Double(x, y, width, width);
       // g2.setColor(new Color(0, 102, 204));
        //g2.fillRect(x, y, width, height);
        g2.setColor(new Color(51,153,255));
        g2.fill(bubble);
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
