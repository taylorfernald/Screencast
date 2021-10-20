package main;

public class Handler
{
    private Tabletop table;
    private Map map;
    
    public Handler(Tabletop table)
    {
        this.table = table;
    }

    public GameCamera getGameCamera()
    {
        return table.getGameCamera();
    }
    
    public KeyManager getKeyManager()
    {
        return table.getKeyManager();
    }
    
    public MouseManager getMouseManager()
    {
        return table.getMouseManager();
    }
    
    public int getWidth()
    {
        return table.getWidth();
    }
    
    public int getHeight()
    {
        return table.getHeight();
    }
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie table*/
    public Tabletop getTable(){
        return this.table;
    }//end method getTable

    /**SET Method Propertie table*/
    public void setTable(Tabletop table){
        this.table = table;
    }//end method setTable

    /**GET Method Propertie map*/
    public Map getMap(){
        return this.map;
    }//end method getMap

    /**SET Method Propertie map*/
    public void setMap(Map map){
        this.map = map;
    }//end method setMap

    //End GetterSetterExtension Source Code
//!
}