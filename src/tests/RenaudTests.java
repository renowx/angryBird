package tests;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.BecTest;
import modele.Oiseau;
import modele.Panneau;

public class RenaudTests extends JFrame {

	private Panneau pan = new Panneau();
	private Oiseau o = new Oiseau();
	JFrame frame = new JFrame();
	Timer time = new Timer();
	int x = pan.getPosX(), y = pan.getPosY();
	int t = 1;
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
				go();
			}
		};

		time.schedule(task, delay, 10);

	}

	private void go() {
		
		x = f(t);
		y = 600-g(t);
		pan.setPosX(x);
		pan.setPosY(y);
		
		frame.repaint();
		repaint();
		t = t + 1;


	}

	private int f(int t) {
		return (int)(((0.03) * (t * t)) + 2 * t );
	}

	private int g(int t) {
		return (int) t+1;
	}

	public static void main(String[] args) {
		new RenaudTests();

	}
}
