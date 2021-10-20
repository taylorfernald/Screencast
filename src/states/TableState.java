package states; 

import java.awt.Graphics;
import java.awt.Color;
import main.*;
import tiles.*;

public class TableState extends State
{
    private Color background = new Color(55, 55, 55);
    private Map map;
    private int mapNum;
    //ints for measuring feet;
    private int pX = 0;
    private int pY = 0;
    private int cX = 0;
    private int cY = 0;
    private boolean measuring = false;
    
    public TableState(Handler handler, int mapNum)
    {
        super(handler);
        map = new Map(handler, "res/maps/map" + mapNum + ".txt");
        handler.setMap(map);
        
    }
    
    public void tick()
    {
        map.tick();
        
        //set cX and cY to the mouse X and mouse Y.
        //If the M key is pressed and pX and pY are 0, set pX and pY to mouse x and mouse y resp. Set measuring to true.
        //If the M key is not pressed, set pX and pY to 0. Set measuring to false.
        //If the M key is not pressed and neither pX or pY 0, output the distance between points p and c. Set pX and pY to 0.
        cX = handler.getMouseManager().getMouseX();
        cY = handler.getMouseManager().getMouseY();
        
        if (handler.getKeyManager().measure && pX == 0 && pY == 0)
        {
            pX = handler.getMouseManager().getMouseX();
            pY = handler.getMouseManager().getMouseY();
            measuring = true;
        }
        if (!handler.getKeyManager().measure)
        {
            measuring = false;
        }
        if (!handler.getKeyManager().measure && pX != 0 && pY != 0)
        {
            double dist = Math.sqrt(Math.pow(Math.abs(pX - cX), 2.0) + Math.pow(Math.abs(pY - pY), 2.0));
            System.out.println("Measured " + dist / Tile.TILEWIDTH * 5);
            
            pX = 0;
            pY = 0;
        }
    }
    
    public void render(Graphics g)
    {
        //the background color goes before everything
        map.render(g);
        if (handler.getKeyManager().term == true)
        {
            g.setColor(Color.red);
            g.fillOval(handler.getMouseManager().getMouseX() - 8, handler.getMouseManager().getMouseY() - 8, 
                16, 16);
        }
        if (measuring)
        {
            //If measuring, then draw a line between point p and point c.
            g.setColor(Color.red);
            g.drawLine(pX, pY, cX, cY);
        }
    }
    
}