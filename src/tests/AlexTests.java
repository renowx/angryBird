package tests;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.AlexPanneau;
import modele.Equation;
import modele.Panneau;
import modele.Point;

public class AlexTests extends JFrame {

	static Random rand2 = new Random();
	static int sqrt = rand2.nextInt(2) + 1;

	static Random rand = new Random();

	public static float k = rand.nextFloat() * 3 + 1;
	public static Equation eq = new Equation(sqrt, k);

	private AlexPanneau pan = new AlexPanneau();

	JFrame frame = new JFrame();
	Timer time = new Timer();
	int x = pan.getPosX();
	int y = pan.getPosY();
	static ArrayList<Point> liste = new ArrayList<>();
	static ArrayList<Point> listeBec = new ArrayList<>();
	static ArrayList<Point> listeBecDeriv = new ArrayList<>();

	int i = 0;

	public static void main(String args[]) {

		for (double t = 0; t <= 15; t = t + 0.001) {
			//liste des points de l'oiseau
			liste.add(new Point(eq.f(t), eq.g(t)));
			
			//listes des points du bec
			listeBec.add(new Point(eq.f(t+0.001*200), eq.g(t+0.001*200)));
			listeBecDeriv.add(new Point(eq.f(t+0.001*200), eq.tangente(eq.f(t+0.001*75), (t+0.001*75))));
		}
		
		
		new AlexTests();
		System.out.println("sqrt : " + sqrt);
		System.out.println("coef : " + k);
	}

	public AlexTests() {
		frame.setTitle("Angry_Bird");
		frame.setSize(1200, 710);
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
		if (i < liste.size()
				&& ((600 - liste.get(i).getY()) <= frame.getHeight()-25)
				&& ((600 - liste.get(i).getY()) > 1)
				&& (liste.get(i).getX() < frame.getWidth()-25)) {
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());
	
			//mouvement du bec
			pan.setPosBecX((int) (listeBec.get(i).getX() * 100));
			pan.setPosBecY((int) (600 - listeBec.get(i).getY()));
			pan.setPosBecDX((int) (listeBecDeriv.get(i).getX() * 100));
			pan.setPosBecDY((int) (600 - listeBecDeriv.get(i).getY()));
			
			//mouvement de l'oiseau
			pan.setPosX(x);
			pan.setPosY(y);

			frame.repaint();
			repaint();
			i = i + 35;
		}

	}

}
