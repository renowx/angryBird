package tests;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.Modele;
import modele.Obstacle;
import modele.Panneau;

@SuppressWarnings("serial")
public class Jeu extends JFrame {

	private Panneau pan = new Panneau();
	private Modele modele;
	
	Timer time = new Timer();
	int x = pan.getPosX();
	int y = pan.getPosY();
	static ArrayList<Point> liste = new ArrayList<>();
	static ArrayList<Point> listeBec = new ArrayList<>();
	int i = 0;

	public static void main(String args[]) {

		new Jeu();

	}

	public Jeu() {
		modele = new Modele();
		trajet();
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

	public static void trajet() {
		Random rand2 = new Random();
		int coef = rand2.nextInt(2) + 1;

		Equation eq = new Equation(coef);
		int cpt = 0;
		Random rand = new Random();

		float k = rand.nextFloat() * 3 + 1;

		for (double t = 0; t <= 15; t = t + 0.001) {
			liste.add(new Point(eq.f(t), eq.g(t, k)));
			System.out.println(liste.get(cpt).toString());
			// liste des points du bec
			listeBec.add(new Point(eq.f(t), eq.derive(t, k)));
			System.out.println(listeBec.get(cpt).toString());
			cpt++;
		}
		System.out.println("coef : " + coef);
		System.out.println("k : " + k);
	}

	private void go() {
		Obstacle obstacle = null;
		if (i < liste.size()
				&& ((600 - liste.get(i).getY()) <= this.getHeight() - 25)
				&& ((600 - liste.get(i).getY()) > 1)
				&& (liste.get(i).getX() < this.getWidth() - 25)) {
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());
			// mouvement du bec
			pan.setPosBecX((int) (x + listeBec.get(i).getX()));
			pan.setPosBecY((int) (y - listeBec.get(i).getY()));
			pan.setPosBec1X((int) (x + listeBec.get(i).getX() - 25));
			pan.setPosBec2X((int) (x + listeBec.get(i).getX() - 50));

			pan.setPosX(x);
			pan.setPosY(y);

			this.repaint();
			repaint();
			i = i + 35;

			obstacle = modele.oiseauRencontreObstacle(pan);
			if (obstacle == null) { // pas de rencontre d'obstacle mais peut
									// Ãªtre
				// rencontre du bord
				if (pan.getPosX() == this.getWidth() - 100
						|| pan.getPosY() == this.getWidth() - 100
						|| pan.getPosX() == this.getHeight() - 100
						|| pan.getPosY() == this.getHeight() - 100) {
					System.out.println("arret de l'objet");
					// time.cancel();
					System.exit(0);

				}

			} else {
				for (Obstacle obs : modele.getListeObstacle()) {
					if (obs == obstacle) {
						obs.setCouleur(Color.red);
						time.cancel();
					}
				}
				System.out.println("obstacle trouvÃ©e");
			}
		}

	}


}