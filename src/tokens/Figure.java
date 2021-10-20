package tokens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.*;
import tiles.Tile;

public class Figure extends Creature {
    
    private BufferedImage texture;
    
    public Figure(Handler handler, String name, float x, float y, BufferedImage texture) {
        super(handler, name, x, y, Tile.TILEWIDTH, 
            Tile.TILEWIDTH);
        this.texture = texture;
    }
    
    public Figure(Handler handler, String name, float x, float y, int w, int h, BufferedImage texture) {
        super(handler, name, x, y, Tile.TILEWIDTH * w, 
            Tile.TILEHEIGHT * h);
        this.texture = texture;
    }
    
    public Figure(Figure f)
    {
        super(f.handler, f.name, f.x, f.y, f.width, f.height);
        this.texture = f.texture;
    }
    
    public void tick()
    {
        getInput();
        inputForCopy();
        move();      
    }
    
    public void render(Graphics g)
    {
        g.setFont(g.getFont().deriveFont(20f));
        g.drawImage(texture, (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), getWidth(), getHeight(), null);
        g.setColor(new Color(255, 255, 255, 100));
        if (pointWithinReach(handler.getMouseManager().getMouseX(), 
                handler.getMouseManager().getMouseY(), 
                getRange()))
        {
                g.fillRect((int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), getRange(), getRange());
                g.setColor(Color.BLACK);
                g.drawString(name, (int) (x - handler.getGameCamera().getXOffset()), (int) (y + 20 - handler.getGameCamera().getYOffset()));
                //g.drawString("AC " + ac, (int) (x - handler.getGameCamera().getXOffset()), (int) (y + 40 - handler.getGameCamera().getYOffset()));
        }
    }
    
    public void inputForCopy()
    {
        boolean withinReach = pointWithinReach(handler.getMouseManager().getMouseX(), 
                handler.getMouseManager().getMouseY(), 
                getRange());
        
        if (handler.getMouseManager().isRightClicked() && withinReach)
        {
            Figure copy = new Figure(this);
            handler.getMap().getTokenManager().addToken(copy);
            handler.getMouseManager().resetClicks();
        }
    }
}