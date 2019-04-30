//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int xs, int ys)
  {
    super(200, 200);
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
   

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window);
    //setX
    setX(getX() + xSpeed);
    //setY
    setY(getY() + ySpeed);
    //draw the ball at its new location
    draw(window);
  }
   
  public boolean equals(Object obj)
  {
    Ball ball = obj;
    return obj == this;
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