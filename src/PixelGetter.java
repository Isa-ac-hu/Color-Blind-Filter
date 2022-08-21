import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;

public class PixelGetter 
{
	private FileWriter writer = null;
	private File file = null;
	private BufferedImage img;
	private ArrayList<Color> colors = new ArrayList<Color>();
	private ArrayList<Color> existingColors = new ArrayList<Color>();
	private int resolutionInt;
	
	private int rows = 0;
	private int columns = 0;
	int iterator = 0;
	
	public PixelGetter(File fileName, int resolution)
	{
		resolutionInt = resolution;
		try
		{
			writer = new FileWriter("pixel_values.txt");
		}
	    catch (IOException e) 
	    {
	        System.out.println("Looks like an error has been detected.");
	        e.printStackTrace();
	    }
		
		//Reading the image
		file = fileName;
		img = null;
		try 
		{
			img = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("File not found");
		}
		
		for (int x = 0; x < img.getWidth()-resolution; x+= resolution) 
		{
			rows = 0;
			for (int y = 0; y < img.getHeight()-resolution; y += resolution) 
		    {
				
				//Retrieving contents of a pixel
		        int pixel = img.getRGB(x,y);
		        //Creating a Color object from pixel value
		        Color color = new Color(pixel, true);
		        //Retrieving the R G B values
		        int red = color.getRed();
		        int green = color.getGreen();
		        int blue = color.getBlue();
		        
		        
		        Color newColor = new Color(red, green, blue);
		        colors.add(newColor);
		        if((red < 200 && green < 200 & blue < 200) && !existingColor(newColor) && (green > red))
		        {
			        try
			        {
			        	writer.append("new Color(");
				        writer.append(red+", ");
				        writer.append(green+", ");
				        writer.append(blue+"), ");
				        writer.append("\n");
				        iterator++;
				        writer.flush();
			        }
			        catch(IOException e)
			        {
			        	
			        }
			        existingColors.add(newColor);
		        }
		       
		    }
		}
			
		try 
		{
			writer.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RGB values at each pixel are stored in the specified file");
		
		
	}
	public int getImgHeight()
	{
		return img.getHeight();
	}
	public int getImgWidth()
	{
		return img.getWidth();
	}
	public ArrayList<Color> getColors()
	{
		return colors;
	}
	public int getResolution()
	{
		return resolutionInt;
	}
	public boolean existingColor(Color color)
	{
		for(Color c : existingColors)
		{
			if(color.equals(c))
			{
				return true;
			}
			else if(color.getRed() == c.getRed())
			{
				return true;
			}
			else if(color.getGreen() == c.getGreen())
			{
				return true;
			}
		}
		return false;
	}
	
//	public int getRows()
//	{
//		return rows;
//	}
//	public int getColumns()
//	{
//		return columns;
//	}
	
}
	