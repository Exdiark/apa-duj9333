//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private int xSpeed;
  private int ySpeed;

  public MovingThing()
  {
    xPos = 10;
    yPos = 10;
    width = 10;
    height = 10;
    xSpeed = 0;
    ySpeed = 0;
  }

  public MovingThing(int x, int y)
  {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
    xSpeed = 0;
    ySpeed = 0;
  }

  public MovingThing(int x, int y, int w, int h)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    xSpeed = 0;
    ySpeed = 0;
  }
  
  public MovingThing(int x, int y, int w, int h, int xs, int ys)
  {
	  xPos = x;
	  yPos = y;
	  width = w;
	  height = h;
	  xSpeed = xs;
	  ySpeed = ys;
  }

  public void setPos( int x, int y)
  {
    xPos = x;
    yPos = y;
  }

  public void setX(int x)
  {
    xPos = x;
  }

  public void setY(int y)
  {
    yPos = y;
  }
  
  public void setXSpeed(int xs)
  {
	  xSpeed = xs;
  }
  
  public void setYSpeed(int ys)
  {
	  ySpeed = ys;
  }

  public int getX()
  {
    return xPos;
  }

  public int getY()
  {
    return yPos;
  }
  
  public int getXSpeed()
  {
	  return xSpeed;
  }
  
  public int getYSpeed()
  {
	  return ySpeed;
  }

  public int getXCenter()
  {
    return xPos + width / 2; 
  }

  public int getYCenter()
  {
    return yPos + height / 2;
  }

  public void setWidth(int w)
  {
    width = w;
  }

  public void setHeight(int h)
  {
    height = h;
  }
  
  public int getWidth()
  {
    return width;  
  }

  public int getHeight()
  {
    return width;
  }

  public boolean detectCollision(Object a)
  {
    MovingThing thing = (MovingThing)a;
    return Math.abs(thing.getXCenter() - getXCenter())  < (getWidth() / 2 + thing.getWidth() / 2) && Math.abs(thing.getYCenter() - getYCenter()) < (getHeight() / 2 + thing.getHeight() / 2);
  }

  public void move()
  {
	  setX(getX() + getXSpeed());
	  setY(getY() + getYSpeed());
  }
  
  public abstract void draw(Graphics window);

  public String toString()
  {
    return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
  }
}