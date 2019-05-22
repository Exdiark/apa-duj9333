//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private int size;
  private int xPos;
  private int yPos;
  private List<Alien> aliens;
  private String direction = "RIGHT";

  public AlienHorde(int s)
  {
    aliens = new ArrayList<Alien>();
    size = s;
    xPos = 20;
    yPos = 20; 
  }

  public AlienHorde(int s, int x, int y)
  {
    aliens = new ArrayList<Alien>();
    size = s;
    xPos = x;
    yPos = y;
  }

  public void setDirection(String dir)
  {
    direction = dir;
  }

  public String getDirection()
  {
    return direction;
  }

  public void add(Alien al)
  {
    aliens.add(al.copy());
    aliens.get(aliens.size() - 1).setPos(getXPos() + 60 * aliens.size(), getYPos());
  }
  
  public void fillHorde(Alien a)
  {
	  for(int i = 0; i < 8; i++)
	  {
		  aliens.add(a.copy());
		  aliens.get(i).setPos(xPos + 60 * i, yPos);
	  }
  }

  public void drawEmAll( Graphics window )
  {
    for(Alien a:aliens)
    {
      a.draw(window);
    }
  }
  
  public void moveEmAll(String direction)
  {
	for(Alien a: aliens)
	{
		if(direction.equals("LEFT"))
		  a.setX(a.getX() - a.getXSpeed());
		if(direction.equals("RIGHT"))
	      a.setX(a.getX() + a.getXSpeed());
		if(direction.equals("UP"))
		  a.setY(a.getY() - a.getYSpeed());
		if(direction.equals("DOWN"))
		  a.setY(a.getY() + a.getYSpeed());
	}
  }
  
  public void moveEmAll(String direction, int dist)
  {
	for(Alien a: aliens)
	{
		if(direction.equals("LEFT"))
			  a.setX(a.getX() - dist);
			if(direction.equals("RIGHT"))
		      a.setX(a.getX() + dist);
			if(direction.equals("UP"))
			  a.setY(a.getY() - dist);
			if(direction.equals("DOWN"))
			  a.setY(a.getY() + dist);
	}
  }
  
  public void moveBullets()
  {
	  for(Alien a: aliens)
	  {
		  a.moveBullets();
	  }
  }
  
  public void moveEmAll()
  {
    for(Alien a: aliens)
    {
      a.move();
    }
  }
  
  public void switchXDir()
  {
	  for(Alien a: aliens)
	  {
		  a.wallBounce();
	  }
  }
  
  public boolean detectWallCollision()
  {
	  if(aliens.size() > 0)
	  {
		  return aliens.get(aliens.size() - 1).getX() + aliens.get(aliens.size() - 1).getWidth() > 800 || aliens.get(0).getX() < 0;
	  }
	  return false;
  }

  public int getTotalWidth()
  {
    return aliens.size() * 60 - 10;
  }
  
  public int getXPos()
  {
	  return xPos;
  }
  
  public int getYPos()
  {
	  return yPos;
  }

  public void kill(Alien a)
  {
    a.setPos(-100,-100);
    aliens.remove(a);
  }

  public List<Alien> getAliens()
  {
    return aliens;
  }

  public Alien getAlien(int index)
  {
    if(aliens.size() > 0)
      return aliens.get(index);
    return null;
  }

  public void bigShoot()
  {
    for(Alien a:aliens)
    {
      if(a.getType() == 0)
    	  a.shoot();
    }
  }
  
  public void drawBullets(Graphics window)
  {
	  for(Alien alien: aliens)
	  {
		  alien.drawBullets(window);
	  }
  }

  public int getSize()  
  {
    return aliens.size();
  }

  public String toString()
  {
    return "";
  }
}
