package com.bfulton.pong;


import java.awt.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Bryan Fulton
 */
public class Paddle {

    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private Container parentContainer;

    Paddle() {
        height = 100;
        width = 20;
        x = 5;
        y = 5;
        color = Color.WHITE;
        parentContainer = null;
    }

    Paddle(int x, int y, int length, int width) {
        this.x = x;
        this.y = y;
        this.height = length;
        this.width = width;
    }

    Paddle(int x, int y, int length, int width, Color color) {
        this(x, y, length, width);
        this.color = color;
    }
    
    public void registerParentContainer(Container c) {
        parentContainer = c;
    }
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        if (parentContainer == null) {
            this.y = y;
        } else {
            int maxY = parentContainer.getHeight() - height;
            if (y <= maxY) {
                this.y = y;
            } else {
                this.y = maxY;
            }    
        }
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width)
    {
        if(width > 0)
            this.width = width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setHeight(int height)
    {
        if(height > 0)
            this.height = height;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }
}
