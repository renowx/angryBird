package Jalon2.Vue;

import static Jalon2.Modele.Transformation.passageRepereBG;
import static Jalon2.Modele.Transformation.passageRepereHG;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Jalon2.Controlleur.Calculs;
import Jalon2.Controlleur.Controlleur;
import Jalon2.Controlleur.Moteur;
import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;

public class BirdView extends JPanel implements Observer {

	private Bird b;
	private Point pa;
	private Point pb;

	ObstacleView ov;
	Modele modele;
	public Boolean mouseRelease;
	Controlleur controlleur;

	public BirdView(final Bird b, final Modele modele, Controlleur c) {
		this.controlleur = c;
		ov = new ObstacleView(modele);
		this.modele = modele;
		modele.addObserver(this);
		this.b = b;
                mouseRelease=false;

		this.addMouseListener(new MouseAdapter() {
			boolean good = false;
			

			// a changé car rest bloqué sur mouse pressed
			@Override
			public void mousePressed(MouseEvent e) {
				if (b.isOn(e.getX(), e.getY())) {
					pa = new Point(e.getX(), e.getY());
					good = true;
				} else {
					System.out.println("Point hors oiseau");
				}

				pa = new Point(e.getX(), passageRepereBG(e.getY()));
				controlleur.PositionOiseau(pa.x, pa.y);
				System.out.println("L'oiseau est bougé par l'utilisateur");

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouse relachée");
				mouseRelease = true;
                                /*
				if (b.readyForFire(e.getX(), e.getY(), pa) && good) {
					pb = new Point(e.getX(), e.getY());
					double angle = a.angle(pa, pb);
					System.out.println("a :" + (int) pa.getX() + "/"
							+ (int) pa.getY() + " b:" + (int) pb.getX() + "/"
							+ (int) pb.getY() + " angle:" + (int) angle + "°");
					int dist = a.distance((int) pa.getX(), (int) pa.getY(),
							(int) pb.getX(), (int) pb.getY());
					new Moteur().moteurPhysique((int) angle,
							(int) (dist * 1.5), modele);
				} else if (b.readyForFire(e.getX(), e.getY(), pa) && !good) {
					System.out.println("Premier point hors oiseau");
				} else {
					System.out.println("Points incorrects");
				}
                                        */
				pb = new Point(e.getX(), (e.getY()));
				controlleur.CalculerVecteurVitesse(pa, pb);
				mouseRelease = true;
			}

		});

	}

	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("avant écran blanc");
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1200, 700);
		//System.out.println("après écran blan");
		g.setColor(Color.BLACK);
		g.drawLine(0, 650, Scene.s.getWidth(), 650);
		g.drawOval(modele.getBird().getX(), passageRepereHG(modele.getBird()
				.getY()), modele.getBird().getTaille(), modele.getBird()
				.getTaille());
		System.out.println("Oiseau dessiné ! pos x:" + modele.getBird().getX()
				+ " pos y:" + modele.getBird().getY());
		ov.paintComponent(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		modele = (Modele) arg0; // car je n'ai pas réussie à passée l'array
								// liste directement
		// au paint component
		repaint();
		System.out.println("Uptdate Bird view appelée");

	}

}
