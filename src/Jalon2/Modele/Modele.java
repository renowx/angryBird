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
 * Pour des raison de simplicité au niveau de la vue 
 * il y aura seulement la classe mogèle qui extends la classe observable.
 * (pour ne pas avoir à difenricier telle ou telle modèle pour la vue. 
 * @author ouvryl
 */
public class Modele extends Observable{
    Bird bird; // variable qui définit les positions de l'oiseau dans le modèle
    private ArrayList<Obstacle> obstacles; // liste qui définit les obstacles et leur position
    Obstacle ob1 = new Obstacle(new Point(400,100));
	Obstacle ob2 = new Obstacle(new Point(800,400));
	
	MouvementObstacle ob3 = new MouvementObstacle(new Point(400,200));
	MouvementObstacle ob4 = new MouvementObstacle(new Point(700,500));
	MouvementObstacle ob5 = new MouvementObstacle(new Point(800,100));
	MouvementObstacle ob6 = new MouvementObstacle(new Point(1000,200));
    
    public Modele(){
    obstacles = new ArrayList<>();
		
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
    
}