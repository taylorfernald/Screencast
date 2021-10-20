package main;

import states.*;

import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tabletop implements Runnable
{
    
    private Display display;
    private int width, height;
    public int mapNum;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State tableState;
    private State mapState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    public Tabletop(String title, int width, int height, int mapNum)
    {
        this.width = width;
        this.height = height;
        this.mapNum = mapNum;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        init();
        System.out.println("Tabletop Created");
    }
    
    private void init()
    {
        display = new Display(title, width, height);
        //System.out.println("KeyManager is " + keyManager);
        //System.out.println("display is " + display);
        //System.out.println("display's frame through getFrame() is " + 
            //display.getFrame());
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        
        
        tableState = new TableState(handler, mapNum);
        mapState = new MapState(handler);
        State.setState(tableState);
    }
    
    private void tick()
    {
        keyManager.tick();
        if (State.getState() != null)
        {
            State.getState().tick();
        }
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        if (State.getState() != null)
        {
            State.getState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose();
    }
    
    public void run(){
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000)
            {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager()
    {
        if (keyManager == null)
            System.out.println("keyManager is null");
        return keyManager;
    }
    
    public MouseManager getMouseManager()
    {
        return mouseManager;
    }
    
    public GameCamera getGameCamera()
    {
        if (gameCamera == null)
            System.out.println("gameCamera is null");
        return gameCamera;
    }
    
    public synchronized void start()
    {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
        System.out.println("Tabletop Started.");
    }
    
    public synchronized void stop()
    {
        if (!running)
            return;
        running = false;
        try 
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie width*/
    public int getWidth(){
        return this.width;
    }//end method getWidth

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie height*/
    public int getHeight(){
        return this.height;
    }//end method getHeight

    //End GetterSetterExtension Source Code
//!
}