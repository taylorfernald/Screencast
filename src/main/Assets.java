package main;

import java.awt.image.BufferedImage;

public class Assets
{
    
    private static final int cwidth = 400, cheight = 400;
    private static final int width = 16, height = 16;
    
    //Asset imports are done by category
    //PCS
    public static BufferedImage clansen, sheyrir, ikthalion_spring, pringle, tara;
    
    //MONS
    public static BufferedImage silverDragon, redDragon;
    
    //FULL
    public static BufferedImage stone, stoneTL, stoneTR, stoneBL, stoneBR, stoneFloor,
        tree, flower, smallStone, grass, snow, snowTree, snowSStone, snowTent,
        tent, mud, dirt, flagstone1, flagstone2, flagstone3, flagstone4, 
        flagstone5, flagstone6, flagstone7, flagstone8, flagstone9, ocean, 
        wood;   
        
    //Utility
    public static BufferedImage sun, moon, yellowMark, blueMark, redMark,
        greenMark;
        
    //ITEMS
    public static BufferedImage chest, door;
    
    public static void init()
    {
        //PCS
        SpriteSheet pcSheet = new SpriteSheet(ImageLoader.loadImage("res/" 
            + "textures/PARTY.png"));
        clansen = pcSheet.crop(0, 0, cwidth, cheight);
        sheyrir = pcSheet.crop(cwidth, 0, cwidth, cheight);
        ikthalion_spring = pcSheet.crop(cwidth*2, 0, cwidth, cheight);
        pringle = pcSheet.crop(cwidth*3, 0, cwidth, cheight);
        tara = pcSheet.crop(0, cheight, cwidth, cheight);
        //MONS
        SpriteSheet monSheet = new SpriteSheet(ImageLoader.loadImage("res/" 
        + "textures/MONS.png"));
        silverDragon = monSheet.crop(0, 0, width*2, height*2);
        redDragon = monSheet.crop(width*2, 0, width*2, height*2);
        
        //MAT(FULL)
        
        SpriteSheet fullSheet = new SpriteSheet(ImageLoader.loadImage("res/"
            + "textures/MATS.png"));
        stone = fullSheet.crop(0, 0, width, height);
        stoneTL = fullSheet.crop(width, 0, width, height);
        stoneTR = fullSheet.crop(width * 2, 0, width, height);
        stoneBL = fullSheet.crop(width, height, width, height);
        stoneBR = fullSheet.crop(width * 2, height, width, height);
        stoneFloor = fullSheet.crop(width, height * 2, width, height);
        tree = fullSheet.crop(width * 3, 0, width, height);
        flower = fullSheet.crop(width * 3, height, width, height);
        smallStone = fullSheet.crop(0, height * 2, width, height);
        grass = fullSheet.crop(0, height, width, height);
        
        snow = fullSheet.crop(width * 2, height * 2, width, height);
        snowTree = fullSheet.crop(width * 3, height * 2, width, height);
        snowSStone = fullSheet.crop(0, height * 3, width, height);
        snowTent = fullSheet.crop(width, height * 3, width, height);
        tent = fullSheet.crop(width * 2, height * 3, width, height);
        mud = fullSheet.crop(width * 3, height * 3, width, height);
        dirt = fullSheet.crop(0, height * 4, width, height);
        flagstone1 = fullSheet.crop(width, height * 4, width, height);
        flagstone2 = fullSheet.crop(width * 2, height * 4, width, height);
        flagstone3 = fullSheet.crop(width * 3, height * 4, width, height);
        flagstone4 = fullSheet.crop(0, height * 5, width, height);
        flagstone5 = fullSheet.crop(width, height * 5, width, height);
        flagstone6 = fullSheet.crop(width * 2, height * 5, width, height);
        flagstone7 = fullSheet.crop(width * 3, height * 5, width, height);
        flagstone8 = fullSheet.crop(0, height * 6, width, height);
        flagstone9 = fullSheet.crop(width, height * 6, width, height);
        
        ocean = fullSheet.crop(width * 2, height * 6, width, height);
        wood = fullSheet.crop(width * 3, height * 6, width, height);
        
        //UTILS
        SpriteSheet utilSheet = new SpriteSheet(ImageLoader.loadImage("res/"
            + "textures/MARKS.png"));
        sun = utilSheet.crop(0, 0, width, height);
        moon = utilSheet.crop(width, 0, width, height);
        yellowMark = utilSheet.crop(width * 2, 0, width, height);
        blueMark = utilSheet.crop(0, height, width, height);
        redMark = utilSheet.crop(width, height, width, height);
        greenMark = utilSheet.crop(width * 2, height, width, height);
        
        //ITEMS
        SpriteSheet itemSheet = new SpriteSheet(ImageLoader.loadImage("res/"
            + "textures/ITEMS.png"));
        chest = itemSheet.crop(0, 0, width, height);
        door = itemSheet.crop(width, 0, width, height);
        
    }
}