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
    
    public Obstacle(int x, int y){
        this.setX(x);
        this.setY(y);
        
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
    
    
}
