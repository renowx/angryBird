package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.Panneau;

public class RenaudTest2 extends JFrame {

	private Panneau pan = new Panneau();

	Timer time = new Timer();
	int x = pan.getPosX();
	int y = pan.getPosY();
	static List<Point> liste = new ArrayList<>();
	static List<Point> liste2 = new ArrayList<>();

	int i = 0;

	public static void main(String args[]) {

		Random rand = new Random();
		int sqrt = rand.nextInt(2) + 1;

		Equation eq = new Equation(sqrt);
		int cpt = 0;
		rand = new Random();
		
		float k = rand.nextFloat() * 3 + 1;

		for (double t = 0; t <= 15; t = t + 0.001) {
			liste.add(new Point(eq.f(t), eq.g(t, k)));
			liste2.add(new Point(eq.derive(eq.f(t), k), eq.derive(eq.g(t, k), k)));
			System.out.println(liste.get(cpt).toString());
			System.out.println(liste2.get(cpt).toString());
			cpt++;
		}

		new RenaudTest2();
		System.out.println("sqrt : " + sqrt);
		System.out.println("coef : " + k);
		
	}

	public RenaudTest2() {
		this.setTitle("Angry_Bird");
		this.setSize(1200, 710);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(pan);
		this.setVisible(true);
		
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
		if (i < liste.size()
				&& ((600 - liste.get(i).getY()) <= this.getHeight() - 25)
				&& ((600 - liste.get(i).getY()) > 1)
				&& (liste.get(i).getX() < this.getWidth() - 25)) {
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());
			pan.setPosX(x);
			pan.setPosY(y);

			this.repaint();
			repaint();
			i = i + 35;
		}

	}

}
