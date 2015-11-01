/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.awt.Point;

/**
 *0.
 * Classe qui représente les Obstacles dans lequelles l'oiseau peut rentrée.
 * Ajouter une ennum avec rond et carrée pour le livrable 2;
 */
public class Obstacle {
    
    private int x;
    
    private int y;
    
    private int taille; 
    private Color couleur;
    
    public Obstacle(int x, int y, int taille){
        System.out.println("création d'un obtacle");
        this.setX(x);
        this.setY(y);
        this.taille=taille;
        couleur=Color.black;
        
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

    /**
     * @return the taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    public String toString(){
        return " x: "+this.getX()+" y: "+this.getY()+" taille: "+this.getTaille()+" couleur:"+this.getCouleur();
        
        
    }
    public Point creationPoint(){
        return new Point(x, y);
    }

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
   
    
    
}
