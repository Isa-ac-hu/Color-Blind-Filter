import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;

public class JComponentConstruct extends JComponent
{
	private int index = 0;
	private Scanner read;
	private PixelGetter image = null;
	
	private int red;
	private int green;
	private int blue;
	private Color customColor;
	private int average;
	
	private int rows;
	private int columns;
	
	private ArrayList<Color> colors = null;
	
	private int resolution;	
	private int quantityOfRed = 0;
	private int redPixels = 0;
	
	private String typeOfModification = null;	
	private int lightChange = 0;	
	private boolean circleHere = false;
	
	Color[] reds = {new Color(197, 141, 116), new Color(192, 138, 112), new Color(188, 140, 117), 
			new Color(199, 137, 114), new Color(190, 116, 91), new Color(194, 131, 100), 
			new Color(193, 127, 101), new Color(196, 130, 108), new Color(198, 128, 103), 
			new Color(187, 122, 104), new Color(195, 124, 106), new Color(180, 107, 74), 
			new Color(177, 126, 105), new Color(179, 104, 72), new Color(191, 121, 85), 
			new Color(189, 118, 88), new Color(186, 125, 96), new Color(182, 109, 77), 
			new Color(181, 98, 66), new Color(185, 111, 76), new Color(184, 110, 81), 
			new Color(183, 123, 99), new Color(175, 108, 79), new Color(178, 103, 71), 
			new Color(174, 105, 76), new Color(173, 117, 90), new Color(170, 114, 89), 
			new Color(172, 170, 95), new Color(176, 175, 85), new Color(164, 162, 87), 
			new Color(167, 166, 86), new Color(165, 164, 99), new Color(166, 165, 85), 
			new Color(171, 169, 86), new Color(168, 167, 87), new Color(169, 168, 85), 
			new Color(161, 160, 80), new Color(160, 158, 81), new Color(159, 157, 82), 
			new Color(162, 161, 71), new Color(157, 156, 99)};

	Color[] greens = {new Color(176, 184, 137), new Color(189, 196, 154), new Color(177, 185, 134),
			new Color(172, 181, 124), new Color(183, 193, 132), new Color(180, 188, 139), 
			new Color(186, 192, 154), new Color(173, 182, 129), new Color(178, 189, 121), 
			new Color(170, 180, 127), new Color(184, 194, 134), new Color(168, 178, 115), 
			new Color(181, 191, 128), new Color(174, 186, 124), new Color(179, 187, 136), 
			new Color(185, 195, 132), new Color(190, 197, 156), new Color(169, 179, 116), 
			new Color(158, 170, 150), new Color(145, 157, 133), new Color(142, 156, 130), 
			new Color(146, 160, 135), new Color(153, 166, 148), new Color(182, 183, 107), 
			new Color(156, 168, 146), new Color(149, 164, 135), new Color(141, 158, 124), 
			new Color(135, 151, 124), new Color(133, 149, 123), new Color(198, 199, 141), 
			new Color(129, 142, 116), new Color(138, 155, 121), new Color(137, 153, 127), 
			new Color(139, 152, 134), new Color(164, 172, 161), new Color(191, 198, 154),
			new Color(147, 162, 133), new Color(148, 159, 143), new Color(144, 154, 129), 
			new Color(132, 146, 120), new Color(175, 176, 100), new Color(150, 167, 133), 
			new Color(140, 148, 135), new Color(161, 169, 156), new Color(118, 130, 110), 
			new Color(163, 171, 156), new Color(136, 150, 125), new Color(154, 165, 148), 
			new Color(130, 144, 121), new Color(165, 177, 153), new Color(155, 161, 147), 
			new Color(187, 190, 85), new Color(128, 140, 118), new Color(131, 143, 123), 
			new Color(151, 163, 139), new Color(171, 175, 91), new Color(167, 173, 159), 
			new Color(162, 174, 152), new Color(127, 141, 115), new Color(134, 145, 128), 
			new Color(124, 136, 116), new Color(123, 138, 109), new Color(120, 134, 111), 
			new Color(125, 139, 116), new Color(126, 135, 114), new Color(121, 133, 113), 
			new Color(114, 126, 106), new Color(116, 129, 111), new Color(119, 131, 107)};
	
