package modele;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JPanel;



public class Panneau extends JPanel {
	
	private int posX = 5;
	private int posY = 300;
	private int posXo = 550;
	private int posYo = 0;
	private int posXo2 = 650;
	private int posYo2 = 400;
	
	private int posBecX = 5;
	private int posBecY = 300;
	private int posBec1X = 5;
	private int posBec1Y = 300;
	private int posBec2X = 5;
	private int posBec2Y = 300;
        private int tmpX = 0;
	private int tmpY = 0;
	static boolean pointille = false;
	static boolean obs = false;
        private ArrayList<Point> ptsBec = new ArrayList<>();
       
	private int posBecDX = 5;
	private int posBecDY = 300;
        Modele modele;

	private int pos = 3;
	int taille = 50;
	/*private boolean color = false;
	
	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}*/
	
	private ArrayList<Point> pts = new ArrayList<>();

	public void paintComponent(Graphics g) {
<<<<<<< Updated upstream
	g.drawOval(posX, posY, 50, 50);
=======
		g.drawOval(posX, posY, 50, 50);
>>>>>>> Stashed changes

		tmpX = posBecX + 25;
		tmpY = posBecY + 25;

		System.out.println(posBecDX + "dx <=> dy " + posBecDY);
		System.out.println(posBecX + "x <=> dy " + posBecY);

		g.drawLine(posBecDX + 25, posBecDY + 25, tmpX + 20, tmpY + 5);

		/*----Tracage de la trajectoire------*/
		for (int i = 0; i < pts.size(); i++) {
			g.fillOval((int) pts.get(i).x + 25, (int) pts.get(i).y + 25, 5, 5);
			g.fillOval(posXo2, posYo2, 50, 50);
			pointille = true;
		}

		pts.add(this.creationPoint());
		ptsBec.add(new Point(posBecX, posBecY));

		System.out.println("dessiner obstacle");
		dessinerObstacle(g);

	}
	
	public void dessinerObstacle(Graphics g) {
            try{
            System.out.println("dessiner obstacle panneaux");
		for (Obstacle o : modele.getListeObstacle()) {
		System.out.println(o);
			g.setColor(o.getCouleur());
			g.drawOval(o.getX(), o.getY(), o.getTaille(), o.getTaille());
		}
            }catch(Exception e){};
                
		// this.setBackground(Color.BLUE);
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
	
	public int getPos(){
		return pos;
	}
	
	public void setPos(int pos){
		this.pos = pos;
	}

	public int getPosBec1X() {
		return posBec1X;
<<<<<<< Updated upstream
	}

	public void setPosBec1X(int posBec1X) {
		this.posBec1X = posBec1X;
	}

	public int getPosBec1Y() {
		return posBec1Y;
	}

	public void setPosBec1Y(int posBec1Y) {
		this.posBec1Y = posBec1Y;
	}

	public int getPosBec2X() {
		return posBec2X;
	}

	public void setPosBec2X(int posBec2X) {
		this.posBec2X = posBec2X;
=======
	}

	public void setPosBec1X(int posBec1X) {
		this.posBec1X = posBec1X;
	}

	public int getPosBec1Y() {
		return posBec1Y;
	}

	public void setPosBec1Y(int posBec1Y) {
		this.posBec1Y = posBec1Y;
	}

	public int getPosBec2X() {
		return posBec2X;
	}

	public void setPosBec2X(int posBec2X) {
		this.posBec2X = posBec2X;
	}

	public int getPosBec3Y() {
		return posBec2Y;
	}

	public void setPosBec3Y(int posBec3Y) {
		this.posBec2Y = posBec3Y;
	}
	public Point creationPoint() {
		return new Point(posX, posY);
		
	}
	public int getTaille() {
		// TODO Auto-generated method stub
		return this.taille/2;
>>>>>>> Stashed changes
	}
        public void setModele(Modele modele){
            this.modele=modele;
        }

    public ArrayList<Point> getPts() {
        return pts;
    }

<<<<<<< Updated upstream
	public int getPosBec3Y() {
		return posBec2Y;
	}

	public void setPosBec3Y(int posBec3Y) {
		this.posBec2Y = posBec3Y;
	}
	public Point creationPoint() {
		return new Point(posX, posY);
		
=======
    public int getPosBecDX() {
		return posBecDX;
	}

	public void setPosBecDX(int posBecDX) {
		this.posBecDX = posBecDX;
	}

	public int getPosBecDY() {
		return posBecY;
>>>>>>> Stashed changes
	}
	public int getTaille() {
		// TODO Auto-generated method stub
		return this.taille/2;
	}
        public void setModele(Modele modele){
            this.modele=modele;
        }

    public ArrayList<Point> getPts() {
        return pts;
    }

<<<<<<< Updated upstream
=======
	public void setPosBecDY(int posBecDY) {
		this.posBecDY = posBecDY;
	}
>>>>>>> Stashed changes
	
}
