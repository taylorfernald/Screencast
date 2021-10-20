package tokens;

import main.*;
import tiles.Tile;

public abstract class Creature extends Token
{
    public static final int DEFAULT_AC = 10;
    public static final int DEFAULT_PP = 10;
    public static final int DEFAULT_SP = 30;
    
    protected String name;
    protected int ac;
    protected int pp;
    protected int sp;
    
    public Creature(Handler handler, String name, float x, float y, int width, int height)
    {
        super(handler, x, y, width, height);
        this.name = name;
        ac = DEFAULT_AC;
        pp = DEFAULT_PP;
        sp = DEFAULT_SP;
        
    }
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie ac*/
    public int getAc(){
        return this.ac;
    }//end method getAc

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie pp*/
    public int getPp(){
        return this.pp;
    }//end method getPp

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**GET Method Propertie sp*/
    public int getSp(){
        return this.sp;
    }//end method getSp

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**SET Method Propertie ac*/
    public void setAc(int ac){
        this.ac = ac;
    }//end method setAc

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**SET Method Propertie pp*/
    public void setPp(int pp){
        this.pp = pp;
    }//end method setPp

    //End GetterSetterExtension Source Code
//!

    //Start GetterSetterExtension Source Code
    /**SET Method Propertie sp*/
    public void setSp(int sp){
        this.sp = sp;
    }//end method setSp

    //End GetterSetterExtension Source Code
//!
}