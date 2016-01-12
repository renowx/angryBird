package Jalon2.Controlleur;


import Jalon2.Modele.Modele;
import Jalon2.Modele.Obstacle;
import Jalon2.Modele.Oiseau;
import java.util.ArrayList;


/**
 * Gère la collison entre les l'oiseau et les Obstacle ou les bord.
 * @author ouvryl
 */
public class Collision {
    
    Modele modele;

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
    
    public Collision(Modele modele){
    this.modele=modele;
}
    
    /**
     * Retourne l'obstacle rencontré, s'il est rencontré
     * @return obstacle
     **/
    public Obstacle obstColision() {
        int distance = 0; // distance entre l'oiseau et les obstacles
        for (Obstacle obstacle : modele.getObstacles()) {
            
            if (modele.getBird() != null && obstacle != null) {
                
                distance =  modele.getBird().distanceObstacle(obstacle); // attention ici ce calcul 
                //est dans le modèle à changer si besoin
                System.out.println("obstacle: "+obstacle+" distance: "+distance);       

            }
            if ((modele.getBird().getTaille() + (obstacle.getTaille() / 2) - 3) > distance) { // car
                                                                                    // rayon
                System.out.println("retourne cette obstacle toruvée: "
                        + obstacle);
                                
                return obstacle;
            }
        }
        return null;
    }



}
