import java.awt.Graphics;
import java.awt.Color;

class Score
{
    private int score;

    public Score()
    {
        score = 0;
    }

    public void increment()
    {
        score++;
    }

    public void reset()
    {
        score = 0;
    }

    public void printScore(int x, int y, Graphics window)
    {
        window.setColor(Color.BLACK);
        window.fillRect(x, y, 40, 40);
        window.setColor(Color.WHITE);
        window.drawString("" + score, x, y);
    }
}