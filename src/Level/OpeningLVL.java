package Level;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.geom.Vector2f;

import Engine.*;

public class OpeningLVL extends BasicGameState {
    
    Player ptest;
    
    public OpeningLVL(int id)
    {
    
    }
    
    public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
    {
        //initialize Game Objects here
        ptest = new Player(new Vector2f(32, 32), 64, 64, 100);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException
    {
        //update code here
        ptest.update(gc, delta);
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException
    {
        g.draw(ptest.getRect());
    }
    
    public int getID()
    {
        return 0;
    }
}
