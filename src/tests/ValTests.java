package tests;

import modele.Panneau;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.Oiseau;

public class ValTests extends JFrame {

	private Panneau pan = new Panneau();
	private Oiseau o = new Oiseau();
	JFrame frame = new JFrame();
	Timer time = new Timer();
	int x = pan.getPosX(), y = pan.getPosY();

	public ValTests() {
		frame.setTitle("Angry_Bird");
		frame.setSize(1200, 910);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setContentPane(pan);
		frame.setVisible(true);
		int delay = 10; // milliseconds
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				go();
			}
		};

		time.schedule(task, delay, 10);

	}

	private void go() {
		int x = pan.getPosX(), y = pan.getPosY();

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

		// Arret de l'objet a ameliorer
		if (x == frame.getWidth() - 100 || y == frame.getWidth() - 100
				|| x == frame.getHeight() - 100 || y == frame.getHeight() - 100
				|| (x == pan.getPosXo2() && y == pan.getPosYo2()) || x <= 0
				|| y <= 0) {

		}
		if ((x >= pan.getPosXo2() - 25 && y <= pan.getPosYo2() - 25)) {

			x = pan.getPosXo2();
			y = pan.getPosYo2();
			x = x + 2;
			y = (int) Parabole(x, y);
			pan.setPosXo2(x);
			pan.setPosYo2(y);
			frame.repaint();
			repaint();
		}

	}

	// Equation d'une parabole
	private float Parabole(float x, float y) {
		y = frame.getHeight() - (float) (-((0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	private double Parabole(double a, double x) {
		return a * Math.pow(x, 2); // Math.pow(x,2) vaut x2
	}

	public static void main(String[] args) {
		new ValTests();

	}
}
