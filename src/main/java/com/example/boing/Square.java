package com.example.boing;


/**
 * Square.java
 * @version 1.0.0
 * @author musslimaz
 *
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by its upper left edge
 */

public class Square extends ClosedShape{
    // The side of the square
    private int side;


    /**
     * Creates a square.
     * @param x             The x position.
     * @param y             the y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param side          The side of the square.
     * @param colour        The line or fill colour.
     * @param isFilled      True if the shape is filled, false if not.
     */
    protected Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @param side Resets the side of the circle.
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * @return The width of the square
     */
    @Override
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square
     */
    @Override
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect(x, y, side, side);
        }
        else {
            g.strokeRect( x, y, side, side);
        }
    }

}