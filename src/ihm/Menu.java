package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Jalon2.Controlleur.Controlleur;
import Jalon2.Modele.Modele;
import Jalon2.Vue.Scene;

public class Menu {

	static String sep = File.separator;
	static String imgPath = "resources"+sep+"Images"+sep;
	static String soundPath = "resources"+sep+"Sounds"+sep;
	static String policePath = "resources"+sep+"Polices"+sep;
	static String trackPath = "resources"+sep+"Tracks"+sep;
	static String buttonFalse = imgPath+"ButtonBG.png";
	static String buttonTrue = imgPath+"ButtonBGReact.png";
	static String button = buttonFalse;
	static JFrame f = new JFrame();
	static JPanel p = new JPanel();
	
	public static MouseListener buttonBGlistener = new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			JButton but = (JButton) e.getSource();
			but.setIcon(new ImageIcon(buttonTrue));
			System.out.println("Mouse entered "+but.getName()+"'s button area");
		}
		public void mouseExited(MouseEvent e) {
			JButton but = (JButton) e.getSource();
			but.setIcon(new ImageIcon(buttonFalse));
			System.out.println("Mouse release "+but.getName()+"'s button area");
		}
	};

	public static void main(String[] args) {
		
		Menu Menu = new Menu();
		Dimension frameSize = new Dimension(1200, 710);
		f.setResizable(false);
		f.setSize(frameSize);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
		f.setIconImage(new ImageIcon(Menu.imgPath+"IconeRouge.png").getImage());
		p.setLayout(null);
		
		//Play Button
		JButton play = new JButton();
		play.setName("Play");
		play.setIcon(new ImageIcon(Menu.imgPath+"ButtonBG.png"));
		play.setBounds(545, 215, 160, 60);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setOpaque(false);
		play.addMouseListener(buttonBGlistener);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//à modifier
				System.out.println("Play Button clicked");
			}
		});
		p.add(play);	
		
		JLabel playBG = new JLabel("Play");
		playBG.setBounds(611, 215, 160, 60);
		p.add(playBG);
		

		//Help Button
		JButton help = new JButton();
		help.setName("Help");
		help.setIcon(new ImageIcon(Menu.imgPath+"ButtonBG.png"));
		help.setBounds(545, 315, 160, 60);
		help.setContentAreaFilled(false);
		help.setBorderPainted(false);
		help.setOpaque(false);
		help.addMouseListener(buttonBGlistener);
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Help help = new Help(f, frameSize);
				System.out.println("Help Button clicked");
			}
		});
		p.add(help);

		JLabel helpBG = new JLabel("Help");
		helpBG.setBounds(611, 315, 160, 60);
		p.add(helpBG);
		
		//Credits Button
		JButton credits = new JButton();
		credits.setName("Credits");
		credits.setIcon(new ImageIcon(Menu.imgPath+"ButtonBG.png"));
		credits.setBounds(545, 415, 160, 60);
		credits.setContentAreaFilled(false);
		credits.setBorderPainted(false);
		credits.setOpaque(false);
		credits.addMouseListener(buttonBGlistener);
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Credits credits = new Credits(f, frameSize);
				System.out.println("Credits Button clicked");
			}
		});
		p.add(credits);
		
		JLabel creditsBG = new JLabel("Credits");
		creditsBG.setBounds(605, 415, 160, 60);
		p.add(creditsBG);
		

		//Exit Button
		JButton exit = new JButton();
		exit.setName("Exit");
		exit.setIcon(new ImageIcon(Menu.imgPath+"ButtonBG.png"));
		exit.setBounds(545, 515, 160, 60);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setOpaque(false);
		exit.addMouseListener(buttonBGlistener);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Exit Button clicked");
				System.exit(0);
			}
		});
		p.add(exit);
		
		JLabel exitBG = new JLabel("Exit");
		exitBG.setBounds(615, 515, 160, 60);
		p.add(exitBG);


		//Background
		JLabel redBird = new JLabel();
		redBird.setIcon(new ImageIcon(Menu.imgPath+"redBird.gif"));
		redBird.setBounds(95, 290, 375, 375);
		p.add(redBird);

		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon(Menu.imgPath+"menuBackground.png"));
		bg.setBounds(0, 0, frameSize.width, frameSize.height);
		p.add(bg);

		
		f.add(p);
		f.setVisible(true);

	}
	
}
