package tokens;

import java.awt.Graphics;
import main.*;
import tiles.Tile;

public abstract class Token
{  
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected float targetX, targetY;
    protected boolean active = true;
    
    public Token(Handler handler, float x, float y, int width, int height)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        targetX = x;
        targetY = y;
        
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    
    public void move()
    {
        //x = x + (targetX - x) / 2; //The x and y will close their distances.
        //y = y + (targetY - x) / 2;
        if (handler.getMouseManager().getTokenGrabbed() == this)
        {
            targetX = handler.getMouseManager().getMouseX() - (width/2) + handler.getGameCamera().getXOffset();
            targetY = handler.getMouseManager().getMouseY() - (height/2) + handler.getGameCamera().getYOffset();
        }
        else
        {
            targetX = (float) (Math.floor(x/Tile.TILEWIDTH)*Tile.TILEWIDTH);
            targetY = (float) (Math.floor(y/Tile.TILEHEIGHT)*Tile.TILEHEIGHT);
        }
        x = targetX;
        y = targetY;
    }
    
    public int getRange()
    {
        //If width and height are different, take the average and return it.
        return (getWidth() + getHeight()) / 2;
    }
    
    public boolean pointWithinReach(int px, int py, int reach)
    {
        //px and py are the point in question, rx and ry are the center
        //of this token.
        //ax and ay are the x and y adjusted for the camera.
        int rx, ry, ax, ay;
        ax = (int) (x - handler.getGameCamera().getXOffset());
        ay = (int) (y - handler.getGameCamera().getYOffset());
        rx = (int) (ax + reach);
        ry = (int) (ay + reach);
        //For point p to be considered within the box, its x has to be 
        //between ax and rx and its y between ay and ry.
        return ((ax <= px && px <= rx) && (ay <= py && py <= ry));
    }
    
        public void getInput()
    {
        /* If the left mouse button is pressed and mouse x and mouse y is within reach,
         * set the MouseManager's tokenGrabbed to this instance's reference.
         */
        boolean withinReach = pointWithinReach(handler.getMouseManager().getMouseX(), 
                handler.getMouseManager().getMouseY(), 
                getRange());
        
        if (handler.getMouseManager().isLeftPressed() && 
            withinReach && handler.getMouseManager().getTokenGrabbed() ==
            null)
        {
            handler.getMouseManager().setTokenGrabbed(this);
        } else if (!handler.getMouseManager().isLeftPressed())
        {
            handler.getMouseManager().setTokenGrabbed(null);
            
        }
        ///System.out.println(handler.getMouseManager().getTokenGrabbed());
        
        if (handler.getKeyManager().term && withinReach)
        {
            die();
        }
    }
    
    public void die()
    {
        active = false;
    }
    
    public boolean isActive()
    {
        return active;
    }
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie x*/
    public float getX(){
        return this.x;
    }//end method getX

    /**SET Method Propertie x*/
    public void setX(float x){
        this.x = x;
    }//end method setX

    /**GET Method Propertie y*/
    public float getY(){
        return this.y;
    }//end method getY

    /**SET Method Propertie y*/
    public void setY(float y){
        this.y = y;
    }//end method setY

    /**GET Method Propertie width*/
    public int getWidth(){
        return this.width;
    }//end method getWidth

    /**SET Method Propertie width*/
    public void setWidth(int width){
        this.width = width;
    }//end method setWidth

    /**GET Method Propertie height*/
    public int getHeight(){
        return this.height;
    }//end method getHeight

    /**SET Method Propertie height*/
    public void setHeight(int height){
        this.height = height;
    }//end method setHeight

    //End GetterSetterExtension Source Code
//!
}