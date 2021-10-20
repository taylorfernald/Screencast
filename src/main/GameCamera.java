package main;

import tiles.*;
import tokens.*;

public class GameCamera
{
    private float xOffset, yOffset;
    private Handler handler;
    
    public GameCamera(Handler handler, float xOffset, float yOffset)
    {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace()
    {
        if (xOffset < 0)
        {
            xOffset = 0;
        }else if (xOffset > handler.getMap().getWidth() * 
            Tile.TILEWIDTH - handler.getWidth())
            xOffset = handler.getMap().getWidth() * 
            Tile.TILEWIDTH - handler.getWidth();
        if (yOffset < 0)
        {
            yOffset = 0;
        }
        else if (yOffset > handler.getMap().getHeight() * 
            Tile.TILEHEIGHT - handler.getHeight())
            yOffset = handler.getMap().getHeight() * 
            Tile.TILEHEIGHT - handler.getHeight();
    }
    
    public void centerOnToken(Token e)
    {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }
   
    public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie xOffset*/
    public float getXOffset(){
        return this.xOffset;
    }//end method getXOffset

    /**SET Method Propertie xOffset*/
    public void setXOffset(float xOffset){
        this.xOffset = xOffset;
    }//end method setXOffset

    /**GET Method Propertie yOffset*/
    public float getYOffset(){
        return this.yOffset;
    }//end method getYOffset

    /**SET Method Propertie yOffset*/
    public void setYOffset(float yOffset){
        this.yOffset = yOffset;
    }//end method setYOffset

    //End GetterSetterExtension Source Code
//!
}