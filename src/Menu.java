import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu extends JFrame
{
	private String selection = "--";
	private String modSelection = "--";
	private JLabel lblName = null;
	
	private String fileName;
	private static String newFileName;
	private String modification;
	private int resolutionValue;
	private int fontValue;
	private int textBody;
	private int degreeOfChange = 0;
	
	public Menu()
	{
		setBounds(500,100,800,500);
		setTitle("Isaac's Image Host");
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.insets = new Insets(5, 5, 5, 5);	
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		JLabel title = new JLabel("Isaac's Image Host");
		title.setFont(new Font("MS Mincho", Font.PLAIN, 50));	
		title.setForeground(Color.blue);	
		gbc.gridwidth = 2;
		add(title, gbc);
		
		lblName = new JLabel(selection);
		lblName.setFont(new Font("MS Mincho", Font.PLAIN, 16));	
		lblName.setForeground(Color.blue);	
		gbc.gridwidth = 1;
		gbc.gridy++;
		add(lblName, gbc);
				
		JTextField pictureFileName = new JTextField();
		pictureFileName.setPreferredSize(new Dimension(300,30));
		pictureFileName.setEnabled(true);
		pictureFileName.setVisible(false);
		gbc.gridx++;
		add(pictureFileName, gbc);
		
		JLabel lblName2 = new JLabel("New File Name: ");
		lblName2.setFont(new Font("MS Mincho", Font.PLAIN, 16));	
		lblName2.setForeground(Color.blue);	
		lblName2.setVisible(false);
		gbc.gridwidth = 1;
		gbc.gridx--;
		gbc.gridy++;
		add(lblName2, gbc);
		
		JTextField pictureNewFileName = new JTextField();
		pictureNewFileName.setPreferredSize(new Dimension(300,30));
		pictureNewFileName.setEnabled(true);
		pictureNewFileName.setVisible(false);
		gbc.gridx++;
		add(pictureNewFileName, gbc);
		
		JTextArea textBody = new JTextArea();
		textBody.setPreferredSize(new Dimension(600,120));
		textBody.setEnabled(true);
		textBody.setVisible(false);
		add(textBody, gbc);
		
		JLabel resolutionLabel = new JLabel("Resolution: ");
		resolutionLabel.setFont(new Font("MS Mincho", Font.PLAIN, 16));	
		resolutionLabel.setForeground(Color.blue);	
		resolutionLabel.setVisible(false);
		gbc.gridwidth = 1;
		gbc.gridx--;
		gbc.gridy++;
		add(resolutionLabel, gbc);
		
		JTextField resolutionText = new JTextField();
		resolutionText.setPreferredSize(new Dimension(300,30));
		resolutionText.setVisible(false);
		gbc.gridx++;
		add(resolutionText, gbc);
		
		JLabel magnitudeIndex = new JLabel("Degree of Change: ");
		magnitudeIndex.setFont(new Font("MS Mincho", Font.PLAIN, 16));	
		magnitudeIndex.setForeground(Color.blue);	
		magnitudeIndex.setVisible(false);
		gbc.gridwidth = 1;
		gbc.gridx--;
		gbc.gridy++;
		add(magnitudeIndex, gbc);
		
		JTextField magnitudeText = new JTextField();
		magnitudeText.setPreferredSize(new Dimension(300,30));
		magnitudeText.setVisible(false);
		gbc.gridx++;
		add(magnitudeText, gbc);
		
		JLabel textLabel = new JLabel("Font size: ");
		textLabel.setFont(new Font("MS Mincho", Font.PLAIN, 16));	
		textLabel.setForeground(Color.blue);	
		textLabel.setVisible(false);
		gbc.gridwidth = 1;
		gbc.gridx--;
		gbc.gridy++;
		add(textLabel, gbc);
		
		JTextField fontField = new JTextField();
		fontField.setPreferredSize(new Dimension(100,30));
		fontField.setVisible(false);
		gbc.gridx++;
		add(fontField, gbc);
		
		String[] modifications = {"--", "Black and White", "Colored Static", "Red-Green Colorblind", "Change Lighting"};
		JComboBox typeOfModification = new JComboBox(modifications);
		//getSelectedItem
		typeOfModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				if (typeOfModification.getSelectedItem().equals("--"))
				{
					modSelection = "--";
					magnitudeIndex.setVisible(false);
					magnitudeText.setVisible(false);
				}
				else if(typeOfModification.getSelectedItem().equals("Black and White"))
				{
					modSelection = "turnToBlackAndWhite";
					magnitudeIndex.setVisible(false);
					magnitudeText.setVisible(false);
				}
				else if(typeOfModification.getSelectedItem().equals("Colored Static"))
				{
					modSelection = "randomStatic";
					magnitudeIndex.setVisible(true);
					magnitudeText.setVisible(true);
				}
				else if(typeOfModification.getSelectedItem().equals("Red-Green Colorblind"))
				{
					modSelection = "redGreenColorBlind";
					magnitudeIndex.setVisible(false);
					magnitudeText.setVisible(false);
				}
				else if(typeOfModification.getSelectedItem().equals("Change Lighting"))
				{
					modSelection = "changeLighting";
					magnitudeIndex.setVisible(true);
					magnitudeText.setVisible(true);
				}
			}
		});		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 1;		
		typeOfModification.setVisible(false);
		add(typeOfModification, gbc);
	
		String[] fileTypes = {"--", "Picture", "Text"};
		JComboBox typeOfFile = new JComboBox(fileTypes);
		//getSelectedItem
		typeOfFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				if (typeOfFile.getSelectedItem().equals("--"))
				{
					selection = "--";
					lblName.setText("--");
					typeOfModification.setVisible(false);
					resolutionText.setVisible(false);
					resolutionLabel.setVisible(false);
					textLabel.setVisible(false);
					fontField.setVisible(false);
					textBody.setVisible(false);
					pictureFileName.setVisible(false);
				}
				else if(typeOfFile.getSelectedItem().equals("Picture"))
				{
					selection = "Picture";
					lblName.setText("File Name: ");
					typeOfModification.setVisible(true);
					resolutionText.setVisible(true);
					resolutionLabel.setVisible(true);
					textLabel.setVisible(false);
					fontField.setVisible(false);
					textBody.setVisible(false);
					pictureFileName.setVisible(true);
				}
				else if(typeOfFile.getSelectedItem().equals("Text"))
				{
					selection = "Text";
					lblName.setText("Text Body: ");
					typeOfModification.setVisible(false);
					resolutionText.setVisible(false);
					resolutionLabel.setVisible(false);
					textLabel.setVisible(true);
					fontField.setVisible(true);
					textBody.setVisible(true);
					pictureFileName.setVisible(false);
				}
			}
		});		
		gbc.gridx--;
		gbc.gridy++;
		add(typeOfFile, gbc);
		
		JCheckBox chkEnable = new JCheckBox("Save image as a .png");		
		chkEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				if(chkEnable.isSelected())
				{
					lblName2.setVisible(true);
					pictureNewFileName.setVisible(true);
				}
				else
				{
					lblName2.setVisible(false);
					pictureNewFileName.setVisible(false);
				}
			}
		});
		gbc.gridx += 2;
		gbc.gridwidth = 1;
		add(chkEnable, gbc);		
				
		JButton declaration = new JButton("Terms of Use");
		declaration.setPreferredSize(new Dimension(200, 40));
	  
		declaration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
	
			}
		});		
		gbc.gridx--;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(declaration, gbc);
		
		
		JButton button = new JButton("Create new object");
		button.setPreferredSize(new Dimension(200, 40));
	  
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(typeOfFile.getSelectedItem().equals("Picture"))
				{
					fileName = pictureFileName.getText();
					newFileName = pictureNewFileName.getText();
					try
					{
						resolutionValue = Integer.valueOf(resolutionText.getText());
						
					}
					catch(Exception a)
					{
						JOptionPane.showMessageDialog(null, "Give an integer!");
					}
					try
					{
						degreeOfChange = Integer.valueOf(magnitudeText.getText());
					}
					catch(Exception b)
					{
						
					}
					try
					{
						imgJFrame newImage = new imgJFrame(fileName, resolutionValue, modSelection, degreeOfChange);
						if(chkEnable.isSelected())
						{
							takePicture((JFrame)newImage);

						}
					}
					catch(Exception c)
					{
						JOptionPane.showMessageDialog(null, "Failed to create new object.");
					}
				}
				else if(typeOfFile.getSelectedItem().equals("Text"))
				{
	
				}
			}
		});		
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(button, gbc);
		
		this.setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void takePicture(JFrame frame) 
	{
	    BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
	    frame.print(img.getGraphics());
	    try 
	    {
	        ImageIO.write(img, "jpg", new File(newFileName));
	    }
	    catch (IOException e) 
	    {
	    	System.out.println("FAILURE");
	        e.printStackTrace();
	    }
	}
	
	
}
