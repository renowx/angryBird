package modele;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import tests.AlexTests;
import tests.Equation;
import tests.Point;

public class AlexPanneau extends JPanel {

	private int posX = 5;
	private int posY = 300;
	private int posXo = 550;
	private int posYo = 0;
	private int posXo2 = 650;
	private int posYo2 = 400;
	
	private int posBecX = 5;
	private int posBecY = 300;
	private int posBecDX = 5;
	private int posBecDY = 300;
	private int tmpX = 0;
	private int tmpY = 0;
	
	private ArrayList<Point> pts = new ArrayList<>();
	private ArrayList<Point> ptsBec = new ArrayList<>();
	
	public void paintComponent(Graphics g) {
		
		// g.setColor(Color.red);
		g.drawOval(posX, posY, 50, 50);
		g.drawOval(posXo2, posYo2, 50, 50);

		//variables tampons
		tmpX = posBecX+25;
		tmpY = posBecY+25;
	
		System.out.println(posBecDX+"dx <=> dy "+posBecDY);
		System.out.println(posBecX+"x <=> dy "+posBecY);

		//bec triangulaire
		//g.drawPolygon(new int[]{posBecDX+25, posBecDX+25, tmpX+20},
		//		new int[]{posBecDY+25, posBecDY+25+10, tmpY+5}, 3);


		//bec linéaire
		g.drawLine(posBecDX+25, posBecDY+25, tmpX+20, tmpY+5);
		
		/*----Tracage de la trajectoire------*/
		for (int i=0; i<pts.size();i++){
			g.fillOval((int)pts.get(i).x+25,(int)pts.get(i).y+25, 5, 5);
		}
		pts.add(new Point(posX,posY));
		ptsBec.add(new Point(posBecX,posBecY));
	
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
	
	public int getPosBecDX() {
		return posBecDX;
	}

	public void setPosBecDX(int posBecDX) {
		this.posBecDX = posBecDX;
	}

	public int getPosBecDY() {
		return posBecY;
	}

	public void setPosBecDY(int posBecDY) {
		this.posBecDY = posBecDY;
	}
	
}
