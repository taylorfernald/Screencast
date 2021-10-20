package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    
    public boolean[] keys;
    public boolean up, down, left, right, term, measure, zin, zout, zhome;
    
    
    public KeyManager()
    {
        keys = new boolean[256];
    }
    
    public void tick()
    {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        term = keys[KeyEvent.VK_T];
        measure = keys[KeyEvent.VK_M];
        zin = keys[KeyEvent.VK_E];
        zout = keys[KeyEvent.VK_Q];
        zhome = keys[KeyEvent.VK_R];
    }
    
    public void keyPressed(KeyEvent e) 
    {
        keys[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e) 
    {
        keys[e.getKeyCode()] = false;
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
}