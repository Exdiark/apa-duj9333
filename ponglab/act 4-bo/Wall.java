import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;

class Wall extends Block
{
    private int bottomBorder;
    private int topBorder;

    public Wall()
    {
        super();
    }

    public Wall(int x, int y, int w, int h)
    {
        super(x,y,w,h);
        topBorder = y;
        bottomBorder = y + h;
    }
    
    public Wall(int x, int y, int w, int h, Color c)
    {
        super(x,y,w,h,c);
        topBorder = y;
        bottomBorder = y + h;
    }

    public int getTopBorder()
    {
        return topBorder;
    }

    public int getBottomBorder()
    {
        return bottomBorder;
    }
}