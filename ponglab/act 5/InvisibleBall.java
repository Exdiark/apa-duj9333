import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class InvisibleBall extends Ball
{
  private boolean invisible;
  
  public InvisibleBall()
  {
    super();
  }

  public InvisibleBall(int x, int y)
  {
    super(x,y);
  }

  public InvisibleBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht);
  }

  public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,xSpd,ySpd);
  }

  public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col, xSpd, ySpd);
  }

  public void moveAndDraw(Graphics window)
  {
    draw(window, Color.BLACK);
    setX(getX() + getXSpeed());
    setY(getY() + getYSpeed());
    int random = (int)(100 * Math.random());
    if(!invisible)
        if(random == 0)
        {
            setColor(Color.BLACK);
            invisible = true;
        }
    else
    {
        setColor(Color.WHITE);
        invisible = false;
    }
  }
}