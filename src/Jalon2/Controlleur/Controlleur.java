
package Jalon2.Controlleur;

import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;
import java.awt.Point;



/**
 *
 * @author Ludovic
 */
public class Controlleur {
    Modele modele;
  
    
    public Controlleur(Modele modele){
        this.modele=modele;
        
         
            
        }
    
    /**
     * Fonction utilisée pour voir le déplacement du cercle quand l'utilisateur clique dessus
     * @param x la postion de l'oiseau
     * @param y la position de l'oiseau
     */
    public void PositionOiseau(int x, int y){
        modele.PositionBird(x, y);
        
    }

    public void CalculerVecteurVitesse(Point pa, Point pb) {
        Vecteur vevteurVitesseOiseau=new Vecteur(pb.x-pa.x, pb.y-pa.y);
        modele.setVecteurBird(vevteurVitesseOiseau);
   
    }
    
    
    
}

