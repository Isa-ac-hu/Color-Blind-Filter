import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Point;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	
	int leftOrRight;
	
	private int red = 200;
	private int green = 200;
	private int blue = 200;
	private boolean increaseRed = true;
	private boolean increaseBlue = true;
	private boolean increaseGreen = true;
	
	double angle = 0;
	double speed = 8.0;

	double dx = 0.0;
	double dy = 0.0;
	
	private int iterator = 0;

	
	private Ellipse2D.Double circle; 
	
	public Ball(int x, int y, int d)
	{
		circle = new Ellipse2D.Double(0,0,d,d);
		this.setSize(d + 1,d + 1); //this is exclusive at d, we want it to be inclusive, so d + 1
		this.setLocation(x,y);
		leftOrRight = (int)(Math.random()*2);
		
		if(leftOrRight == 0)
		{
			angle = 0 + (int)(Math.random()*100 - 50);
		}
		if(leftOrRight == 1)
		{
			angle = 180 + (int)(Math.random()*100 - 50);
		}
		dx = speed*Math.cos(Math.toRadians(angle));
		dy = speed*Math.sin(Math.toRadians(angle));
	}

	public void setDx(int x)
	{
		dx = x;
	}
	public void setDy(int y)
	{
		dy = y;
	}
	public int getDy()
	{
		return (int)dy;
	}
	
	public void xCollided()
	{
		dx = -dx;
	}
	public void yCollided()
	{
		dy = -dy;
	}

	public void update()
	{
		iterator ++;
		setLocation(getX() + (int)dx, getY() + (int)dy);

	}
	public void paintComponent(Graphics g)
	{
		
		
		
		if(iterator == 5)
		{
			iterator = 0;
			//red
			if(red <= 225 && red >= 0)
			{
				if(increaseRed)
				{
					red += (int)(Math.random()*10);
				}
				else if(!increaseRed)
				{
					red -= (int)(Math.random()*10);
				}
			}
			else if (red < 0)
			{
				red += 10;
				increaseRed = true;
			}
			else if(red > 225)
			{
				red -= 10;
				red -= (int)(Math.random()*10);
				increaseRed = false;
			}
			//blue
			
			if(blue <= 225 && blue >= 0)
			{
				if(increaseBlue)
				{
					blue += (int)(Math.random()*10);
				}
				else if(!increaseRed)
				{
					blue -= (int)(Math.random()*10);
				}
			}
			else if (blue < 0)
			{
				blue += 10;
				increaseBlue = true;
			}
			else if(blue > 225)
			{
				blue -= 10;
				blue -= (int)(Math.random()*10);
				increaseBlue = false;
			}
			
			//green
			
			if(green <= 225 && green >= 0)
			{
				if(increaseGreen)
				{
					green += (int)(Math.random()*10);
				}
				else if(!increaseGreen)
				{
					green -= (int)(Math.random()*10);
				}
			}
			else if (green < 0)
			{
				green += 10;
				increaseGreen = true;
			}
			else if(green > 225)
			{
				green -= 10;
				green -= (int)(Math.random()*10);
				increaseGreen = false;
			}
		}
		Color customColor = new Color(red, green, blue);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(customColor);
		g2.fill(circle);

	}
		



}
