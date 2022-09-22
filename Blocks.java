
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

public class Blocks implements GameObject
{
	Graphics graphics;
	public int speed = 10;
	public boolean[][] block = new boolean[5][10];
	public Rectangle rect = new Rectangle();
	Blocks()
	{
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 10; j++)
				block[i][j] = true;
			rect.w = 126;
			rect.h = 10;
	}
	
	public void render(Graphics graphics)
	{
		rect.x = rect.y = 0;
		this.graphics = graphics;
		graphics.setColor(Color.white);
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(block[i][j])
				{
					graphics.fillRect(rect.x,rect.y,rect.w,rect.h);
				}
				rect.x += 130;
			}
			rect.y += 15;
				rect.x = 0;
		}
	}

	public void update(Game game)
	{
		game.blocksCollision();
	}

	public Rectangle getRectangle()
	{
		return rect;
	} 
}