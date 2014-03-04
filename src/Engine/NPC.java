package Engine;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class NPC implements Entity{

    private Vector2f position;
    private Rectangle rect;
    private float width, height;
    private int health;
    
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
        rect = new Rectangle(pos.getX(), pos.getY(), w, h);
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
