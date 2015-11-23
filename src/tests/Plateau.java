package tests;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import modele.Modele;
import Jalon2.Modele.Obstacle;
import modele.ObstacleTest;

public class Plateau extends JFrame {

	private int positionInitX = 5;
	private int positionInitY = 530;
	private int posBecX = positionInitX;
	private int posBecY = positionInitY;
	private static int coef;
	private static float k;
	private ObstacleTest obs = new ObstacleTest(1000, 200,50);
	private Modele mod = new Modele();
	private OiseauTest titi = new OiseauTest(positionInitX, positionInitY,
			posBecX, posBecY, k);

	Timer time = new Timer();
	int i = 0;
	private static ArrayList<Point> liste = new ArrayList<Point>();
	private static ArrayList<Point> listeBec = new ArrayList<Point>();

	public Plateau() {

		this.setTitle("Angry_Bird");
		this.setSize(1200, 610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.add(titi);
		this.setVisible(true);
		int delay = 10; // millisecond

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				go();
			}
		};

		time.schedule(task, delay, 10);
	}

	public void go() {
		if (i < liste.size()
				&& ((400 - liste.get(i).getY()) <= this.getHeight() - 50)
				&& ((400 - liste.get(i).getY()) > 0)
				&& (liste.get(i).getX() < this.getWidth() - 50)) {

			titi.setPosX((int) (liste.get(i).getX() * 100));
			titi.setPosY((int) (400 - liste.get(i).getY()));

			titi.setPosBecX((int) (liste.get(i+50).getX()));
			titi.setPosBecY((int) (400 - liste.get(i+50).getY()));
			
			this.repaint();
			i = i + 30;
			dessinerObstacle(this.getGraphics());
		}
	}

	public static void main(String args[]) {
		/*
		 * Random rand2 = new Random(); int coef = rand2.nextInt(2) + 1;
		 * 
		 * 
		 * 
		 * Random rand = new Random();
		 * 
		 * float k = rand.nextFloat() * 3 + 1;
		 */
		int cpt = 0;
		coef = 2;

		k = (float) 1.26;

		Equation eq = new Equation(coef);

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
		new Plateau();
	}

	public ArrayList<Point> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Point> liste) {
		Plateau.liste = liste;
	}

	public ArrayList<Point> getListeBec() {
		return listeBec;
	}

	public void setListeBec(ArrayList<Point> listeBec) {
		Plateau.listeBec = listeBec;
	}

	public int getI() {
		return i;
	}

	public void dessinerObstacle(Graphics g) {
		g.drawOval(obs.getPosObX(), obs.getPosObY(), obs.getObTaille(), obs.getObTaille());
	}
		// this.setBackground(Color.BLUE);

}
