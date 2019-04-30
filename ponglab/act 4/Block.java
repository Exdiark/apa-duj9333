//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos = 10;
  private int yPos = 10;
  private int width = 10;
  private int height = 10;

  private Color color = Color.BLACK;

  public Block()
  {
  }

  //add other Block constructors - x , y , width, height, color
  public Block(int x, int y, int w, int h)
  {
      xPos = x;
      yPos = y;
      width = w;
      height = h;
  }
  public Block(int x, int y, int w, int h, Color c)
  {
      xPos = x;
      yPos = y;
      width = w;
      height = h;
      color = c;
  }
  public Block(int x, int y)
  {
      xPos = x;
      yPos = y;
  }
  //add the other set methods
  public void setX(int x)
  {
      xPos = x;
  }
  public void setY(int y)
  {
      yPos = y;
  }
  public void setPos(int x, int y)
  {
      xPos = x;
      yPos = y;
  }
  public void setWidth(int w)
  {
      width = w;
  }
  public void setHeight(int h)
  {
      height = h;
  }  
  public void setColor(Color col)
  {
      color = col;  
      
  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Block block = (Block)obj;
    return xPos == block.xPos && yPos == block.yPos && height == block.height && width == block.width && color.equals(block.color);
  }   

  //add the other get methods
  public int getX()
  {
      return xPos;
  }
  public int getY()
  {
      return yPos;
  }
  public int getHeight()
  {
      return height;
  }
  public int getWidth()
  {
      return width;
  }
  public int getTopBorder()
  {
      return yPos;
  }
  public int getBottomBorder()
  {
      return yPos + height;
  }
  public int getLeftBorder()
  {
      return xPos;
  }
  public int getRightBorder()
  {
      return xPos + width;
  }
  public Color getColor()
  {
      return color;
  }
    

  //add a toString() method  - x , y , width, height, color
  public String toString()
  {
      return "" + xPos + " " + yPos + " " + width + " " + height + " " + color;
  }
}