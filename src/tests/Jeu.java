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

	private static Panneau pan = new Panneau();
	private Modele modele;
	
	Timer time = new Timer();
	int x = pan.getPosX();
	int y = pan.getPosY();
	
	static ArrayList<Point> liste = new ArrayList<>();
	static ArrayList<Point> listeBec = new ArrayList<>();
	static ArrayList<Point> listeBecDeriv = new ArrayList<>();
	static boolean run = false;
	static boolean calc = false;
	static boolean oiseauAvance = false;
	static boolean oiseauArret = false;
	
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
		Obstacle obstacle = null;
		if (i < liste.size()
				&& ((600 - liste.get(i).getY()) <= this.getHeight() - 25)
				&& ((600 - liste.get(i).getY()) > 1)
				&& (liste.get(i).getX() < this.getWidth() - 25)) {
			
			//mouvement de l'oiseau
			x = (int) (liste.get(i).getX() * 100);
			y = (int) (600 - liste.get(i).getY());
			
			//mouvement du bec
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
				if (pan.getPosX() == this.getWidth() - 100
						|| pan.getPosY() == this.getWidth() - 100
						|| pan.getPosX() == this.getHeight() - 100
						|| pan.getPosY() == this.getHeight() - 100) {
					System.out.println("arret de l'objet");
					
					oiseauArret = true;
					System.exit(0);

				}
				oiseauArret = true;

			} else {
				for (Obstacle obs : modele.getListeObstacle()) {
					if (obs == obstacle) {
						obs.setCouleur(Color.red);
						oiseauArret = true;
						time.cancel();
					}
				}
				System.out.println("obstacle trouvÃ©e");
			}
		}

	}
	
	public boolean run(){
		if (calc == true){
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean oiseauAvance(){
		if (oiseauAvance == true){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean oiseauArret(){
		if (oiseauArret == true){
			return true;
		} else {
			return false;
		}
	}
	
	public static Panneau getPan(){
		return pan;
	}


}
