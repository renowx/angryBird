package tests;

import javax.swing.JFrame;

public class ValTests extends JFrame {

	private Panneau pan = new Panneau();
	JFrame frame = new JFrame();

	public ValTests() {
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
		y = (float) (-((0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	private double Parabole(double a, double x) {
		return a * Math.pow(x, 2); // Math.pow(x,2) vaut x2
	}

	public static void main(String[] args) {
		new ValTests();
	}

}
