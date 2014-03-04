package Engine;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;

public class Player implements Entity{

    private Vector2f position;
    private Rectangle rect;
    private float width, height;
    private int health;
    private int currentFrame;
    private int totalFrame;
    private int row;
    private SpriteSheet masterSprite;
    private Image masterImage;
    private float time;
    private float timeOfLastFrameChange;
    
    public Player(Vector2f pos, float w, float h, int health)
    {
        setPos(pos);
        setWidth(w);
        setHeight(h);
        setupRect(pos, w, h);
        setHealth(health);
    }
    
    public void setupSpriteSheet(SpriteSheet sprite)
    {
        int d = getRow();
        masterSprite = sprite;
        masterImage = masterSprite.getSprite(currentFrame, d);
    }
    
    public void updateSpriteSheet(int delta)
    {
        time += (float)delta/1000;
        if(time > timeOfLastFrameChange + 0.1f)
        {
            timeOfLastFrameChange = time;
            nextFrame();
        }
    }
    
    public void nextFrame()
    {
        currentFrame++;
        if(currentFrame > totalFrame - 1 )
        {
            currentFrame = 0;
        }
        int d = getRow();
        masterImage = masterSprite.getSprite(currentFrame, d);
    }
    
    @Override
    public void setPos(Vector2f pos) {
        position = pos;
    }

    @Override
    public void setWidth(float w) {
        width = w;
    }

    @Override
    public void setHeight(float h) {
        height = h;
    }

    @Override
    public void setupRect(Vector2f pos, float w, float h) {
        rect = new Rectangle(pos.x, pos.y, w, h);
    }
    
    public void setHealth(int h)
    {
        this.health = h;
    }
    
    public void setRow(int r)
    {
        row = r;
    }
    
    public void update(GameContainer gc, int delta)
    {
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_A))
        {
            //move left
            position.x -= 0.25f * delta;
            rect.setX(position.getX());
        }
        
        if(input.isKeyDown(Input.KEY_D))
        {
            //move right
            position.x += 0.25f * delta;
            rect.setX(position.getX());
        }
        
        if(input.isKeyDown(Input.KEY_W))
        {
            position.y -= 0.25f * delta;
            rect.setY(position.y);
        }
        
        if(input.isKeyDown(Input.KEY_S))
        {
            position.y += 0.25f * delta;
            rect.setY(position.y);
        }
    }

    @Override
    public Vector2f getVector() {
        return position;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public boolean hasIntersected(Rectangle other)
    {
        if(other.intersects(this.rect))
        {
            return true;
        }else{
            return false;
        }
    }
}
