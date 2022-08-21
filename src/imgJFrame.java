import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class imgJFrame extends JFrame
{
	private JComponentConstruct image;
	
	public imgJFrame(String fileName, int resolution, String modification, int degreeOfChange)
	{		
		setTitle("Isaac's Image Host");
		
		image = null;
		try 
		{
			image = new JComponentConstruct(fileName, resolution, modification, degreeOfChange);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(image);
		this.setBounds(100,100,image.getWidth(),image.getHeight());
		this.setLayout(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
