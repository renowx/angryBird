package tests;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class OiseauTest extends JPanel {
	
	private int posX;
	private int posY;
	private int posBecX;
	private int posBecY;

	private ArrayList<Point> pts = new ArrayList<>();
	
	public void paintComponent(Graphics g){
		
		g.drawOval(posX, posY, 50, 50);
		g.drawPolygon(new int[]{posX+50, posX+50, posX+60}, new int[]{posY+20, posY+30, posY+25}, 3);
		
		for (int i=0; i<pts.size();i++){
			
			if (i%10== 0){
			g.fillOval((int)pts.get(i).getX()+25,(int)pts.get(i).getY()+25, 5, 5);
			}
			
		}
		pts.add(new Point(posX,posY));
        
	}

	public OiseauTest(int posXtemp, int posYtemp, int posBecXtemp, int posBecYtemp){
		this.posX = posXtemp;
		this.posY = posYtemp;
		this.posBecX = posBecXtemp;
		this.posBecY = posBecYtemp;
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
	
}
