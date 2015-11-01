/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import modele.Modele;
import modele.Obstacle;
import modele.Oiseau;
import tests.Point;

/**
 * A voir si on fait une classe abstraite jpanel au cas ou on aurait besoin de
 * plusieur affichage différents.
 *
 * @author Ludovic
 */
public class Jpanel extends JPanel {

    private Modele modele;
    private Jframe jframe;
    Oiseau oiseau = new Oiseau();
   // private int posX = 5;
	//private int posY = 300; // position x de l'oiseau
	//private int posXo = 550;
	//private int posYo = 0;
	//private int posXo2 = 650;
	//private int posYo2 = 400;
	private ArrayList<Point> pts;
        

    public Jpanel(final Jframe jf, Modele modele) {
        System.out.println("création du Jpanel");
        jframe = jf;
        this.modele = modele;
        this.setVisible(true);
        pts= new ArrayList<Point>();
        oiseau.setPosX(5);
        oiseau.setPosY(300);

    }
    
    
    
    public void paint(Graphics g) {
            // g.setColor(Color.red);
		g.drawOval(oiseau.getPosX(), oiseau.getPosY(), 50, 50);
		//g.drawRect(posXo, posYo, 25, 550);
		//g.drawOval(posXo2, posYo2, 50, 50);
		
		/*----Tracage de la trajectoire------*/
		for (int i=0; i<pts.size();i+=2){
			g.fillOval((int)pts.get(i).x+2, (int)pts.get(i).y+3, 5, 5);
		}
		pts.add(oiseau.creationPoint());
		// Utilisation de Methode par la suite de type Circle(),
		// Rectangle() ...
		// Pour eviter trop de variables de position
            System.out.println("dessiner obstacle");
            dessinerObstacle(g);
            
        
    }

    /**
     * dessinne les obstacle dans le Jpanel;
     *
     * @param g le Graphics du Jpanel
     */
    public void dessinerObstacle(Graphics g) {
        
        for (Obstacle o : getModele().getListeObstacle()) {
            System.out.println("postion du x: "+o.getX()+" position du y: "+o.getY()+" taille: "+o.getTaille()+" couleur:"+o.getCouleur());
            g.setColor(o.getCouleur());
            g.drawOval(o.getX(), o.getY(), o.getTaille(), o.getTaille());
        }
        //this.setBackground(Color.BLUE);
    }

	
    /*
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
    */
    /**
     * @return the modele
     */
    public Modele getModele() {
        return modele;
    }

    /**
     * @param modele the modele to set
     */
    public void setModele(Modele modele) {
        this.modele = modele;
    }

    /**
     * @return the jframe
     */
    public Jframe getJframe() {
        return jframe;
    }

    /**
     * @param jframe the jframe to set
     */
    public void setJframe(Jframe jframe) {
        this.jframe = jframe;
    }

}
