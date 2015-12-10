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
	}

	public void paintComponent(Graphics g) {
		g.drawOval(b.getX(), b.getY(), b.getTaille(), b.getTaille());
		System.out.println("Oiseau dessiné !");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
