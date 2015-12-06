

package Jalon2.Vue;

<<<<<<< HEAD
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Jalon2.Modele.Bird;
=======
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import Jalon2.Modele.Collision;
import Jalon2.Modele.Obstacle;
import Jalon2.Modele.Oiseau;
>>>>>>> origin/master



/**
 * Sera la vue, qui affichera l'oiseau et les obstacles en fonction des données contenues  dans modele.
 * @author ouvryl
 */
public class Scene extends JFrame implements Observer{
    
<<<<<<< HEAD
	private static Bird b = new Bird(100, 500, 50);
	BirdView bView = new BirdView(b);
=======
	Oiseau bird = new Oiseau();
	Obstacle obst = new Obstacle(500, 300, 80);
	Collision colision = new Collision();
	private ArrayList<Point> pts = new ArrayList<>(); //---Points deplacment oiseau---//
	private ArrayList<Point> ptsBec = new ArrayList<>();
	static boolean pointille = false;
>>>>>>> origin/master
	
	public Scene(){
		this.setTitle("Angry_Bird");
		this.setSize(1200, 710);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
<<<<<<< HEAD
		this.setVisible(true);
		this.setContentPane(bView);
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		new Scene();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
=======
		//this.setContentPane(pan);
		this.setVisible(true);
	}
		
		
		
		public void paintComponent(Graphics g){
			g.drawOval(bird.getPosBecX(), bird.getPosBecY(), 50, 50);

			bird.setTmpX(bird.getPosBecX() + 25);
			bird.setTmpY(bird.getPosBecY() + 25);
		

			System.out.println(bird.getPosBecDX() + "dx <=> dy " + bird.getPosBecDY());
			System.out.println(bird.getPosBecX() + "x <=> dy " + bird.getPosBecY());

			g.drawLine(bird.getPosBecDX() + 25, bird.getPosBecDY() + 25, bird.getTmpX() + 20, bird.getTmpY() + 5);

			/*----Tracage de la trajectoire------*/
			for (int i = 0; i < pts.size(); i++) {
				g.fillOval((int) pts.get(i).x + 25, (int) pts.get(i).y + 25, 5, 5);
				g.fillOval(bird.getX2(), bird.getY2(), 50, 50);
				pointille = true;
			}

			pts.add(bird.creationPoint());
			ptsBec.add(new Point(bird.getPosBecX(), bird.getPosBecY()));

			System.out.println("dessiner obstacle");
			dessinerObstacle(g);

		}

		public void dessinerObstacle(Graphics g) {
			try {
				System.out.println("dessiner obstacle panneaux");
				for (Obstacle o : colision.getListeObstacle()) {
					System.out.println(o);
					g.setColor(o.getCouleur());
					g.drawOval(o.getX(), o.getY(), o.getTaille(), o.getTaille());
				}
			} catch (Exception e) {
			};

			// this.setBackground(Color.BLUE);
		}
>>>>>>> origin/master
	
}
