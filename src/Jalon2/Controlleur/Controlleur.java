
package Jalon2.Controlleur;

import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Jalon2.Controlleur.Transformation.passageRepereBG;
import static Jalon2.Controlleur.Transformation.passageRepereHG;



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
        
        System.out.println("pa "+pa+" pb "+pb);
        Vecteur vecteurVitesseOiseau=new Vecteur(pa.x-pb.x, pa.y-pb.y);
        modele.setVecteurBird(vecteurVitesseOiseau);
   
    }
    
    /**
     *cette Fonction change la position de l'oiseau en fonction de sa dernière position
     * puis modifie le vecteur vitessse de l'oiseau
     * 
     */
    public void CalculeNouvellePositionBird(){
                Bird b=modele.getBird();
                b.setY(passageRepereBG(b.getY())); 
                // attention changement de repère avant d'envoyer les donnée au modèle
            modele.PositionBird(b.getX()+b.getVitesse().getX(),   
                    passageRepereHG(b.getY()-b.getVitesse().getY()));
            
            b.getVitesse().setY(b.getVitesse().getY()-10); // valeur de l'apesenteur a voir si il faut la modifier ou non
        }
    
    /**
     * Fonction apellée par mouseRealesed qui répète toutes les x seconde à l'oiseau d'anvencer.
     * cela permet entre autre de ne pas être géné si l'utilisateur clique pendat que l'oiseu est en vol ; 
     * cela ne rapelra pa la fonction mouse pressed
     */
    public void letsGo(){
        int i=0; // arrêt en fonction du nombre de point pour le moment
        while(i<15){
            CalculeNouvellePositionBird();
            System.out.println("1 temps i:"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
            i++;
        }
        
    }
    
    
    
}

