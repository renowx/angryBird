package tests;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RenaudTests extends JFrame{
	
	public static void main (String[] args){
		new RenaudTests();
	}
	
	public RenaudTests(){
		JPanel jpan = new JPanel();
		setSize(new Dimension(1080, 1920));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);
		this.add(jpan);
	
	}
	
	public int f(int x){
		return x - 2;
	}
	
	public void paint(Graphics g) {
		for (int x = 0; x < getSize().width; x++) {
			g.drawLine(x, f(x), x + 1, f(x + 1));
		}
	}
	
}
