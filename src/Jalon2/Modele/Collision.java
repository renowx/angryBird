package Jalon2.Modele;

import java.util.ArrayList;

/**
 * Gère la collison entre les l'oiseau et les Obstacle ou les bord.
 * 
 * @author ouvryl
 */
public class Collision {

	Modele modele;
	Bird bird = modele.getBird();
	
	ArrayList<Obstacle> listeObstacle = modele.getObstacles();



/*	public Obstacle obstColision() {
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
	}*/
	public boolean collision() {
		int x = bird.getX();
		int y = bird.getY();
		for (int i = 0; i < listeObstacle.size(); i++) {
			if (x >= listeObstacle.get(i).getX()
					- listeObstacle.get(i).getTaille()
					&& x <= listeObstacle.get(i).getX()
							+ listeObstacle.get(i).getTaille()
					&& y >= listeObstacle.get(i).getY()
							- listeObstacle.get(i).getTaille()
					&& y <= listeObstacle.get(i).getY()
							+ listeObstacle.get(i).getTaille()) {
				return true;
			}
		}
		return false;
	}

}
