import java.awt.Color;

class Brick extends Block
{
    private boolean state = true;

    public Brick(int x, int y, int w, int h)
    {
      super(x,y,w,h);
    }
    public Brick(int x, int y, int w, int h, Color c)
    {
      super(x,y,w,h);
    }
    public Brick(int x, int y)
    {
      super(x,y);
    }

    public void destroy()
    {
        state = false; 
    }

    public boolean getState()
    {
        return state;
    }

    public String toString()
    {
        return "" + super.toString() + getState();
    }
}