package main;

import tokens.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener
{
    
    private Token tokenGrabbed;
    private boolean leftPressed, rightPressed, leftClicked, rightClicked;
    private int mouseX, mouseY;
    private int wheelClicks;
    
    public MouseManager()
    {
        tokenGrabbed = null;
    }
    
    public boolean isLeftPressed()
    {
        return leftPressed;
    }
    
    public boolean isRightPressed()
    {
        return rightPressed;
    }
    
    public boolean isLeftClicked()
    {
        return leftClicked;
    }
    
    public boolean isRightClicked()
    {
        return rightClicked;
    }
    
    public void resetClicks()
    {
        leftClicked = false;
        rightClicked = false;
    }
    
    public int getMouseX()
    {
        return mouseX;
    }
    
    public int getMouseY()
    {
        return mouseY;
    }
    
    public Token getTokenGrabbed()
    {
        return tokenGrabbed;
    }
    
    public void setTokenGrabbed(Token tokenGrabbed)
    {
        this.tokenGrabbed = tokenGrabbed;
    }
    
    //Implemented Methods
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1) //Left Mouse Button
            leftClicked = true;
        else if (e.getButton() == MouseEvent.BUTTON3) //Right Mouse Button
            rightClicked = true;
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1) //Left Mouse Button
            leftPressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3) //Right Mouse Button
            rightPressed = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1) //Left Mouse Button
            {
                leftPressed = false;
            }
        else if (e.getButton() == MouseEvent.BUTTON3) //Right Mouse Button
            {
                rightPressed = false;
            }
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        wheelClicks = e.getWheelRotation();
    }
    
}