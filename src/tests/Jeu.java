package tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import modele.Equation;
import modele.Modele;
import modele.Obstacle;
import modele.Panneau;
import modele.Point;

@SuppressWarnings("serial")
public class Jeu extends JFrame {

	private static Panneau pan = new Panneau();

	Timer time;
	int x;
	int y;
	static ArrayList<Point> liste;
	static ArrayList<Point> listeBec;
	static boolean run = false;
	static ArrayList<Point> listeBecDeriv = new ArrayList<>();
	static boolean calc = false;
	static boolean oiseauAvance = false;
	static boolean oiseauArret = false;
	Modele modele;
	int i = 0;

	public Jeu() {
		time = new Timer();
		pan = new Panneau();
		x = pan.getX();
		y = pan.getY();
		liste = new ArrayList<>();
		listeBec = new ArrayList<>();
		listeBecDeriv = new ArrayList<>();
		modele = new Modele();
		trajet();
		this.setTitle("Angry_Bird");
		this.setSize(1200, 710);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	public void relancer() {
		modele = new Modele();
		liste = new ArrayList<>();
		listeBec = new ArrayList<>();
	
		pan.getPts().clear();
		trajet();
		repaint();
	}

	public static void trajet() {
		Random rand2 = new Random();
		int coef = rand2.nextInt(2) + 1;
		int cpt = 0;
		Random rand = new Random();

		float k = rand.nextFloat() * 3 + 1;
		Equation eq = new Equation(coef, k);
		for (double t = 0; t <= 15; t = t + 0.001) {
			liste.add(new Point(eq.f(t), eq.g(t)));
			System.out.println(liste.get(cpt).toString());
			// liste des points du bec
			listeBec.add(new Point(eq.f(t+0.001*200), eq.g(t+0.001*200)));
			listeBecDeriv.add(new Point(eq.f(t+0.001*200), eq.tangente(eq.f(t+0.001*75), (t+0.001*75))));
		
			System.out.println(listeBec.get(cpt).toString());
			cpt++;
		}
		calc = true;
		System.out.println("coef : " + coef);
		System.out.println("k : " + k);
	}

	private void go() {
		pan.setModele(modele);
		

		Obstacle obstacle = null;
		if (i < liste.size()
				&& ((600 - liste.get(i).getY()) <= this.getHeight() - 25)
				&& ((600 - liste.get(i).getY()) > 1)
				&& (liste.get(i).getX() < this.getWidth() - 25)) {

			// mouvement du bec
			// mouvement de l'oiseau
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());

			// mouvement du bec
			pan.setPosBecX((int) (listeBec.get(i).getX() * 100));
			pan.setPosBecY((int) (600 - listeBec.get(i).getY()));
			pan.setPosBecDX((int) (listeBecDeriv.get(i).getX() * 100));
			pan.setPosBecDY((int) (600 - listeBecDeriv.get(i).getY()));

			pan.setPosX(x);
			pan.setPosY(y);
			oiseauAvance = true;
			this.repaint();
			repaint();
			i = i + 35;
			obstacle = modele.oiseauRencontreObstacle(pan);
			if (obstacle == null) {

			} else {
				for (Obstacle obs : modele.getListeObstacle()) {
					if (obs == obstacle) {
						oiseauArret = true;
						obstacle.setCouleur(Color.blue);
						time.cancel();

						try {
							Thread.sleep(2000);
						} catch (InterruptedException ex) {
							Logger.getLogger(Jeu.class.getName()).log(
									Level.SEVERE, null, ex);
						}

						this.dispose();

						break;
						// relancer();

					}
				}
				System.out.println("obstacle trouvée");
			}
		} else {
			oiseauArret = true;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null,
						ex);
			}

			time.cancel();
			this.dispose();
		}

	}

	public boolean run() {
		if (calc == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean oiseauAvance() {
		if (oiseauAvance == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean oiseauArret() {
		if (oiseauArret == true) {
			return true;
		} else {
			return false;
		}
	}

	public Panneau getPan() {
		return pan;
	}

}
