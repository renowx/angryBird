package tests;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

import modele.Obstacle;

public class OiseauTest extends JPanel {

	private int posX;
	private int posY;
	private int posBecX;
	private int posBecY;
	private ArrayList<Point> pts = new ArrayList<>();
	private float angle;

	Timer time = new Timer();
	int i = 1;
	private static ArrayList<Point> liste = new ArrayList<Point>();
	private static ArrayList<Point> listeBec = new ArrayList<Point>();

	public void paintComponent(Graphics g) {
		g.drawOval(posX, posY, 50, 50);
		
		g.drawLine(posX+25, posY+25, posBecX, posBecY);

		for (int i = 0; i < pts.size(); i++) {

			if (i % 10 == 0) {
				g.fillOval((int) pts.get(i).getX() + 25, (int) pts.get(i)
						.getY() + 25, 5, 5);
			}

		}
		pts.add(new Point(posX, posY));

	}

	public OiseauTest(int posXtemp, int posYtemp, int posBecXtemp,
			int posBecYtemp, float angle) {
		this.posX = posXtemp;
		this.posY = posYtemp;
		this.posBecX = posBecXtemp;
		this.posBecY = posBecYtemp;
		this.angle = angle;
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

	public int getPosBecX() {
		return posBecX;
	}

	public void setPosBecX(int posBecX) {
		this.posBecX = posBecX;
	}

	public int getPosBecY() {
		return posBecY;
	}

	public void setPosBecY(int posBecY) {
		this.posBecY = posBecY;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getAngle() {
		return angle;
	}

	public Point creationPoint() {
		return new Point(posX, posY);

	}

	public int getTaille() {
		// TODO Auto-generated method stub
		return 0;
	}

}
