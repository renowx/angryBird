package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class RenaudTests extends JFrame {

	private Panneau pan = new Panneau();
	JFrame frame = new JFrame();
	
	
	public RenaudTests() {
		frame.setTitle("Angry_Bird");
		frame.setSize(1200, 910);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setContentPane(pan);
		frame.setVisible(true);
		go();
		
	}

	private void go() {
		int x = pan.getPosX(), y = pan.getPosY();
		Timer timer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		for (int i = 0; i < pan.getWidth(); i++) {
			x = pan.getPosX();
			y = pan.getPosY();
			x = x + 2;
			y = (int) Parabole(x, y);
			pan.setPosX(x);
			pan.setPosY(y);
			frame.repaint();
			repaint();

			// Vitesse de deplacement pour les tests passage au Timer par la
			// suite
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Arret de l'objet a ameliorer
			if (x == frame.getWidth() - 100 || y == frame.getWidth() - 100
					|| x == frame.getHeight() - 100
					|| y == frame.getHeight() - 100
					|| (x >= pan.getPosXo2() - 43 && y >= pan.getPosYo2() - 43)
					|| x <= 0 || y <= 0) {
				i = pan.getWidth();
			}
		}
	}

	// Equation d'une parabole
	private float Parabole(float x, float y) {
		y = frame.getHeight() - (float) ((-(0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	public static void main(String[] args) {
		new RenaudTests();
	}

}
