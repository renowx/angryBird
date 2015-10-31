package modele;

import java.awt.Graphics;

public class BecTest {
	
	private Oiseau cuit = new Oiseau();
	
	public BecTest (Oiseau o){
		this.cuit = o;
	}
	
	public void paintComponent(Graphics g) {
		
		Oiseau titi = new Oiseau();
		BecTest b = new BecTest(titi);
		int posX = titi.getPosX();
		int posY = titi.getPosY();
		
		g.drawPolygon(new int[]{posX+50, posX+50, posX+60}, new int[]{posY+20, posY+30, posY+25}, 3);

	}
}
