
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

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.File;

public class Ball implements GameObject
{
	int t = 10, r = 10;
	Graphics graphics;
	public Rectangle rect = new Rectangle();
	Ball()
	{
		rect.w = 50;
		rect.h = 50;
	}
	
	public void render(Graphics graphics)
	{
		this.graphics = graphics;
		graphics.setColor(Color.red);
		graphics.fillOval(rect.x,rect.y,rect.w,rect.h);
	}

	public void update(Game game)
	{
		if(rect.x < 0)
    	{
    		//m += 3.14/2.0;
    		t = 10;
    	}
    	if(rect.x > 1360)
    	{
    		//m += 3.14/2.0;
    		t = -10;
    	}
    	if(rect.y < 0)
    	{
    		//m += 3.14/2.0;
    		r = 10;
    	}
    	if(rect.y > 800)
    	{
    		rect.x = 1360/2;
    		rect.y = 400;
   		}
    	//m = 3.14*1.5;

    	if(game.playerCollision())
    		r = -10;

    	rect.x = rect.x + t;

        rect.y = rect.y + r;
	}
	public Rectangle getRectangle()
	{
		return rect;
	} 

	public void blockCollision()
	{
		r = 10;
	}
}