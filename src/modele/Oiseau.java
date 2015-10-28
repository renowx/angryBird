package modele;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import tests.Point;

public class Oiseau extends JPanel {

	private int posX = 5;
	private int posY = 300;
	private ArrayList<Point> pts = new ArrayList<>();
	
	public void paintComponent(Graphics g) {
		g.drawOval(posX, posY, 50, 50);
	//	g.drawPolygon(10, 10, 10);
		
		for (int i=0; i<pts.size();i+=3){
			g.fillOval((int)pts.get(i).x+3, (int)pts.get(i).y+4, 3, 3);
		}
		pts.add(new Point(posX,posY));
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Point2D creationPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTaille() {
		// TODO Auto-generated method stub
		return 0;
	}

}
