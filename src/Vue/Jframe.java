/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Modele;
import modele.Obstacle;
import modele.Oiseau;
import modele.Panneau;

public class Jframe extends JFrame {

	private ArrayList<Point> pts;

	private Oiseau oiseau;
	private Modele modele;
	Timer time = new Timer();
	// int y,x;
	int delay = 10; // milliseconds

	public Jframe() {
		oiseau = new Oiseau();
		System.out.println("création de la Jframe.");
		// code pour l'oiseau
		oiseau.setPosX(5);
		oiseau.setPosY(300);
		modele = new Modele();

		this.setTitle("Angry_Bird");
		this.setSize(1200, 910);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setVisible(true);

		// code pour les obstacles
		modele = new Modele();

		// x =jpanel.getPosX();
		// y= jpanel.getPosY();
		pts = new ArrayList<Point>();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setContentPane(jpanel);
		// jpanel.setBackground(Color.yellow);
		this.setLocationRelativeTo(null);

	}

	public void lancementOiseau() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				go();

			}
		};
		time.schedule(task, delay, 10);
	}

	private void go() {
		Obstacle obstacle = null;
		/*
		 * int x = jpanel.getPosX(), y = jpanel.getPosY();
		 * 
		 * x = jpanel.getPosX(); y = jpanel.getPosY(); x = x + 2; y = (int)
		 * Parabole(x, y); jpanel.setPosX(x); jpanel.setPosY(y);
		 */

		oiseau.setPosX(oiseau.getPosX() + 2);
		oiseau.setPosY((int) Parabole(oiseau.getPosX(), oiseau.getPosY()));

		this.repaint();

		// Vitesse de deplacement pour les tests passage au Timer par la
		// suite

		// Arret de l'objet a ameliorer
		obstacle = modele.oiseauRencontreObstacle(oiseau);

		if (obstacle == null) { // pas de rencontre d'obstacle mais peut être
								// rencontre du bord
			if (oiseau.getPosX() == this.getWidth() - 100
					|| oiseau.getPosY() == this.getWidth() - 100
					|| oiseau.getPosX() == this.getHeight() - 100
					|| oiseau.getPosY() == this.getHeight() - 100) {
				System.out.println("arret de l'objet");
				// time.cancel();
				System.exit(0);

			}

		} else {
			for (Obstacle obs : modele.getListeObstacle()) {
				if (obs == obstacle) {
					obs.setCouleur(Color.blue);
					time.cancel();
				}
			}
			System.out.println("obstacle trouvée");
		}

	}

	public void paint(Graphics g) {
		// g.setColor(Color.red);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawOval(oiseau.getPosX(), oiseau.getPosY(), 50, 50);
		// g.drawRect(posXo, posYo, 25, 550);
		// g.drawOval(posXo2, posYo2, 50, 50);

		/*----Tracage de la trajectoire------*/
		for (int i = 0; i < pts.size(); i += 2) {
			if (i % 20 == 0) {
				g.fillOval((int) pts.get(i).x + 25, (int) pts.get(i).y + 25, 5,
						5);
			}
		}
		pts.add(oiseau.creationPoint());
		// Utilisation de Methode par la suite de type Circle(),
		// Rectangle() ...
		// Pour eviter trop de variables de position
		// System.out.println("dessiner obstacle");
		dessinerObstacle(g);

	}

	private float Parabole(float x, float y) {
		y = this.getHeight() - (float) (-((0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	private double Parabole(double a, double x) {
		return a * Math.pow(x, 2); // Math.pow(x,2) vaut x2
	}

	public void dessinerObstacle(Graphics g) {

		for (Obstacle o : modele.getListeObstacle()) {
			// System.out.println("postion du x: "+o.getX()+" position du y: "+o.getY()+" taille: "+o.getTaille()+" couleur:"+o.getCouleur());
			g.setColor(o.getCouleur());
			g.drawOval(o.getX(), o.getY(), o.getTaille(), o.getTaille());
		}
		// this.setBackground(Color.BLUE);
	}

}
