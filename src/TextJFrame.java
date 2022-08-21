import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class TextJFrame extends JFrame implements ActionListener
{
	private TextJComponent image = null;
	
	public TextJFrame(String textBody, int font) throws FileNotFoundException
	{		
		setTitle("Isaac's Image Host");

		image = new TextJComponent(textBody, font);
		add(image);
		
		
		this.setBounds(100,100,image.getWidth(),image.getHeight());
		this.setLayout(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}
}
