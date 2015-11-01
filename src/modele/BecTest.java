package modele;

import java.awt.Graphics;

public class BecTest {
	
	static Panneau cuit = new Panneau();
	
	public BecTest (Panneau o){
		this.cuit = o;
	}
	
	public static void main(String args[]) {
		
		
		BecTest b = new BecTest(cuit);
		int posX = cuit.getPosX();
		int posY = cuit.getPosY();
		
		cuit.getGraphics().drawPolygon(new int[]{posX+50, posX+50, posX+60}, new int[]{posY+20, posY+30, posY+25}, 3);

	}
}
