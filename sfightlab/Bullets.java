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

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
    ammo = new ArrayList<Ammo>();
  }

  public void add(Ammo al)
  {
    ammo.add(al);
  }

  //post - draw each Ammo
  public void drawEmAll( Graphics window )
  {
    for(Ammo a: ammo)
    {
      a.draw(window);
    }
  }

  public void moveEmAll(String direction)
  {
    for(Ammo a: ammo)
    {
      a.move(direction);
    }
  }

  public void cleanEmUp()
  {
    for(int i = 0; i < ammo.size(); i++)
    {
      if(ammo.get(i).getY() > 600 || ammo.get(i).getY() < 0)
      {
        ammo.remove(i);
      }
    }
  }

  public void hit(Ammo a)
  {
    a.setPos(-100,-100);
    ammo.remove(a);
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public int getSize()
  {
    return ammo.size();
  }

  public Ammo getAmmo(int index)
  {
    if(ammo.size() > 0)
      return ammo.get(index);
    return null;
  }

  public String toString()
  {
    return "";
  }
}
