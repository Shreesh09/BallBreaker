import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public interface GameObject
{
	//Call every time physically possible.
	public void render(Graphics graphics);

	//Call at 60 fps rate.
	public void update(Game game);
	public Rectangle getRectangle();
}