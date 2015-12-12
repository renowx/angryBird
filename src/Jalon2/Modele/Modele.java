/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jalon2.Modele;

import Jalon2.Controlleur.Vecteur;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Pour des raison de simplicité au niveau de la vue 
 * il y aura seulement la classe mogèle qui extends la classe observable.
 * (pour ne pas avoir à difenricier telle ou telle modèle pour la vue. 
 * @author ouvryl
 */
public class Modele extends Observable{
   private  Bird bird; // variable qui définit les positions de l'oiseau dans le modèle
    private ArrayList<Obstacle> obstacles; // liste qui définit les obstacles et leur position
        Obstacle ob1;
	Obstacle ob2;
	
	MouvementObstacle ob3;
	MouvementObstacle ob4 ;
	MouvementObstacle ob5;
	MouvementObstacle ob6;
    public Modele(){
                obstacles = new ArrayList<>();
               ob1 = new Obstacle(new Point(400,100));
                ob2 = new Obstacle(new Point(800,400));
                ob3 = new MouvementObstacle(new Point(400,200));
                ob4 = new MouvementObstacle(new Point(700,500));
                ob5 = new MouvementObstacle(new Point(800,100));
               ob6 = new MouvementObstacle(new Point(1000,200));
		
		ob1.setActif(false);
		ob2.setActif(false);
		
		ob3.setLimit_x(new int[]{400, 500});
		ob3.setLimit_y(new int[]{200, 600});
		ob3.setActif(true);
		
		ob4.setLimit_x(new int[]{500, 1000});
		ob4.setActif(true);
		ob4.setCarre(true);
		
		ob5.setLimit_x(new int[]{700, 800});
		ob5.setLimit_y(new int[]{100, 300});
		ob5.setActif(true);
		
		ob6.setLimit_y(new int[]{200, 400});
		ob6.setActif(true);
		ob6.setCarre(true);
		
		obstacles.add(ob1);
		obstacles.add(ob2);
		
		obstacles.add(ob3);
		obstacles.add(ob4);	
		obstacles.add(ob5);
		obstacles.add(ob6);
}

    /**
     * @return the obstacles
     */
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    /**
     * @param obstacles the obstacles to set
     */
    public void setObstacles(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * @return the bird
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * @param bird the bird to set
     */
    public void setBird(Bird bird) {
        this.bird = bird;
    }
    
    /**
     * Actualise la postiton du bird
     * @param x
     * @param y
     */
    public void PositionBird(int x, int y){
        bird.setX(x);
        bird.setY(y);
        setChanged();
        notifyObservers();
    }

    public void setVecteurBird(Vecteur vevteurVitesseOiseau) {
        bird.setVitesse(vevteurVitesseOiseau);
        // ici pas de set changed car cela n'affecte pas directement la vue.
    }
    
}