	public JComponentConstruct(String fileName, int resolution, String modification, int degreeOfChange) throws FileNotFoundException
	{
		
		image = new PixelGetter(new File(fileName), resolution);
		
		this.setSize(image.getImgWidth(), image.getImgHeight());
		this.setLocation(0,0);
		this.resolution = resolution;
		colors = image.getColors();
		typeOfModification = modification;
		lightChange = degreeOfChange;
	
	}

	
	public void paintComponent(Graphics g)
	{
	
		Graphics2D g2 = (Graphics2D) g;
	
		for(int i = 0; i < image.getImgWidth() - resolution; i+=resolution)
		{
			columns = i;
			for(int j = 0; j < image.getImgHeight() - resolution; j+=resolution)
			{
				g2.setColor(colors.get(index));
				
				if(typeOfModification.equals("turnToBlackAndWhite"))
					turnToBlackAndWhite();
				else if(typeOfModification.equals("redGreenColorBlind"))		
					redGreenColorBlind();
				else if(typeOfModification.equals("changeLighting"))
					changeLighting(lightChange);
				else if(typeOfModification.equals("randomStatic"))
					randomStatic(Math.abs(lightChange));
				g2.setColor(customColor);

				g2.fill(new Rectangle2D.Double(i,j,resolution,resolution));
				index++;
				rows = j;
				
			}
		}
	}
	public int getHeight()
	{
		return image.getImgHeight();
	}
	public int getWidth()
	{
		return image.getImgWidth();
	}
	public void redGreenColorBlind()
	{	
		red = colors.get(index).getRed();
		green = colors.get(index).getGreen();
		blue = colors.get(index).getBlue();

		int randomSelection = (int)(Math.random()*100);
		
		
		if(rows % 3 == 0 && columns % 3 == 0)
		{
			if(randomSelection < 50)
			{			
				blue = 10;
				green = 10;
				
				lightenDarkerColors(55);
				changeLighting(50);
				customColor = new Color(red, green, blue);
				
				quantityOfRed += customColor.getRed();
				redPixels++;
			}
			else
			{
				customColor = greens[(int)(Math.random()*greens.length)];
				
				red = (int)(Math.random()*255);
				green = customColor.getGreen();
				blue = customColor.getBlue();
				
				changeLighting(55);
				blue = 100;		
				customColor = new Color(red, green, blue);
				
			}
			
		}
		else if(randomSelection<40)
		{
			customColor = greens[(int)(Math.random()*greens.length)];
			
			red = colors.get(index).getRed();
			green = customColor.getGreen();
			blue = customColor.getBlue();
			blue = 100;		
			changeLighting(20);
			customColor = new Color(red, green, blue);
		}
//		else
//		{
//			blue = 10;
//			green = 10;
//				
//			lightenDarkerColors(35);
//			changeLighting(50);
//			customColor = new Color(red, green, blue);
//				
//			quantityOfRed += customColor.getRed();
//			redPixels++;
//			
//		}
		if(red < 145 && green < 145)
		{
			customColor = greens[(int)(Math.random()*greens.length)];
			
			red = (int)(Math.random()*255);
			green = customColor.getGreen() + (colors.get(index).getGreen()/40);
			blue = colors.get(index).getGreen();
			
			changeLighting(50);
			blue = 100;		
			customColor = new Color(red, green, blue);
			
		}
		
	}

	public void turnToBlackAndWhite()
	{
		red = colors.get(index).getRed();
		green = colors.get(index).getGreen();
		blue = colors.get(index).getBlue();
		average = (red + green + blue)/3;
		customColor = new Color(average, average, average);
		
	}
	
	public void makeLighter(int brightness)
	{

		for(int i = 0; i < brightness; i++)
		{
			if(red < 255)
				red++;
			if(green < 255)
				green++;
			if(blue < 255)
				blue++;
		}
		customColor = new Color(red, green, blue);
	}
	public void makeDarker(int darkness)
	{

		for(int i = 0; i < darkness; i++)
		{
			if(red > 0)
				red--;
			if(green > 0)
				green--;
			if(blue > 0)
				blue--;
		}
		customColor = new Color(red, green, blue);
	}
	public void changeLighting(int levelChange)
	{
		if(levelChange > 0)
		{
			for(int i = 0; i < levelChange; i++)
			{
				if(red < 255)
					red++;
				if(green < 255)
					green++;
				if(blue < 255)
					blue++;
			}
		}
		else if(levelChange < 0)
		{
			for(int i = levelChange; i < 0; i++)
			{
				if(red > 0)
					red--;
				if(green > 0)
					green--;
				if(blue > 0)
					blue--;
			}
		}
		customColor = new Color(red, green, blue);
	}
	public void lightenDarkerColors(int increase)
	{
		if(red < 150 && green < 150 && blue < 150)
		{
			red += increase;
			green += increase;
			blue += increase;
		}
	}
	public void randomStatic(int staticLevel)
	{
		int randomSelection = (int)(Math.random()*100);
		
				
		if(staticLevel > randomSelection)
			customColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		else
			customColor = colors.get(index);

	}
	public void consistentStatic(int staticLevel)
	{
		if(index%staticLevel == 0)
		{
			customColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		}
		else
		{
			customColor = colors.get(index);
		}
	}
	public void swapRedAndGreen()
	{
		red = colors.get(index).getGreen();
		green = colors.get(index).getRed();
		blue = colors.get(index).getBlue();
		
		blue = 0;
		
		if(index%2 == 0)
		{
			red = 0;
		}
		else
		{
			green = 0;
		}
		
		customColor = new Color(red, green, blue);
	}

	

	
}
