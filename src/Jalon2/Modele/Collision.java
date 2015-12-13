package Jalon2.Modele;

import java.util.ArrayList;
import java.util.Random;

import modele.Panneau;

/**
 * Gère la collison entre les l'oiseau et les Obstacle ou les bord.
 * @author ouvryl
 */
public class Collision {
    
	Oiseau bird = new Oiseau();
	private ArrayList<Obstacle> listeObstacle;
	int nbObstacle;
        /*public void listeObstacle() {
		this.nbObstacle = 5;
        int i = 0;
        int taille = 0;
        listeObstacle = new ArrayList<Obstacle>();
        listeObstacle.add(new Obstacle(700, 200, 75));
        while (i != nbObstacle) {
            taille = listeObstacle.size() - 1;
            listeObstacle.add(new Obstacle(500, (getListeObstacle().get(taille).getY() + 100), 50 + new Random().nextInt(50))); // obstcle situÃ©e de 100 en dessous de l'obtacle prÃ©cÃ©dant, table variable entre 50 et 100
            i++;
        }
		
		
	}*/
	
	/**
	 * Retourne l'obstacle rencontré, s'il est rencontré
	 * @return obstacle
	 **/
	public Obstacle obstColision() {
		int distance = 0; // distance entre l'oiseau et les obstacles
		for (Obstacle obstacle : listeObstacle) {
			
			if (bird != null && obstacle != null) {
				distance = (int) bird.creationPoint().distance(
						obstacle.creationPoint()); // calcule de la distance

			}
			if ((bird.getTaille() + (obstacle.getTaille() / 2) - 3) > distance) { // car
																					// rayon
				System.out.println("retourne cette obstacle toruvÃ©e: "
						+ obstacle);
                                
				return obstacle;
			}
		}
		return null;
	}

	/**
	 * Retourne la liste des obstacles
	 * @return ArrayList<Obstacle>
	 **/
	public ArrayList<Obstacle> getListeObstacle() {
		return listeObstacle;
	}

	/**
	 * Affecte une liste d'obstacle à listeObstacle
	 * @param ArrayList<Obstacle>
	 **/
	public void setListeObstacle(ArrayList<Obstacle> listeObstacle) {
		this.listeObstacle = listeObstacle;
	}

}
