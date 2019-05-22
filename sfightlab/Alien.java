//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private Image image;
  private String direction = "RIGHT";
  private Bullets bullets = new Bullets();
  private int type = 0;

  public Alien()
  {
    super(0,0,30,30,1,0);
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public Alien(int x, int y)
  {
	super(x,y,30,30,1,0);
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public Alien(int x, int y, int w, int h)
  {
    super(x, y, w, h, 1, 0);
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }
  
  public Alien(int x, int y, int w, int h, int xs, int ys)
  {
	  super(x,y,w,h,xs,ys);
	  try
	  {
	    URL url = getClass().getResource("alien.jpg");
	    image = ImageIO.read(url);
	  }
	  catch(Exception e)
	  {
	    //feel free to do something here
	  }
  }
  
  public Alien copy()
  {
	  return new Alien(getX(),getY(),getWidth(), getHeight(), getXSpeed(), getYSpeed());
  }

  public void setDirection(String dir)
  {
    direction = dir;
  }

  public void wallBounce()
  {
    setXSpeed(getXSpeed() * -1);
  }

  public void shoot()
  {
    int rand;
    rand = (int)(Math.random() * 2000);
    if(rand == 0)
      bullets.add(new Ammo(getX() + getWidth() / 2, getY(), 0, 5, Color.RED));
  }

  public Bullets getClip()
  {
    return bullets;
  }
  
  public void move(String dir)
  {
    if(dir.equals("LEFT"))
    {
      setX(getX() - getXSpeed());
    }
    if(dir.equals("RIGHT"))
    {
      setX(getX() + getXSpeed());
    }
    if(dir.equals("UP"))
    {
      setY(getY() - getYSpeed());
    }
    if(dir.equals("DOWN"))
    {
      setY(getY() + getYSpeed());
    }
  }

  public void draw(Graphics window)
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(), null);
  }
  
  public void drawBullets(Graphics window)
  {
	  window.setColor(Color.RED);
	  for(Ammo a: bullets.getList())
	  {
		  window.fillRect(a.getX(), a.getY(), a.getWidth(), a.getHeight());
	  }
  }
  
  public void moveBullets()
  {
	  for(Ammo a: bullets.getList())
	  {
		  a.move();
	  }
  }
  
  public int getType()
  {
	  return type;
  }
  
  public void setType(int a)
  {
	  type = a;
  }

  public String toString()
  {
    return "";
  }
}
