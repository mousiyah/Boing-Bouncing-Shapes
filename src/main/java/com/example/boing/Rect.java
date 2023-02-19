package com.example.boing;


/**
 * Rect.java
 * @version 1.0.0
 * @author musslimaz
 *
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Rectangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by its upper left edge
 */

public class Rect extends ClosedShape{
    // The width and height of the rectangle
    private int width, height;


    /**
     * Creates a rectangle.
     * @param x             The x position.
     * @param y             the y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param width         The width of the rectangle.
     * @param height        The height of the rectangle.
     * @param colour        The line or fill colour.
     * @param isFilled      True if the shape is filled, false if not.
     */
    protected Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a rectangle to a string.
     */
    public String toString () {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }


    /**
     * @return The width of the rectangle
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the rectangle
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * @param width Resets the width of the rectangle
     */
    void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height of the rectangle
     */
    void setHeight(int height) {
        this.height = height;
    }


    /**
     * Draw the rectangle on the screen.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect(x, y, width, height);
        }
        else {
            g.strokeRect( x, y, width, height);
        }
    }

}