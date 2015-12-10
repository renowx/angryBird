package Jalon2.Vue;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import java.awt.Point;
import Jalon2.Controlleur.Calculs;
import Jalon2.Controlleur.Moteur;
import Jalon2.Modele.Bird;

public class BirdView extends JPanel implements Observer {

	private Bird b;
	private Point pa;
	private Point pb;
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	public BirdView(Bird b) {
		this.b = b;
		this.addMouseListener(new MouseAdapter() {
			boolean good = false;
			Calculs a = new Calculs();

			@Override
			public void mousePressed(MouseEvent e) {
				if (b.isOn(e.getX(), e.getY())) {
					pa = new Point(e.getX(), e.getY());
					good = true;
				} else {
					System.out.println("Point hors oiseau");
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (b.readyForFire(e.getX(), e.getY(), pa) && good) {
					pb = new Point(e.getX(), e.getY());
					double angle = a.angle(pa, pb);
					System.out.println("a :" + (int) pa.getX() + "/"
							+ (int) pa.getY() + " b:" + (int) pb.getX() + "/"
							+ (int) pb.getY() + " angle:" + (int) angle + "°");
					int dist = a.distance((int)pa.getX(), (int)pa.getY(), (int)pb.getX(), (int)pb.getY());
					new Moteur().moteurPhysique((int)angle, dist*2);
				} else if (b.readyForFire(e.getX(), e.getY(), pa) && !good) {
					System.out.println("Premier point hors oiseau");
				} else {
					System.out.println("Points incorrects");
				}
			}
		});
		addObstacles();repaint();
	}

	public void paintComponent(Graphics g) {
		g.drawOval(b.getX(), b.getY(), b.getTaille(), b.getTaille());
		System.out.println("Oiseau dessiné !");
		for (Obstacle o : obstacles) {

				if (o.isActif()) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.RED);
				}

				if(!o.isCarre()){
					g.drawOval(o.getC().x, o.getC().y, o.getTaille(), o.getTaille());
				}else{
					g.drawRect(o.getC().x, o.getC().y, o.getTaille(), o.getTaille());
				}

			}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	public void addObstacles(){

		Obstacle ob1 = new Obstacle(new Point(this.getWidth() - 100, this.getHeight() -170));
		Obstacle ob2 = new Obstacle(new Point(this.getWidth() - 120,
				this.getHeight() - 270));
		Obstacle ob3 = new Obstacle(new Point(this.getWidth() - 140,
				this.getHeight() - 370));
		Obstacle ob4 = new Obstacle(new Point(this.getWidth() - 160,
				this.getHeight() - 470));
		Obstacle ob5 = new Obstacle(new Point(this.getWidth() - 180,
				this.getHeight() - 600));
		Obstacle ob6 = new Obstacle(new Point(this.getWidth() - 600,
				this.getHeight() - 180));
		Obstacle ob7 = new Obstacle(new Point(this.getWidth() - 200,
				this.getHeight() - 150));

		MouvementObstacle ob8 = new MouvementObstacle(new Point(this.getWidth() - 400,
				this.getHeight() - 550));
		ob8.setLimit_x(new int[]{this.getWidth() - 400, this.getWidth() - 400});
		ob8.setLimit_y(new int[]{this.getHeight() - 550, this.getHeight() - 400});

		MouvementObstacle ob9 = new MouvementObstacle(new Point(this.getWidth() - 1000,
				this.getHeight()/3));
		ob9.setLimit_x(new int[]{this.getWidth() - 1000, this.getWidth() - 800});
		ob9.setLimit_y(new int[]{this.getHeight()/3, this.getHeight()/3});
		ob9.setCarre(true);

		obstacles.add(ob1);
		obstacles.add(ob2);
		obstacles.add(ob3);
		obstacles.add(ob4);
		obstacles.add(ob5);
		obstacles.add(ob6);
		obstacles.add(ob7);
		obstacles.add(ob8);
		obstacles.add(ob9);	
	}

}
