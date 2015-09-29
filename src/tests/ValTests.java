package tests;

import java.awt.Dimension;
import javax.swing.JFrame;

public class ValTests extends JFrame {

	private Panneau pan = new Panneau();

	public ValTests() {
		this.setTitle("Animation");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}

	private void go() {
		for (int i = -50; i < pan.getWidth(); i++) {
			int x = pan.getPosX()/*, y = pan.getPosY()*/;
			x++;
			//y++;
			pan.setPosX(x);
			//pan.setPosY(y);
			pan.repaint();
			repaint();
			try {
				//Rapidité du déplacement
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Arrete arrive au bord de la feunetre
			if(x == pan.getWidth()-50 /*|| y == pan.getHeight()-50*/){
				i=pan.getWidth();
				} 
		}
	}
	
	public static void main(String[] args){
		new ValTests();
	}
	

}
