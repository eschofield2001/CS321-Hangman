import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * An icon that contains a moveable shape
 */
public class ShapeIcon implements Icon{
    private int width;
    private int height;
    private MoveableShape shape;

    /**
     * Constructs a ShapeIcon item
     * @param shape a Shape that implements MoveableShape
     * @param width width of the shape
     * @param height height of the shape
     */
    public ShapeIcon(MoveableShape shape, int width, int height){
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
