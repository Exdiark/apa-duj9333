//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

  //constructors
  public BlinkyBall()
  {
    super();
  }

  public BlinkyBall(int x, int y)
  {
    super(x,y);
  }

  public BlinkyBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht);
  }

  public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,xSpd,ySpd);
  }

  public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col, xSpd, ySpd);
  }

  public boolean didCollideLeft(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getLeftBorder() - block.getRightBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
    if(collide)
      setColor(randomColor());
    return collide;
  }  
  public boolean didCollideRight(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = (Math.abs( getRightBorder() - block.getLeftBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
    if(collide)
      setColor(randomColor());
    return collide;
  }
  public boolean didCollideTop(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getTopBorder() - block.getBottomBorder()) < Math.abs(getYSpeed()) );
    if(collide)
      setColor(randomColor());
    return collide;
  }  
  public boolean didCollideBottom(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getBottomBorder() - block.getTopBorder()) < Math.abs(getYSpeed()) );
    if(collide)
      setColor(randomColor());
    return collide;
  }

  public Color randomColor()
  {
    int r = (int)(Math.random() * 255);		//use Math.random()
    int g = (int)(Math.random() * 255);
    int b = (int)(Math.random() * 255);
    return new Color(r,g,b);
  }
}