package tests;

import java.awt.Color;
import java.awt.Graphics;
import java.nio.Buffer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ValTests extends JPanel {
	public JFrame frame;
    public JPanel panel;

    public ValTests(){
        frame=new JFrame();
        panel=new JPanel();

        panel.setSize(500,500);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.add(panel);
        panel.repaint();
    }

    public void paint(Graphics g){
        super.paintComponents(g);
        g.drawOval(100, 200, 50, 50);
    }

    public static void main(String args[]){
        new ValTests();
    }
	
	
	
}
