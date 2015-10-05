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
    
    
    public Modele(){
        System.out.println("création modele");
        int  nbObstacle=5;
        int i=0;
        int taille=0;
        listeObstacle= new ArrayList<Obstacle>();
        listeObstacle.add(new Obstacle(1000, 200,75));
        while(i!=nbObstacle){
            taille=listeObstacle.size()-1;
            listeObstacle.add(new Obstacle(1000,(getListeObstacle().get(taille).getY()+100),50+new Random().nextInt(50))); // obstcle située de 100 en dessous de l'obtacle précédant, table variable entre 50 et 100
        i++;
        }
        
    }

    /**
     * @return the listeObstacle
     */
    public ArrayList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    /**
     * @param listeObstacle the listeObstacle to set
     */
    public void setListeObstacle(ArrayList<Obstacle> listeObstacle) {
        this.listeObstacle = listeObstacle;
    }
    
    /**
     *
     * @return l'obctacle dans lequelle l'oiseau est rentrée, null tant que l'oiseau n'est pas rentrée dans un obstacle.
     */
    public Obstacle oiseauRencontreObstacle(Oiseau o){
        int distance; // distance entre l'oiseau et les obstacles
        for(Obstacle obstacle: listeObstacle){
            distance=(int) o.creationPoint().distance(obstacle.creationPoint()); // calcule de la disatance 
            
            if(o.getTaille()+obstacle.getTaille()<distance){
                return obstacle;
            }
        }
        return null;
    }
    
}
