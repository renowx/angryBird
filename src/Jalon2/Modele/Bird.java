package Jalon2.Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import modele.Point;

public class Bird extends Observable {
	private int x;
	private int y;
	private int taille;
	private List<Point> listePts = new ArrayList<>();

	public Bird(int posX, int posY, int tailleBird) {
		this.setX(posX);
		this.setY(posY);
		this.setTaille(tailleBird);
	}

	/**
	 * Méthode permettant de définir les 2 coordonnées de l'oiseau d'un coup
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		this.setY(y);
		this.setX(x);
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Méthode permettant de récuperer la coordonnée en y de l'oiseau
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Méthode permettant de défniir la coordonnée en y de l'oiseau
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
		setChanged();
		notifyObservers();
	}

	/**
	 * Méthode permettant de récuperer la coordonnée en x de l'oiseau
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Méthode permettant de défniir la coordonnée en x de l'oiseau
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
		setChanged();
		notifyObservers();
	}

	/**
	 * Méthode permettant de récuperer la taille de l'oiseau
	 * 
	 * @return
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Méthode permettant de définir la taille de l'oiseau
	 * 
	 * @param taille
	 */
	public void setTaille(int taille) {
		this.taille = taille;
		setChanged();
		notifyObservers();
	}

	public boolean isOn(int x, int y) {
		int borneSupX = this.getX() + this.getTaille();
		int borneInfX = this.getX() - this.getTaille();
		int borneSupY = this.getY() + this.getTaille();
		int borneInfY = this.getY() - this.getTaille();
		if (x <= borneSupX && x >= borneInfX && y <= borneSupY
				&& y >= borneInfY) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean readyForFire(int x, int y, Point prec){
		if (x < prec.getX() && y > prec.getY()){
			return true;
		} else {
			return false;
		}
	}

}
