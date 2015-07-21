package com.bfulton.pong;


import java.awt.Container;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan Fulton
 */
public class CircleMover implements Runnable {

    private boolean running;
    private Container parentContainer;
    private BouncingCircle bouncer;
    private Paddle paddleOne;
    private Paddle paddleTwo;
    
    CircleMover(Container c, BouncingCircle b, Paddle p1) {
        running = false;
        parentContainer = c;
        bouncer = b;
        paddleOne = p1;
        paddleTwo = null;
    }
    @Override
    public void run() {
        
        running = true;
        Rectangle panelBounds = parentContainer.getBounds();
        
        while(running) {
            bouncer.move();
            if (bouncer.getX() >= panelBounds.x + panelBounds.width ||
                    bouncer.getX() <= panelBounds.x || 
                    bouncer.getY() >= panelBounds.y + panelBounds.height ||
                    bouncer.getY() <= panelBounds.y) {
                bouncer.changeDirection(parentContainer.getBounds());
                //bouncer.move();
            }
            
            if (bouncer.getBounds().intersects(paddleOne.getBounds())) {
                bouncer.changeDirection(parentContainer.getBounds());
            }
            parentContainer.repaint();
            System.out.println(System.currentTimeMillis() + " painted");
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void stopRunning() {
        running = false;
    }
    
}
