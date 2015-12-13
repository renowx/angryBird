package Jalon2.Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import Jalon2.Controlleur.Vecteur;
import java.awt.Point;
import  Jalon2.Controlleur.Transformation;

public class Bird  {
	private int x;
	private int y;
	private int taille;
        private Vecteur vitesse;
	private List<Point> listePts = new ArrayList<>();

	public Bird(int posX, int posY, int tailleBird) {
		this.setX(posX);
		this.setY(posY);
		this.setTaille(tailleBird);
	}

	/**
	 * Définis les coordonnées de l'oiseau
	 * @param int x
	 * @param int y
	 **/
	public void setPosition(int x, int y) {
		this.setY(y);
		this.setX(x);

	}

	/**
	 * Récupère la coordonnée y de l'oiseau
	 * 
	 * @return int y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Affecte une valeur à la coordonnée en y de l'oiseau
	 * 
	 * @param int y : la valeur à affecter
	 */
	public void setY(int y) {
		this.y = y;

	}

	/**
	 * Récupère la coordonnée x de l'oiseau
	 * 
	 * @return int x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Affecte une valeur à la coordonnée en x de l'oiseau
	 * 
	 * @param int x : la valeur à affecter
	 */
	public void setX(int x) {
		this.x = x;

	}

	/**
	 * Renvoie la taille de l'oiseau
	 * 
	 * @return int taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Affecte une taille à l'oiseau
	 * 
	 * @param int taille : valeur à affecter
	 */
	public void setTaille(int taille) {
		this.taille = taille;

	}

	/**
	 * Vérifie si le point (x,y) se situe sur l'oiseau
	 * @param int x
	 * @param int y
	 * @return boolean
	 **/
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
	
	/**
	 * Vérifie si l'oiseau est pret a etre tire
	 * @param int x
	 * @param int y
	 * @param Point prec
	 **/
	public boolean readyForFire(int x, int y, Point prec){
		if (x < prec.getX() && y > prec.getY()){
			return true;
		} else {
			return false;
		}
	}

    /**
     * Renvoi le Vecteur vitesse
     * @return Vecteur vitesse
     */
    public Vecteur getVitesse() {
        return vitesse;
    }

    /**
     * Affecte une vitesse au Vecteur vitesse de l'oiseau
     * @param vitesse the vitesse to set
     */
    public void setVitesse(Vecteur vitesse) {
        this.vitesse = vitesse;
    }
    
    /**
     * Affecte une valeur au point y du Vecteur
     * @param int y : la valeur à affecter
     **/
    public void setVitesseY(int y){
        vitesse.setY(y);
    }
    
    /**
     * Affecte une valeur au point x du Vecteur
     * @param int x : la valeur à affecter
     **/
    public void setVitesseX(int x){
        vitesse.setX(x);
    }
    
    /**
     * Renvoie une String contenant la valeur de x, la valeur de y,
     * et la valeur du toString du Vecteur vitesse
     * 
     * @return String : int x, int y, Vecteur Vitesse
     **/
        @Override
    public String toString(){
        return "x:"+x+" y: "+y+"\n"+vitesse;
        
    }

}

