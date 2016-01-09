package ihm;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {

	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		String sep = File.separator;
		Dimension frameSize = new Dimension(1200, 710);
		f.setResizable(false);
		f.setSize(frameSize);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setIconImage(new ImageIcon("resources"+sep+"Icone.png").getImage());
		p.setLayout(null);

		JLabel redBird = new JLabel();
		redBird.setIcon(new ImageIcon("resources"+sep+"redBird.gif"));
		redBird.setBounds(0, 0, 375, 375);
		p.add(redBird);

		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("resources"+sep+"background1.png"));
		bg.setBounds(0, 0, frameSize.width, frameSize.height);
		p.add(bg);
		
		
		f.add(p);
		f.setVisible(true);

	}
	
}
