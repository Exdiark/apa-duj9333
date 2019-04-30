import java.awt.Color;
import java.util.Arrays;

class BrickField
{
    private Brick[][] bricks;

    public BrickField()
    {
    }

    public BrickField(int sw, int sh, int bw, int bh)
    {
        int blockX = 0;
        int blockY = 2 * bh;

        bricks = new Brick[sw / 60][sh /2 / 20];

        for(int i = 0; i < bricks.length - 2; i++)
        {
            blockX = (sw - bricks.length * 60) / 2;





            
            for(int j = 0; j < bricks[i].length - 2; j++)
            {
                bricks[j][i] = new Brick( blockX, blockY, bw, bh, randomColor() );
                blockX += bw;
            }
            blockY += bh;
        }
    }

    public Brick[][] getBricks()
    {
        return bricks;
    }

    public boolean win()
    {
        boolean won = true;
        for(Brick[] a: bricks)
            for(Brick b: a)
                if(b.getState())
                    won = false;
        return won;
    }

    public Color randomColor()
    {
        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        return new Color(r,g,b);
    }
}
