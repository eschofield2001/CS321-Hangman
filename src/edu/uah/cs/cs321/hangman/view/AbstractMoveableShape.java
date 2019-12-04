package edu.uah.cs.cs321.hangman.view;

public abstract class AbstractMoveableShape implements MoveableShape {
    private int x;
    private int y;

    /**
     * Constructor for AbstractMoveableShape that initializes the x and y coordinates
     * @param x x-coordinate
     * @param y y0coordinate
     */
    public AbstractMoveableShape(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the Shape by a given amount
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
