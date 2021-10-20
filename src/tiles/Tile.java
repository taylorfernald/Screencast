package tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import main.*;

public class Tile
{
    //STATIC STUFF HERE
    public static Tile[] tiles = new Tile[256];
    //Organized by row in the sprite sheet.
    public static Tile stoneTile = new StoneTile(0);
    public static Tile stoneTLTile = new StoneTLTile(1);
    public static Tile stoneTRTile = new StoneTRTile(2);
    public static Tile treeTile = new TreeTile(3);
    
    public static Tile grassTile = new GrassTile(4);
    public static Tile stoneBLTile = new StoneBLTile(5);
    public static Tile stoneBRTile = new StoneBRTile(6);
    public static Tile flowerTile = new FlowerTile(7);
    
    public static Tile smallStoneTile = new SmallStoneTile(8);
    public static Tile stoneFloorTile = new StoneFloorTile(9);
    
    public static Tile snowTile = new SnowTile(10);
    public static Tile snowTree = new SnowTreeTile(11);
    public static Tile snowSStoneTile = new SnowSStoneTile(12);
    public static Tile snowTent = new SnowTentTile(13);
    public static Tile tent = new TentTile(14);
    
    public static Tile dirt = new DirtTile(15);
    public static Tile mud = new MudTile(16);
    
    public static Tile flagstone1 = new Flagstone1Tile(17);
    public static Tile flagstone2 = new Flagstone2Tile(18);
    public static Tile flagstone3 = new Flagstone3Tile(19);
    public static Tile flagstone4 = new Flagstone4Tile(20);
    public static Tile flagstone5 = new Flagstone5Tile(21);
    public static Tile flagstone6 = new Flagstone6Tile(22);
    public static Tile flagstone7 = new Flagstone7Tile(23);
    public static Tile flagstone8 = new Flagstone8Tile(24);
    public static Tile flagstone9 = new Flagstone9Tile(25);
    
    public static Tile oceanTile = new OceanTile(26);
    public static Tile woodTile = new WoodTile(27);
    
    //CLASS
    
    //The physical size of tiles in screen pixels, along with its base values.
    public static final int BASE = 128;
    public static int TILEWIDTH = BASE, TILEHEIGHT = BASE;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g, int x,int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public int getId()
    {
        return id;
    }
}