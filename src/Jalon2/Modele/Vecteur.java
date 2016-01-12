/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalon2.Modele;

/**
 * représente le déplacement de l'oiseau le nombre de pixels
 * 
 * @author Ludovic
 */
public class Vecteur {
	private int x;
	private int y;

	public Vecteur(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Retourne la valeur de la variable x du Vecteur
	 * 
	 * @return int
	 */
	public int getX() {
		return x;
	}

	/**
	 * Affecte une valeur à la variable x du Vecteur
	 * 
	 * @param int x : valeur à affecter
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Retourne la valeur de la variable y du Vecteur
	 * 
	 * @return int
	 */
	public int getY() {
		return y;
	}

	/**
	 * Affecte une valeur à la variable y du Vecteur
	 * 
	 * @param int y : valeur à affecter
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Retourne une String contenant la valeur en x et la vitesse en y du
	 * vecteur
	 * 
	 * @return String : int x, int y
	 **/
	@Override
	public String toString() {
		return "vitesse x: " + x + " vitesse y: " + y;
	}

}
