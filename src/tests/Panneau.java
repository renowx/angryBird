package tests;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {

	private int posX = 5;
	private int posY = 300;
	private int posXo = 550;
	private int posYo = 0;
	private int posXo2 = 650;
	private int posYo2 = 400;

	public void paintComponent(Graphics g) {

		// g.setColor(Color.red);
		g.drawOval(posX, posY, 50, 50);
		//g.drawRect(posXo, posYo, 25, 550);
		g.drawOval(posXo2, posYo2, 50, 50);

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
