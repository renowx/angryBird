/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jalon2.Modele;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Pour des raison de simplicité au niveau de la vue il y aura seulement la
 * classe modèle qui extends la classe observable. (pour ne pas avoir à
 * différencier telle ou telle modèle pour la vue. Coordonnée de l'oiseau en
 * repère normale ( hautGauche)
 * 
 * @author ouvryl
 */
public class Modele extends Observable {
	private Bird bird; // variable qui définit les positions de l'oiseau dans le
						// modèle
	private ArrayList<Obstacle> obstacles; // liste qui définit les obstacles et
											// leur position
	Obstacle ob1;
	Obstacle ob2;

	MouvementObstacle ob3;
	MouvementObstacle ob4;
	MouvementObstacle ob5;
	MouvementObstacle ob6;
	
	public Modele() {

		// mis en place des obstacles
		obstacles = new ArrayList<>();
		ob1 = new Obstacle(new Point(400, 100));
		ob2 = new Obstacle(new Point(800, 400));
		ob3 = new MouvementObstacle(new Point(400, 200));
		ob4 = new MouvementObstacle(new Point(700, 500));
		ob5 = new MouvementObstacle(new Point(800, 100));
		ob6 = new MouvementObstacle(new Point(1000, 200));

		ob1.setActif(false);
		ob2.setActif(false);

		ob3.setLimit_x(new int[] { 400, 500 });
		ob3.setLimit_y(new int[] { 200, 600 });
		ob3.setActif(true);

		ob4.setLimit_x(new int[] { 500, 1000 });
		ob4.setActif(true);
		ob4.setCarre(true);

		ob5.setLimit_x(new int[] { 700, 800 });
		ob5.setLimit_y(new int[] { 100, 300 });
		ob5.setActif(true);

		ob6.setLimit_y(new int[] { 200, 400 });
		ob6.setActif(true);
		ob6.setCarre(true);

		obstacles.add(ob1);
		obstacles.add(ob2);

		obstacles.add(ob3);
		obstacles.add(ob4);
		obstacles.add(ob5);
		obstacles.add(ob6);

		// mise en place du bird
		bird = new Bird(500, 700, 50);
	}

	/**
	 * Retourne la liste des obstacles
	 * @return ArrayList<Obstacle>
	 */
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	/**
	 * Affecte une liste d'obstacles à obstacles
	 * @param Arraylist<Obstacle>
	 **/
	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	/**
	 * Retourne l'oiseau
	 * @return Bird
	 */
	public Bird getBird() {
		return bird;
	}

	/**
	 * Affecte un Bird à bird
	 * @param Bird bird
	 **/
	public void setBird(Bird bird) {
		this.bird = bird;
	}

	/**
	 * Actualise la postiton de l'oiseau
	 * 
	 * @param int x
	 * @param int y
	 */
	public void PositionBird(int x, int y) {
		bird.setX(x);
		bird.setY(y);

		setChanged();
		notifyObservers();
	}

	public int getX() {
		return bird.getX();
	}
	
	/**
	 * Retourne la valeur de y de l'oiseau
	 * @return int
	 **/
	public int getY(){
		return bird.getY();
	}
	
	/**
	 * Affecte un Vecteur vitesse à l'oiseau
	 * @param Vecteur vevteurVitesseOiseau 
	 **/
	public void setVecteurBird(Vecteur vevteurVitesseOiseau) {
		bird.setVitesse(vevteurVitesseOiseau);
		// ici pas de set changed car cela n'affecte pas directement la vue.
	}

	public boolean collision() {
		int x = bird.getX();
		int y = bird.getY();
		if (estSurObsX(x) && estSurObsY(y)){
			System.out.println("collision !!!!");
			return true;
		}
		
		return false;
	}

	// Il semblerait que ça soit le changement de repère et donc de points qui empêche le déclenchement des collisions 
	public boolean estSurObsX(int x) {
		for (int i = 0; i < obstacles.size(); i++) {
			if ((x >= obstacles.get(i).getX() - obstacles.get(i).getTaille())
					&& (x <= obstacles.get(i).getX()
							+ obstacles.get(i).getTaille())){
				System.out.println("est Sur ObsX");
				return true;
			}
		}
		return false;
	}
	
	public boolean estSurObsY(int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			if ((y >= obstacles.get(i).getY() - obstacles.get(i).getTaille())
					&& (y <= obstacles.get(i).getY()
							+ obstacles.get(i).getTaille()*2)){
				System.out.println("est Sur ObsY");
				return true;
			}
		}
		return false;
	}

}
