package Runtime;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame{

    public static final String GAME_NAME = "The Lost Packet";
    
    public Game(String name)
    {
        super(name);
        //initialize all levels here 
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
    }
    
    public static void main(String[] args)
    {
        try{
            AppGameContainer app = new AppGameContainer(new Game(GAME_NAME));
            app.setDisplayMode(1024, 768, false);
            app.setShowFPS(false);
            app.setVSync(true);
            app.setTargetFrameRate(60);
            app.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }
}
