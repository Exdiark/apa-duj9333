//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

  //instance variables

  public SpeedUpBall()
  {
    super();
  }

  public SpeedUpBall(int x, int y)
  {
    super(x,y);
  }

  public SpeedUpBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht);
  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,xSpd,ySpd);
  }

  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col, xSpd, ySpd);
  }

  public boolean didCollideLeft(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getLeftBorder() - block.getRightBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
    if(collide)
      speedUp();
    return collide;
  }  
  public boolean didCollideRight(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = (Math.abs( getRightBorder() - block.getLeftBorder()) < Math.abs(getXSpeed()) && getBottomBorder() > block.getTopBorder() && getTopBorder() < block.getBottomBorder());
    if(collide)
      speedUp();
    return collide;
  }
  public boolean didCollideTop(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getTopBorder() - block.getBottomBorder()) < Math.abs(getYSpeed()) );
    if(collide)
      speedUp();
    return collide;
  }  
  public boolean didCollideBottom(Object b)
  {
    boolean collide;
    Block block = (Block)b;
    collide = ( Math.abs( getBottomBorder() - block.getTopBorder()) < Math.abs(getYSpeed()) );
    if(collide)
      speedUp();
    return collide;
  }

  public void speedUp()
  {
    setXSpeed((int)(getXSpeed() * 1.5));
    setYSpeed((int)(getYSpeed() * 1.5));
  }
}

