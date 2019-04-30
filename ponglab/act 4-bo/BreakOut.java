//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class BreakOut extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle paddle;
  private Wall topWall;
  private Wall bottomWall;
  private Wall leftWall;
  private Wall rightWall;
  private boolean[] keys;
  private BufferedImage back;
  private BrickField field;
  private Score score;
  private int width;
  private int height;

  public BreakOut(int w, int h)
  {
    //set up all variables related to the game
    width = w - 14;
    height = h - 37;
    field = new BrickField(width, height, 40, 20);

    ball = new Ball(width/2, 3*height/4, 10, 10, Color.WHITE, 1, 3 );
    paddle = new Paddle(width / 2, 9 * height / 10, 120, 10, Color.WHITE, 5);
    topWall = new Wall(0, 0, 800, 10, Color.WHITE);
    bottomWall = new Wall(0, height - 10, 800, 10, Color.WHITE);
    leftWall = new Wall(0, 0, 10, 600, Color.WHITE);
    rightWall = new Wall(width - 10, 0, 10, 600, Color.WHITE);
    score = new Score();

    keys = new boolean[2];
    
    setBackground(Color.BLACK);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);
  }
	
  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();
    ball.moveAndDraw(graphToBack);
    paddle.draw(graphToBack);
    topWall.draw(graphToBack);
    bottomWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    leftWall.draw(graphToBack);

    for(Brick[] b: field.getBricks())
    {
      for(Brick a: b)
      {
        if(a.getState())
        {
          a.draw(graphToBack, Color.WHITE);
        }
      }
    }

    //see if ball hits left wall or right wall
    if(ball.didCollideRight(rightWall))
    {
      ball.setXSpeed(ball.getXSpeed() * (-1)); 
    }
    if(ball.didCollideLeft(leftWall))
    {
      ball.setXSpeed(ball.getXSpeed() * (-1)); 
    }

    //see if the ball hits the top or bottom wall 
    if(ball.didCollideTop(topWall))
    {
      ball.setYSpeed(ball.getYSpeed() * (-1)); 
    }

    if(ball.didCollideBottom(bottomWall))
    {
      ball = new Ball(width/2, 3*height/4, 10, 10, Color.WHITE, 3, -1 );
      score.reset();
    }

    for(Brick[] b: field.getBricks())
    {
      for(Brick a: b)
      {
        if(a.getState())
        {
          if(ball.didCollideBottom(a))
          {
            ball.setYSpeed(ball.getYSpeed() * (-1));
            a.destroy();
          }
          if(ball.didCollideLeft(a))
          {
            ball.setXSpeed(ball.getXSpeed() * (-1));
            a.destroy();
          }
          if(ball.didCollideRight(a))
          {
            ball.setXSpeed(ball.getXSpeed() * (-1));
            a.destroy();
          }
          if(ball.didCollideTop(a))
          {
            ball.setYSpeed(ball.getYSpeed() * (-1));
            a.destroy();
          }
        }
      }
    }

    //see if the ball hits the right paddle
    if(ball.didCollideBottom(paddle))
    {
      ball.setYSpeed(ball.getYSpeed() * (-1));
    }

    //see if the paddles need to be moved

    if (keys[0] && !(paddle.didCollideLeft(leftWall)))
    {
      paddle.moveLeftAndDraw(graphToBack);
    }
    if (keys[1] && !(paddle.didCollideRight(rightWall)))
    {
      paddle.moveRightAndDraw(graphToBack);
    }
    twoDGraph.drawImage(back, null, 0, 0);
    }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'A' : keys[0]=true; break;
    case 'D' : keys[1]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'A' : keys[0]=false; break;
    case 'D' : keys[1]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	      Thread.currentThread().sleep(8);
	      repaint();
      }
    }
    catch(Exception e)
    {

    }
  }	
}