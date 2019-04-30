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

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private Wall topWall;
  private Wall bottomWall;
  private Wall leftWall;
  private Wall rightWall;
  private boolean[] keys;
  private BufferedImage back;
  private Score p1;
  private Score p2;
  private int width;
  private int height;

  public Pong()
  {
  }

  public Pong(int w, int h)
  {
    //set up all variables related to the game
    width = w - 14;
    height = h - 37;
    ball = new Ball(width/2, height/2, 10, 10, Color.WHITE, 3, 1 );
    leftPaddle = new Paddle(30, height/2, 10, 60, Color.WHITE, 5);
    rightPaddle = new Paddle(width - 40, height/2, 10, 60, Color.WHITE, 5);
    topWall = new Wall(0, 0, 800, 20, Color.WHITE);
    bottomWall = new Wall(0, height - 20, 800, 20, Color.WHITE);
    leftWall = new Wall(0, 20, 10, 600, Color.WHITE);
    rightWall = new Wall(width - 10, 20, 10, 600, Color.WHITE);
    

    p1 = new Score();
    p2 = new Score();


    keys = new boolean[4];
    
    setBackground(Color.BLACK);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);

  }
	
  public void update(Graphics window){
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
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    topWall.draw(graphToBack);
    bottomWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    leftWall.draw(graphToBack);

    //see if ball hits left wall or right wall
    if(ball.didCollideRight(rightWall))
    {
      ball.setXSpeed(0);
      ball.setYSpeed(0);
      ball.draw(graphToBack, Color.BLACK);
      p1.increment();
      p1.printScore(width / 4 , height / 4, graphToBack);
      p2.printScore(3 * width / 4, height / 4 , graphToBack);
      ball = new Ball(400, 300, 10, 10, Color.WHITE, 3, 1 );
    }
    if(ball.didCollideLeft(leftWall))
    {
      ball.setXSpeed(0);
      ball.setYSpeed(0);
      ball.draw(graphToBack, Color.BLACK);
      p2.increment();
      p1.printScore(width / 4 , height / 4, graphToBack);
      p2.printScore(3 * width / 4, height / 4 , graphToBack);
      ball = new Ball(400, 300, 10, 10, Color.WHITE, 3, 1 );
    }
    //see if the ball hits the top or bottom wall 
    if(ball.didCollideTop(topWall) || ball.didCollideBottom(bottomWall))
    {
      ball.setYSpeed(ball.getYSpeed() * (-1)); 
    }
    //see if the ball hits the left paddle
    if(ball.didCollideLeft(leftPaddle))
    {
      ball.setXSpeed(ball.getXSpeed() * (-1));
    }
    //see if the ball hits the right paddle
    if(ball.didCollideRight(rightPaddle))
    {
      ball.setXSpeed(ball.getXSpeed() * (-1));
    }
    //see if the paddles need to be moved

    if (keys[0] && !(leftPaddle.didCollideTop(topWall)))
    {
      leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1] && !(leftPaddle.didCollideBottom(bottomWall)))
    {
      leftPaddle.moveDownAndDraw(graphToBack);
    }
    if (keys[2] && !(rightPaddle.didCollideTop(topWall)))
    {
      rightPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[3] && !(rightPaddle.didCollideBottom(bottomWall)))
    {
      rightPaddle.moveDownAndDraw(graphToBack);
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
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