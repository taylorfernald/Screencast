    package main;
    
    import java.awt.image.BufferedImage;
    import java.util.ArrayList;
    import java.awt.Graphics;
    import java.awt.Color;
    import tokens.*;
    import tiles.*;

    
    public class Map
    {
        private Handler handler;
        private final int SPEED = 10;
        private Color background;
        private BufferedImage bgMap = null;
        private double scale = 11;
        private int width;
        private int height;
        private ArrayList<Token> tokens;
        private int[][] tiles;
        private final int STARTNUM = 100;
        private int sx, sy;
        private boolean r = true;
        //Tokens
        private TokenManager tokenManager;
        
        public Map(Handler handler, String path)
        {
            this.handler = handler;
            tokenManager = new TokenManager(handler);
            
            loadMap(path);
            //System.out.print(Doubler.extend(path));
            
            sx = STARTNUM;
            sy = STARTNUM;
            //Create Players
            tokenManager.addToken(new Figure(handler, "Clansen", mX(), sy, 1, 1, Assets.clansen));
            tokenManager.addToken(new Figure(handler, "Sheyrir", mX(), sy, 1, 1, Assets.sheyrir));
            tokenManager.addToken(new Figure(handler, "Ikthalion", mX(), sy, 1, 1, Assets.ikthalion_spring));
            tokenManager.addToken(new Figure(handler, "Pringle", mX(), sy, 1, 1, Assets.pringle));
            tokenManager.addToken(new Figure(handler, "Tara", mX(), sy, 1, 1, Assets.tara));
            nextRow();
            
            //Create Monsters
            tokenManager.addToken(new Figure(handler, "Silver Dragon", mX(), sy, 2, 2, Assets.silverDragon));
            tokenManager.addToken(new Figure(handler, "Red Dragon", mX(), sy, 2, 2, Assets.redDragon));
            
            nextRow();
            
            //Create Marks
            tokenManager.addToken(new Figure(handler, "Sun", mX(), sy, Assets.sun));
            tokenManager.addToken(new Figure(handler, "Moon", mX(), sy, Assets.moon));
            tokenManager.addToken(new Figure(handler, "Yellow Mark", mX(), sy, Assets.yellowMark));
            tokenManager.addToken(new Figure(handler, "Red Mark",mX(), sy, Assets.redMark));
            tokenManager.addToken(new Figure(handler, "Green Mark", mX(), sy, Assets.greenMark));
            tokenManager.addToken(new Figure(handler, "Blue Mark", mX(), sy, Assets.blueMark));
            
            nextRow();
            
            //Create Dungeon Items
            //tokenManager.addToken(new Figure(handler, "Chest", mX(), sy, Assets.chest));
            //tokenManager.addToken(new Figure(handler, "Door", mX(), sy, Assets.door));
            
        }
        
        public void tick()
        {
            if(handler.getKeyManager().up)
            {
                handler.getGameCamera().move(0, -SPEED);
            }
            if(handler.getKeyManager().down)
            {
                handler.getGameCamera().move(0, SPEED);
            }
            if(handler.getKeyManager().left)
            {
                handler.getGameCamera().move(-SPEED, 0);
            }
            if(handler.getKeyManager().right)
            {
                handler.getGameCamera().move(SPEED, 0);
            }
            if(handler.getKeyManager().zin)
            {
                if (r)
                {
                    Tile.TILEWIDTH *= 2;
                    Tile.TILEHEIGHT *= 2;
                    r = false;
                }
            }
            if(handler.getKeyManager().zout && r)
            {
                if (r)
                {
                    Tile.TILEWIDTH /= 2;
                    Tile.TILEHEIGHT /= 2;
                    r = false;
                }
            }
            if (!handler.getKeyManager().zin && !handler.getKeyManager().zout) {r = true;}
            if (handler.getKeyManager().zhome) {Tile.TILEWIDTH = Tile.BASE; Tile.TILEHEIGHT = Tile.BASE;}
            tokenManager.tick();
            handler.getMouseManager().resetClicks();
        }
        
        public void render(Graphics g)
        {
            g.setColor(background);
            g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
            int xStart = (int) Math.max(0, handler.getGameCamera().getXOffset() /
                Tile.TILEWIDTH);
            int xEnd = (int) Math.min(width, (handler.getGameCamera().getXOffset() + 
                handler.getWidth()) / Tile.TILEWIDTH + 1);
            int yStart = (int) Math.max(0, handler.getGameCamera().getYOffset() /
                Tile.TILEHEIGHT);
            int yEnd = (int) Math.min(height, (handler.getGameCamera().getYOffset() + 
                handler.getHeight()) / Tile.TILEHEIGHT + 1);
            
            for(int y = yStart; y < yEnd; y++)
            {
                for(int x = xStart; x < xEnd; x++)
                {
                    getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getXOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()));
                }
            }
            //draw a grid
            g.setColor(new Color(35, 35, 35));
            for (int i = 0; i <= this.getWidth()*Tile.TILEWIDTH; 
                i += Tile.TILEWIDTH)
            {
                g.drawLine(i - (int) handler.getGameCamera().getXOffset(), 0, i - (int) handler.getGameCamera().getXOffset(), this.getHeight()*
                    Tile.TILEWIDTH);
            }
            for (int i = 0; i <= this.getHeight()*Tile.TILEHEIGHT; 
                i += Tile.TILEHEIGHT)
            {
                g.drawLine(0, i - (int) handler.getGameCamera().getYOffset(), this.getWidth()*
                    Tile.TILEHEIGHT, i - (int) handler.getGameCamera().getYOffset());
            }
            
            //Draw scanned map if there is one
            if (bgMap != null)
            {
                g.drawImage(bgMap, (int) (-handler.getGameCamera().getXOffset()),
                        (int) (-handler.getGameCamera().getYOffset()), handler.getWidth() * (int) (Tile.TILEWIDTH / scale),
                        handler.getHeight() * (int)(Tile.TILEWIDTH / scale), null);
            }
            
            tokenManager.render(g);
        }
        
        public Tile getTile(int x, int y)
        {
            Tile t = Tile.tiles[tiles[x][y]];
            if(t == null)
            {
                return Tile.grassTile;
            }
            return t;
        }
        
        private void loadMap(String path)
        {
            String file = Utils.loadFileAsString(path);
            String[] tokens = file.split("\\s+");
            //Read stuff and apply vars as needed.
            width = Utils.parseInt(tokens[0]);
            height = Utils.parseInt(tokens[1]);
            int r = Utils.parseInt(tokens[2]);
            int b = Utils.parseInt(tokens[3]);
            int g = Utils.parseInt(tokens[4]);
            String flag = tokens[5];
            if (!flag.equals("N"))
            {
                bgMap = ImageLoader.loadImage(tokens[5]);
            }
            background = new Color(r, b, g);
            tiles = new int[width][height];
            for(int y = 0; y < height; y++)
            {
                for(int x = 0; x < width; x++)
                {
                    tiles[x][y] = 
                        Utils.parseInt(tokens[(x + y * width) + 6]);
                }
            }
            int numA = (width * height) + 6;
            int t = Utils.parseInt(tokens[numA]) + 1;
            for(int e = 1; e < t; e++)
            {
                switch (Utils.parseInt(tokens[numA + e]))
                   {
                    /* Left here for syntax help
                     * case 0:
                        tokenManager.addToken(new Figure(handler, mX(), sy, 3, 3, Assets.frostGiant));
                        break;
                    */
                    default:
                        //System.out.println("An id is wrong at Token space " + e + ", it was read as " + Utils.parseInt(tokens[numA + e]));
            }
        }
    }
    
    public int mX()
    {
        int v = sx;
        sx += Tile.TILEWIDTH;
        return v;
    }
    
    public int mY()
    {
        int v = sy;
        sy += Tile.TILEHEIGHT;
        return v;
    }
    
    public void nextRow()
    {
        mY();
        sx = STARTNUM;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie tokenManager*/
    public TokenManager getTokenManager(){
        return this.tokenManager;
    }//end method getTokenManager

    //End GetterSetterExtension Source Code
//!
}