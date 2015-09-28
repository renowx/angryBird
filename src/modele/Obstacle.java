/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *0.
 * Classe qui représente les Obstacles dans lequelles l'oiseau peut rentrée.
 * Ajouter une ennum avec rond et carrée pour le livrable 2;
 */
public class Obstacle {
    
    private int x;
    
    private int y;
    
    private int taille; 
    
    public Obstacle(int x, int y, int taille){
        this.setX(x);
        this.setY(y);
        this.taille=taille;
        
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
    
    
}
