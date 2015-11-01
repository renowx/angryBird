package modele;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import tests.Point;

public class Panneau extends JPanel {

	private int posX = 5;
	private int posY = 300;
	private int posXo = 550;
	private int posYo = 0;
	private int posXo2 = 650;
	private int posYo2 = 400;
	private ArrayList<Point> pts = new ArrayList<>();

	public void paintComponent(Graphics g) {

		// g.setColor(Color.red);
		g.drawOval(posX, posY, 50, 50);
		//bec
		//g.drawPolygon(new int[]{posX+50, posX+50, posX+60}, new int[]{posY+20, posY+30, posY+25}, 3);
		//g.drawRect(posXo, posYo, 25, 550);
		g.drawOval(posXo2, posYo2, 50, 50);
		
		/*----Tracage de la trajectoire------*/
		for (int i=0; i<pts.size();i++){
			g.fillOval((int)pts.get(i).x+25,(int)pts.get(i).y+25, 5, 5);
		}
		pts.add(new Point(posX,posY));
		// Utilisation de Methode par la suite de type Circle(),
		// Rectangle() ...
		// Pour eviter trop de variables de position

	}

	public int getPosXo2() {
		return posXo2;
	}

	public void setPosXo2(int posXo2) {
		this.posXo2 = posXo2;
	}

	public int getPosYo2() {
		return posYo2;
	}

	public void setPosYo2(int posYo2) {
		this.posYo2 = posYo2;
	}

	public int getPosXo() {
		return posXo;
	}

	public void setPosXo(int posXo) {
		this.posXo = posXo;
	}

	public int getPosYo() {
		return posYo;
	}

	public void setPosYo(int posYo) {
		this.posYo = posYo;
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

}
