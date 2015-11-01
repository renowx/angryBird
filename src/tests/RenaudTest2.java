package tests;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.Panneau;

public class RenaudTest2 extends JFrame {

	private Panneau pan = new Panneau();

	JFrame frame = new JFrame();
	Timer time = new Timer();
	int x = pan.getPosX();
	int y = pan.getPosY();
	static ArrayList<Point> liste = new ArrayList<>();
	int i = 0;

	public static void main(String args[]) {
		Random rand2 = new Random();
		int sqrt = rand2.nextInt(2)+1;
		
		Equation eq = new Equation(sqrt);
		int cpt = 0;
		Random rand = new Random();

		float k = rand.nextFloat() * 3;
		
		for (double t = 0; t <= 15; t = t + 0.001) {
			liste.add(new Point(eq.f(t), eq.g(t, k)));
			System.out.println(liste.get(cpt).toString());
			cpt++;
		}
		new RenaudTest2();
		System.out.println("sqrt : " + sqrt);
		System.out.println("coef : " + k);
	}

	public RenaudTest2() {
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
		if (i < liste.size()) {
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());
			pan.setPosX(x);
			pan.setPosY(y);

			frame.repaint();
			repaint();
			i = i + 35;
		}
	}

}
