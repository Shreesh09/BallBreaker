
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
// Java program for sin() method
import java.util.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.lang.Runnable;
import java.lang.Thread;

import javax.swing.JFrame;



public class Game extends JFrame implements Runnable
{
	private Canvas canvas = new Canvas();
	private KeyBoardListener keyListener = new KeyBoardListener();
	private GameObject[] objects;
	private player player;
	private Ball ball;
	private Blocks blocks;
	
	public Game()
	{
		//Makes our program shut down when exit out.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set the position and size of our frame.
        setBounds(0,0,1360,800);
        
        //Put our frame in the centre of the screen.
        setLocationRelativeTo(null);
        
        //Adds canvas.B
        add(canvas);
       
        //Make our frame visible.
        setVisible(true); 
       
        //Create our object for Bufferstrategy.
        canvas.createBufferStrategy(3);    

        //Add Listeners.
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);
        objects = new GameObject[3];
        player = new player();
        objects[0] = player;
        ball = new Ball();
		objects[1] = ball;
		blocks = new Blocks();
		objects[2] = blocks;

        player.rect.x = 1360/2;
		player.rect.y = 790; 
		ball.rect.x = 1360/2;
		ball.rect.y = 400;

	}

 	public void update() 
    {
    	for(int i = 0; i < objects.length; i++)
    		objects[i].update(this);
    }

	public void render()
    {
    	BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        bufferStrategy = canvas.getBufferStrategy();
    	 
         Graphics graphics = bufferStrategy.getDrawGraphics();
	     super.paint(graphics);
	     
         //Repainting the bakground.
	     graphics.setColor(Color.black);
	     graphics.fillRect(0,0,getWidth(),getHeight());
         
         for(int i = 0; i < objects.length; i++)
    		objects[i].render(graphics);

         graphics.dispose();
         bufferStrategy.show();
    }
	public void run()
    {
    	BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        long lastTime =System.nanoTime(); //long=2^63;
        double nanoSecondConversion =1000000000.0/60.0; //60 frames per second
        double changeInseconds=0.0;  
        while(true)
        {
        	long now=System.nanoTime();
        	changeInseconds += (now-lastTime)/nanoSecondConversion;
        	while(changeInseconds >= 1)
        	{
             update();
             changeInseconds=0;
              
        	}
        	render();
        	lastTime=now;
        }
    }

    public KeyBoardListener getKeyListener()
    {
    	return keyListener;
    }

    public boolean playerCollision()
    {
    	return(collision(objects[0].getRectangle(), objects[1].getRectangle()));
    }

    public void blocksCollision()
    {
    	Rectangle rect = blocks.getRectangle();
    	rect.x = rect.y = 0;
    	for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(collision(rect, ball.getRectangle()) && blocks.block[i][j])
				{
					blocks.block[i][j] = false;
					ball.blockCollision();
				}
				rect.x += 130;
			}
			rect.y += 15;
			rect.x = 0;
		}
    }
    public boolean collision(Rectangle r1, Rectangle r2)
    {
    	boolean collision = true;
    
    	if(!(r1.x < r2.x + r2.w && (r1.x + r1.w) > r2.x && r1.y < r2.y + r2.h && r1.y + r1.h > r2.y))
    		collision = false;
    		
    	return collision;
    }
	public static void main(String[] args) 
	{	
		Game game = new Game();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
}