package tests;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import sun.font.GraphicComponent;
import sun.java2d.loops.DrawLine;

public class RenaudTests extends JFrame {

	private Panneau pan = new Panneau();
	JFrame frame = new JFrame();
	Timer time = new Timer();
	int x = pan.getPosX(), y = pan.getPosY();
	private ArrayList<Point> liste = new ArrayList<>();

	public RenaudTests() {

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
				go(null);
			}
		};

		time.schedule(task, delay, 10);

	}

	private void go(Graphics g) {

		int x = pan.getPosX(), y = pan.getPosY();

		while (!(x >= pan.getPosXo2() - 25 && y <= pan.getPosYo2() - 25)) {
			x = pan.getPosX();
			y = pan.getPosY();
			x = x + 2;
			y = (int) Parabole(x, y);
			pan.setPosX(x);
			pan.setPosY(y);
			liste.add(new Point(x, y));
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
					|| (x == pan.getPosXo2() && y == pan.getPosYo2()) || x <= 0
					|| y <= 0) {
			}
			
		}

		x = pan.getPosXo2();
		y = pan.getPosYo2();
		x = x + 2;
		y = (int) Parabole(x, y);
		pan.setPosXo2(x);
		pan.setPosYo2(y);
		frame.repaint();
		repaint();
		liste.add(new Point(x, y));
		for (int i = 1; i <= liste.size(); i++) {
			if (i < 2) {
				g.drawLine((int) liste.get(i - 1).getX(), (int) liste
						.get(i - 1).getY(), (int) liste.get(i).getX(),
						(int) liste.get(i).getY());
			}
		}

	}

	private double Parabole(double a, double x) {
		return a * Math.pow(x, 2); // Math.pow(x,2) vaut x2
	}

	// Equation d'une parabole
	private float Parabole(float x, float y) {
		y = frame.getHeight() - (float) (-((0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	public static void main(String[] args) {
		new RenaudTests();
	}

}
