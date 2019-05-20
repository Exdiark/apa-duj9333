import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import com.sun.jdi.connect.Connector.BooleanArgument;

public class Alien3 extends Alien
{   
    private int speed;
    private Image image;
    private Bullets bullets = new Bullets();

  public Alien3()
  {
    this(0,0,30,30,0);
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

  public Alien3(int x, int y)
  {
    super(x,y);
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

  public Alien3(int x, int y, int s)
  {
    super(x,y);
    speed = s;
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

  public Alien3(int x, int y, int w, int h)
  {
    super(x, y, w,h);
    speed = 2;
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

  public Alien3(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
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
  
  public Alien3 copy()
  {
	  return new Alien3(getX(),getY(),getWidth(), getHeight(), getSpeed());
  }
  
  public void wallBounce()
  {
  }

  public void shoot()
  {
    int rand;
    rand = (int)(Math.random() * 2000);
    if(rand == 0)
      bullets.add(new Ammo(getX() + getWidth() / 2, getY(), Color.RED));
  }

  public Bullets getClip()
  {
    return bullets;
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move()
  {
    setX(getX() + getSpeed());
    setY(500 - (int)Math.pow(getX() - 400, 2));
  }

  public void move(String dir)
  {
    if(dir.equals("LEFT"))
    {
      setX(getX() - getSpeed());
    }
    if(dir.equals("RIGHT"))
    {
      setX(getX() + getSpeed());
    }
    if(dir.equals("UP"))
    {
      setY(getY() - getSpeed());
    }
    if(dir.equals("DOWN"))
    {
      setY(getY() + getSpeed());
    }
  }

  public void draw(Graphics window)
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return "";
  }
}
