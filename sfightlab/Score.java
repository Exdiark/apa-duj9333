import java.awt.Color;
import java.awt.Graphics;

class Score
{
    private int score;

    public Score()
    {
        score = 0;
    }

    public void increment(int value)
    {
        score += value;
    }

    public void reset()
    {
        score = 0;
    }

    public void drawScore(Graphics window)
    {
        window.setColor(Color.WHITE);
        window.drawString("" + score, 350, 50);
    }
}