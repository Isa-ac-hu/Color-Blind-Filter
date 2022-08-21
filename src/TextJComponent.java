import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;


public class TextJComponent extends JComponent
{

	Color[] reds = {new Color(197, 141, 116), new Color(192, 138, 112), new Color(188, 140, 117), 
			new Color(199, 137, 114), new Color(190, 116, 91), new Color(194, 131, 100), 
			new Color(193, 127, 101), new Color(196, 130, 108), new Color(198, 128, 103), 
			new Color(187, 122, 104), new Color(195, 124, 106), new Color(180, 107, 74), 
			new Color(177, 126, 105), new Color(179, 104, 72), new Color(191, 121, 85), 
			new Color(189, 118, 88), new Color(186, 125, 96), new Color(182, 109, 77), 
			new Color(181, 98, 66), new Color(185, 111, 76), new Color(184, 110, 81), 
			new Color(183, 123, 99), new Color(175, 108, 79), new Color(178, 103, 71), 
			new Color(174, 105, 76), new Color(173, 117, 90), new Color(170, 114, 89)};

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
	
	private Font font;
	private String textBody;
	private String[] stringComponents;
	
	private int stringDX;
	private int stringDY = 1;
	private int stringYLocation = 150;
	private int currentXLocation = 0;
	
	private int xSize = 600;
	private int ySize = 400;
	private int fontSize;
	
	public TextJComponent(String text, int fontSize)
	{
		this.setSize(xSize, ySize);
		this.setLocation(0,0);
		font = new Font("MS Mincho", Font.BOLD, fontSize);	
		
		textBody = text;
		
		stringComponents = new String[textBody.length()];
		
		for(int i = 0; i < textBody.length(); i++)
		{
			stringComponents[i] = textBody.substring(i, i+1);
		}
		stringDX = fontSize;
		this.fontSize = fontSize;
		
		
	}
	
	public void paintComponent(Graphics g)
	{
	
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(font);
		
		for(int i = 0; i < 2000; i++)
		{
			g2.setColor(greens[(int)(Math.random()*greens.length)]);
			int randomLocationX = (int)(Math.random()*xSize);
			int randomLocationY = (int)(Math.random()*ySize);
			int randomSize = (int)(Math.random()*25);
			g2.fill(new Ellipse2D.Double(randomLocationX,randomLocationY,randomSize,randomSize));
		}
	
		for(int i = 0; i < stringComponents.length; i++)
		{
			
			g2.rotate(Math.toRadians((int)((Math.random()*20)-10)), currentXLocation, stringYLocation);
			g2.setColor(reds[(int)(Math.random()*reds.length)]);
			currentXLocation = 100 + (i*stringDX + ((int)(Math.random()*10)-5));
			g2.drawString(stringComponents[i], currentXLocation, 
					stringYLocation + ((int)(Math.random()*(fontSize/4))-(fontSize/2)));
		}
		

		
	}
	
	
}
