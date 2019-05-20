//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
  private int speed;
  private Image image;
  private Ammo ammo;
  private Bullets bullets = new Bullets();
  private int fDelay = 0;

  public Ship()
  {
    this(10,10,100,100,10);
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public Ship(int x, int y)
  {
    super(x,y);
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public Ship(int x, int y, int s)
  {
    super(x,y);
    speed = s;
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public Ship(int x, int y, int w, int h)
  {
    super(x,y,w,h);
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
    speed = 5;
  }

  public Ship(int x, int y, int w, int h, int s)
  {
    super(x, y, w, h);
    speed=s;
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setAmmo(Ammo a)
  {
    ammo = a;
  }

  public Ammo getAmmo()
  {
    return ammo;
  }

  public void move(String direction)
  {
    if(direction.equals("LEFT"))
      setX(getX() - getSpeed());
    if(direction.equals("RIGHT"))
      setX(getX() + getSpeed());
    if(direction.equals("UP"))
      setY(getY() - getSpeed());
    if(direction.equals("DOWN"))
      setY(getY() + getSpeed());
  }

  public void shoot()
  {
    if(fDelay == 0)
    {
      bullets.add(new Ammo(getX() + getWidth() / 2, getY(), 0, -5));
      fDelay = 25;
    }
  }

  public void checkAlienKill(Aliens a)
  {
    for(AlienHorde horde: a.getHordes())
    {
      for(int j = horde.getAliens().size() - 1; j >= 0; j--)
      {
        for(int i = getClipSize() - 1; i >= 0; i--)
        {
          if(bullets.getList().get(i).detectCollision(horde.getAliens().get(j)))
          {
            horde.kill(horde.getAliens().get(j));
            bullets.hit(bullets.getList().get(i));
          }
        }
      }
    }
  }

  public boolean dead(Aliens aliens)
  {
    for(Ammo ammo: aliens.getAllEnemyBullets())
    {
      if(detectCollision(ammo))
        return true;
    }
    return false;
  }

  public Bullets getClip()
  {
    return bullets;
  }

  public int getClipSize()
  {
    return bullets.getSize();
  }

  public void drawBullets(Graphics window)
  {
    bullets.drawEmAll(window);
  }
  
  public void moveBullets()
  {
	  for(Ammo a: bullets.getList())
	  {
		  a.move();
	  }
  }
  
  public void delayTickDown()
  {
    if(fDelay != 0)
    {
      fDelay--;
    }
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
