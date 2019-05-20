import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

class Aliens
{
    private List<AlienHorde> aliens;

    public Aliens()
    {
        aliens = new ArrayList<AlienHorde>();
    }

    public void addRandomWave()
    {
    	int rand = (int)(Math.random() * 2);
    	AlienHorde horde = new AlienHorde(8, 20, 20 + 60 * getNbrRows());
    	if(rand == 0)
    	{
    		horde.fillHorde(new Alien());
    	}
    	else
    	{
    		horde.fillHorde(new Alien2());
    	}
    	aliens.add(horde);
    }

    public void addWave(AlienHorde horde)
    {
        aliens.add(horde);
    }

    public void drawAll(Graphics window)
    {
        for(AlienHorde horde: aliens)
        {
            horde.drawEmAll(window);
        }
    }

    public void moveAll()
    {
        for(AlienHorde horde: aliens)
        {
            horde.moveEmAll();
        }
    }

    public void fire()
    {
        for(AlienHorde horde: aliens)
        {
            horde.bigShoot();
        }
    }

    public void clearDeadWaves()
    {
        for(int i = aliens.size() - 1; i >= 0; i--)
        {
            if(aliens.get(i).getSize() <= 0)
            {
                aliens.remove(i);
            }
        }
    }
    
    public void updateWallCollisions()
    {
    	for(AlienHorde horde: aliens)
    	{
    		if(horde.detectWallCollision())
    		{
    			horde.switchXDir();
    			horde.moveEmAll("DOWN", 100);
    		}
    	}
    }

    public List<AlienHorde> getHordes()
    {
        return aliens;
    }

    public ArrayList<Ammo> getAllEnemyBullets()
    {
        ArrayList help = new ArrayList<Ammo>();
        for(AlienHorde horde: aliens)
        {
            for(Alien alien: horde.getAliens())
            {
                for(Ammo ammo: alien.getClip().getList())
                {
                    help.add(ammo);
                }
            }
        }
        return help;
    }
    
    public void drawAllBullets(Graphics window)
    {
    	for(AlienHorde horde: aliens)
    	{
    		horde.drawBullets(window);
    	}
    }
    
    public void moveAllBullets()
    {
    	for(AlienHorde horde: aliens)
    	{
    		horde.moveBullets();
    	}
    }

    public int getNbrRows()
    {
        return aliens.size();
    }
}