import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

class Alien2 extends Alien
{
    private Image image;
    private Bullets bullets = new Bullets();
  
    public Alien2()
    {
      super(0,0,30,30,1,0);
      setType(1);
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
      setType(1);
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
      setType(1);
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
      setType(1);
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
    
    public void draw(Graphics window)
    {
      window.drawImage(image,getX(),getY(),getWidth(),getHeight(), null);
    }

    public String toString()
    {
      return "";
    }
  }
  