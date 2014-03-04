package Engine;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.geom.Rectangle;

public interface Entity {
    //set values
    public void setPos(Vector2f pos);
    public void setWidth(float w);
    public void setHeight(float h);
    public void setupRect(Vector2f pos, float w, float h);
    
    //get values
    public Vector2f getVector();
    public float getWidth();
    public float getHeight();
    public Rectangle getRect();
}
