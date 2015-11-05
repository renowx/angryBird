package modele;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ObstacleTest extends JPanel{
	private int posObX;
	private int posObY;
	private int tailleOb;
	
	public ObstacleTest(int x, int y, int taille){
		this.posObX = x;
		this.posObY = y;
		this.tailleOb = taille;
	}
	
	public void paintComponent(Graphics g){
		g.drawOval(this.posObX, this.posObY, this.tailleOb, this.tailleOb);
	}
	
	public void afficheObstacle(){
		this.repaint();
	}
	
	public void setPosObX(int x){
		this.posObX = x;
	}
	
	public int getPosObX(){
		return posObX;
	}
	
	public void setPosObY(int y){
		this.posObY = y;
	}
	
	public int getPosObY(){
		return posObX;
	}
	
	public void setPosTaille(int taille){
		this.tailleOb = taille;
	}
	
	public int getObTaille(){
		return tailleOb;
	}
}
