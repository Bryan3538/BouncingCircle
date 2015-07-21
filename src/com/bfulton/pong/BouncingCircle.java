package com.bfulton.pong;


import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan Fulton
 */
public class BouncingCircle {
        
        public static final int RIGHT = 0;
        public static final int LEFT = 1;
        public static final int TOP = 2;
        public static final int BOTTOM = 3;
        private int x;
        private int y;
        private int dx;
        private int dy;
        private int diameter;
        private Color color;
        private Random rand;
        
        BouncingCircle() {
            x = 0;
            y = 0;
            dx = 3;
            dy = 3;
            diameter = 5;
            color = Color.BLACK;
            rand = new Random(System.currentTimeMillis());
        }
        
        BouncingCircle(int x, int y, int diameter) {
            this.x = x;
            this.y = y;
            dx = 7;
            dy = 7;
            this.diameter = diameter;
            rand = new Random(System.currentTimeMillis());
        }
        
        BouncingCircle(int x, int y, int diameter, Color color) {
            this(x, y, diameter);
            this.color = color;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public int getX() {
            return x;
        }
        
        public void setY (int y) {
            this.y = y;
        }
        
        public int getY() {
            return y;
        }
        
        public void setCoordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Rectangle getBounds() {
            return new Rectangle(x, y, diameter, diameter);
        }
        
        public int getDiameter() {
            return diameter;
        }
        
        public void changeSize(int diameter) {
            this.diameter = diameter;
        }
        
        public void changeColor(Color color) {
            this.color = color;
        }
        
        public void paint (Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillOval(x, y, diameter, diameter);               
        }
        
        
        public void move() {
            x += dx;
            y += dy;
        }
        
        public void changeDirection(Rectangle parentBounds) {
            int minPos = 5;
            int maxPos = 10;
            int minNeg = -10;
            int maxNeg = -5;
            
            if (x > parentBounds.width - 15) { //right
                dx = -7;
            } else if (x < diameter + 15) { //left
                dx = 7;
            }
            
            if (y + diameter > parentBounds.height  - 15) { //bottom
                dy = rand.nextInt(maxNeg - minNeg + 1) + minNeg; 
            } else if (y < 25) { //top
                dy = rand.nextInt(maxPos - minPos + 1) + minPos;
            }
        }
        
        public void changeDirection(int side)
        {
            int minPos = 5;
            int maxPos = 10;
            int minNeg = -10;
            int maxNeg = -5;
            
            switch(side) {
                case RIGHT:
                    dx = -7;
                    break;
                case LEFT:
                    dx = 7;
                    break;
                case TOP:
                    dy = rand.nextInt(maxPos - minPos + 1) + minPos;
                    break;
                case BOTTOM:
                    dy = rand.nextInt(maxNeg - minNeg + 1) + minNeg; 
                    break;
            }
        }
      
}
