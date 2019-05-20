//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private Color color = Color.YELLOW;

  public Ammo()
  {
    super(0,0,10,10);
    color = Color.YELLOW;
  }

  public Ammo(int x, int y)
  {
    super(x,y,10,10);
    color = Color.YELLOW;
  }

  public Ammo(int x, int y, Color c)
  {
    super(x,y);
    color = c;
  }

  public Ammo(int x, int y, int s)
  {
    super(x,y,10,10);
    color = Color.YELLOW;
  }
  
  public Ammo(int x, int y, int xs, int ys)
  {
	  super(x,y,10,10,xs,ys);
  }
  
  public Ammo(int x, int y, int xs, int ys, Color col) 
  {
	  super(x,y,10,10,xs,ys);
	  color = col;
  }

public void setColor(Color col)
  {
    color = col;
  }
  
  public Color getColor()
  {
    return color;
  }

  public void draw( Graphics window )
  {
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
        
  public void move( String direction )
  {
    if(direction.equals("LEFT"))
      setX(getX() - getXSpeed());
    if(direction.equals("RIGHT"))
      setX(getX() + getXSpeed());
    if(direction.equals("UP"))
      setY(getY() - getYSpeed());
    if(direction.equals("DOWN"))
      setY(getY() + getYSpeed());
  }
  
  public void move()
  {
	  setX(getX() + getXSpeed());
	  setY(getY() + getYSpeed());
  }

  public String toString()
  {
    return "";
  }
}
