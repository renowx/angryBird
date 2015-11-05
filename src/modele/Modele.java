/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Random;

public class Modele {

	private ArrayList<Obstacle> listeObstacle;
	static boolean creationModele = false;

	public Modele() {
		System.out.println("crÃ©ation modele");
		int nbObstacle = 5;
		int i = 0;
		int taille = 0;
		listeObstacle = new ArrayList<Obstacle>();
		listeObstacle.add(new Obstacle(700, 200, 75));
		while (i != nbObstacle) {
			taille = listeObstacle.size() - 1;
			listeObstacle.add(new Obstacle(500, (getListeObstacle().get(taille)
					.getY() + 100), 50 + new Random().nextInt(50))); 
			i++;
		}
		creationModele = true;

	}

	/**
	 * @return the listeObstacle
	 */
	public ArrayList<Obstacle> getListeObstacle() {
		return listeObstacle;
	}

	/**
	 * @param listeObstacle
	 *            the listeObstacle to set
	 */
	public void setListeObstacle(ArrayList<Obstacle> listeObstacle) {
		this.listeObstacle = listeObstacle;
	}

	/**
	 *
	 * @return l'obctacle dans lequelle l'oiseau est rentrÃ©e, null tant que
	 *         l'oiseau n'est pas rentrÃ©e dans un obstacle.
	 */
	public Obstacle oiseauRencontreObstacle(Oiseau oiseau) {
		int distance = 0; // distance entre l'oiseau et les obstacles
		for (Obstacle obstacle : listeObstacle) {
			// System.out.println("obstacle" + obstacle);
			if (oiseau != null && obstacle != null) {
				distance = (int) oiseau.creationPoint().distance(
						obstacle.creationPoint()); // calcule de la distance

			}
			if ((oiseau.getTaille() + (obstacle.getTaille() / 2) + 10) > distance) { // car
																						// rayon
				System.out.println("retourne cette obstacle toruvÃ©e: "
						+ obstacle);
				return obstacle;
			}
		}
		return null;
	}

	public Obstacle oiseauRencontreObstacle(Panneau oiseau) {
		int distance = 0; // distance entre l'oiseau et les obstacles
		for (Obstacle obstacle : listeObstacle) {
			// System.out.println("obstacle" + obstacle);
			if (oiseau != null && obstacle != null) {
				distance = (int) oiseau.creationPoint().distance(
						obstacle.creationPoint()); // calcule de la distance

			}
			if ((oiseau.getTaille() + (obstacle.getTaille() / 2) - 3) > distance) { // car
																					// rayon
				System.out.println("retourne cette obstacle toruvÃ©e: "
						+ obstacle);
				return obstacle;
			}
		}
		return null;
	}

	public boolean modeleCree() {
		if (creationModele == true) {
			return true;
		} else {
			return false;
		}
	}

}
