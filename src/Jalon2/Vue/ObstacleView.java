package Jalon2.Vue;

import Jalon2.Modele.Modele;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Jalon2.Modele.MouvementObstacle;
import Jalon2.Modele.Obstacle;

public class ObstacleView extends JPanel implements Observer {


	
	
	Modele modele;
	public ObstacleView(Modele modele){
	this.modele=modele;	
	modele.addObserver(this);	
		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
                       modele=(Modele)arg0; // car je n'ai pas réussie à passée l'array liste directement 
                       // au paint component
                       System.out.println("Uptdate obstacle view appelée");
                       repaint();
		          System.out.println("Position de l'oiseau: "+modele.getBird());

	}
	
	public void paintComponent(Graphics g) {
		
		//System.out.println(ob1.getC().x+" "+ob1.getC().y+" "+ob1.getTaille()+" "+ob1.getTaille());
		for (Obstacle o : modele.getObstacles()) {

				if (o.isActif()) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.RED);
				}

				if(!o.isCarre()){
					g.drawOval(o.getC().x, o.getC().y, o.getTaille(), o.getTaille());
				}else{
					g.drawRect(o.getC().x, o.getC().y, o.getTaille(), o.getTaille());
				}
                                if(o instanceof MouvementObstacle){
                                   MouvementObstacle mo= (MouvementObstacle) o;
                                   mo.moveX();
                                   mo.moveY();
                                }
			
				
			}
		
		
		
		//Scene.s.repaint(); mit en commentaire, voir si cela génère des bugs
		
	}
	
	
}
