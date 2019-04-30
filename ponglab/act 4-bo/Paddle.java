//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block implements Collidable
{
  //instance variables
  private int speed = 10;

  public Paddle()
  {
    super();
  }
  //add the other Paddle constructors

  public Paddle(int x, int y)
  {
    super(x,y);
  }
  public Paddle(int x, int y, int s)
  {
    super(x,y);
    speed = s;
  }
  public Paddle(int x, int y, int w, int h)
  {
    super(x,y,w,h);
  }
  public Paddle(int x, int y, int w, int h, int s)
  {
    super(x,y,w,h);
    speed = s;
  }
  public Paddle(int x, int y, int w, int h, Color c)
  {
    super(x,y,w,h,c);
  }
  public Paddle(int x, int y, int w, int h, Color c, int s)
  {
    super(x,y,w,h,c);
    speed = s;
  }


  public void moveLeftAndDraw(Graphics window)
  {
    draw(window, Color.BLACK);
    setX(getX() - speed);
    draw(window);
  }

  public void moveRightAndDraw(Graphics window)
  {
    draw(window, Color.BLACK);
    setX(getX() + speed);
    draw(window);
  }

  public boolean didCollideTop(Object b)
  {
    Block block = (Block)b;
    return( Math.abs( getTopBorder() - block.getBottomBorder()) < Math.abs(getSpeed()) );
  }  
  public boolean didCollideBottom(Object b)
  {
    Block block = (Block)b;
    return( Math.abs( getBottomBorder() - block.getTopBorder()) < Math.abs(getSpeed()) );
  }
  public boolean didCollideLeft(Object b)
  {
    return false;
  }  
  public boolean didCollideRight(Object b)
  {
    return false;
  }

  //add get methods
  public int getSpeed()
  {
    return speed;
  }
   
  //add a toString() method
  public String toString()
  {
    return "" + speed + " " + super.toString();
  }
}