
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

public class player implements GameObject
{
	Graphics graphics;
	public int speed = 15;
	public Rectangle rect = new Rectangle();
	player()
	{
		rect.w = 100;
		rect.h = 10;
	}
	
	public void render(Graphics graphics)
	{
		this.graphics = graphics;
		graphics.setColor(Color.white);
		graphics.fillRect(rect.x,rect.y,rect.w,rect.h);
	}

	public void update(Game game)
	{
		KeyBoardListener keyListener = game.getKeyListener();

		if(keyListener.up())
			rect.y -= speed;
		if(keyListener.down())
			rect.y += speed;
		if(keyListener.left())
			rect.x -= speed;
		if(keyListener.right())
			rect.x += speed;
	}

	public Rectangle getRectangle()
	{
		return rect;
	} 
}