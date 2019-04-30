//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed = 3;
  private int ySpeed = 1;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int x, int y)
  {
    super(x, y);
  }

  public Ball(int xs, int ys, int xp, int yp)
  {
    super(xs, ys, xp, yp);
  }

  public Ball(int xs, int ys, int xp, int yp, Color color)
  {
    super(xs, ys, xp, yp, color);
  }
  
  public Ball(int x, int y, int xp, int yp, int xs, int ys)
  {
    super(x,y,xp,yp);
    xSpeed = xs;
    ySpeed = ys;
  }
  public Ball(int x, int y, int w, int h, Color color, int xs, int ys)
  {
    super(x, y, w, h, color);
    xSpeed = xs;
    ySpeed = ys;
  }
  //add the set methods
  public void setXSpeed(int s)
  {
      xSpeed = s;
  }
  public void setYSpeed(int s)
  {
      ySpeed = s;
  }
  public boolean didCollideLeft(Object b)
  {
    Block block = (Block)b;
    return( Math.abs( getLeftBorder() - block.getRightBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
  }  
  public boolean didCollideRight(Object b)
  {
    Block block = (Block)b;
    return(Math.abs( getRightBorder() - block.getLeftBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
  }
  public boolean didCollideTop(Object b)
  {
    Block block = (Block)b;
    return( Math.abs( getTopBorder() - block.getBottomBorder()) < Math.abs(getYSpeed()) );
  }  
  public boolean didCollideBottom(Object b)
  {
    Block block = (Block)b;
    return( Math.abs( getBottomBorder() - block.getTopBorder()) < Math.abs(getYSpeed()) );
  }
   

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.BLACK);
    //setX
    setX(getX() + xSpeed);
    //setY
    setY(getY() + ySpeed);
    //draw the ball at its new location
    draw(window);
  }
   
  public boolean equals(Object obj)
  {
    Ball ball = (Ball)obj;
    return super.equals(ball) && xSpeed == ball.xSpeed && ySpeed == ball.ySpeed; 
  }   

  //add the get methods
  public int getXSpeed()
  {
    return xSpeed;
  }
  public int getYSpeed()
  {
      return ySpeed;
  }

  //add a toString() method
  public String toString()
  {
      return "" + xSpeed + " " + ySpeed + " " + super.toString();
  }
}