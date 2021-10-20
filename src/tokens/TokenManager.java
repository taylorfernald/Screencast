package tokens;

import java.util.ArrayList;
import java.awt.Graphics;
import main.*;

public class TokenManager
{
    private Handler handler;
    private ArrayList<Token> tokens;
    
    public TokenManager(Handler handler)
    {
        this.handler = handler;
        tokens = new ArrayList<Token>();
    }
    
    public void tick()
    {
        for(int i = 0; i < tokens.size(); i++)
        {
            Token e = tokens.get(i);
            e.tick();
            if (!e.isActive())
            {
                tokens.remove(e);
            }
        }
    }
    
    public void render(Graphics g)
    {
        for(Token e: tokens)
        {
            e.render(g);
        }
    }

    public void addToken(Token e)
    {
        tokens.add(e);
    }
    
    //Start GetterSetterExtension Source Code
    /**GET Method Propertie handler*/
    public Handler getHandler(){
        return this.handler;
    }//end method getHandler

    /**SET Method Propertie handler*/
    public void setHandler(Handler handler){
        this.handler = handler;
    }//end method setHandler

    /**GET Method Propertie tokens*/
    public java.util.ArrayList<Token> getTokens(){
        return this.tokens;
    }//end method getTokens

    /**SET Method Propertie tokens*/
    public void setTokens(java.util.ArrayList<Token> tokens){
        this.tokens = tokens;
    }//end method setTokens

    //End GetterSetterExtension Source Code
//!
}