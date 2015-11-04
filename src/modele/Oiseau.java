package modele;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;



public class Oiseau {

    private int posX = 5;
    private int posY = 530;
    private ArrayList<Point> pts = new ArrayList<>();

    public void paintComponent(Graphics g) {
        g.drawOval(posX, posY, 50, 50);
	//	g.drawPolygon(10, 10, 10);


    
                
		g.drawPolygon(new int[]{posX+50, posX+50, posX+60}, new int[]{posY+20, posY+30, posY+25}, 3);
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

    /**
     * Le point qui désiqne la position acutelle de l'oiseau
     * @return la position de l'oiseau.
     */
    public Point creationPoint() {
		return new Point(posX, posY);
		
	}

	public int getTaille() {
		// TODO Auto-generated method stub
		return 0;
	}
          public String toString() {
        return "Oiseau x: "+posX+" y:"+posY;

    }


}
