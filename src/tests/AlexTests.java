package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlexTests extends JFrame {

	public AlexTests() {
		AlexTests testAlex = new AlexTests();	
	
		JFrame frame = new JFrame("Hungry Birds");
	
		JPanel pan = new JPanel();
		
		JLabel bird = new JLabel("O");
		
		pan.setLayout(null);
		bird.setForeground(Color.BLACK);
		pan.add(bird);
						
	    ImageIcon burd= new ImageIcon("Images/oiseau.png");
        JLabel boob = new JLabel(burd);
        boob.setBounds(350, 225, 100, 100);
        pan.add(boob);

		
        frame.add(pan);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
		
		
	}
	
	public static void main(String[] args) {
		AlexTests frame = new AlexTests();
	}

}
