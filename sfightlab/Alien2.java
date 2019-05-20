import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

class Alien2 extends Alien
{
    private Image image;
    private String direction = "RIGHT";
    private Bullets bullets = new Bullets();
    private boolean alive = true;
  
    public Alien2()
    {
      super(0,0,30,30,1,0);
      try
      {
        URL url = getClass().getResource("alien2.jpg");
        image = ImageIO.read(url);
      }
      catch(Exception e)
      {
        //feel free to do something here
      }
    }
  
    public Alien2(int x, int y)
    {
      super(x,y,30,30,1,0);
      try
      {
        URL url = getClass().getResource("alien2.jpg");
        image = ImageIO.read(url);
      }
      catch(Exception e)
      {
        //feel free to do something here
      }
    }
  
    public Alien2(int x, int y, int w, int h)
    {
      super(x,y,w,h,1,0);
      try
      {
        URL url = getClass().getResource("alien2.jpg");
        image = ImageIO.read(url);
      }
      catch(Exception e)
      {
        //feel free to do something here
      }
    }
    
    public Alien2(int x, int y, int w, int h, int xs, int ys)
    {
      super(x,y,w,h,xs,ys);
      try
      {
        URL url = getClass().getResource("alien2.jpg");
        image = ImageIO.read(url);
      }
      catch(Exception e)
      {
        //feel free to do something here
      }
    }
  
    public Alien2 copy()
    {
  	  return new Alien2(getX(),getY(),getWidth(), getHeight(), getXSpeed(), getYSpeed());
    }
    
    public void shoot()
    {
      int rand;
      rand = (int)(Math.random() * 2000);
      if(rand == 0)
      {
        bullets.add(new Ammo(getX() + getWidth() / 2, getY(), 0, 5, Color.RED));
        bullets.add(new Ammo(getX() + getWidth() / 4, getY(), 0, 5, Color.RED));
        bullets.add(new Ammo(getX() + 3 * getWidth() / 4, getY(), 0, 5, Color.RED));
      }
    }
  
    public Bullets getClip()
    {
      return bullets;
    }

    public void move(String direction)
    {
      if(direction.equals("LEFT"))
      {
        setX(getX() - getXSpeed());
      }
      if(direction.equals("RIGHT"))
      {
        setX(getX() + getXSpeed());
      }
      if(direction.equals("UP"))
      {
        setY(getY() - getYSpeed());
      }
      if(direction.equals("DOWN"))
      {
        setY(getY() + getYSpeed());
      }
    }
  
    public void move()
    {
    	setX(getX() + getXSpeed());
    	setY(getY() + getYSpeed());
    }
  
    public void kill()
    {
      alive = false;
    }
  
    public Boolean isAlive()
    {
      return alive;
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
  