package Jalon2.Vue;

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

	private ArrayList<Obstacle> obstacles;
	Obstacle ob1 = new Obstacle(new Point(400,100));
	Obstacle ob2 = new Obstacle(new Point(800,400));
	
	MouvementObstacle ob3 = new MouvementObstacle(new Point(400,200));
	MouvementObstacle ob4 = new MouvementObstacle(new Point(700,500));
	MouvementObstacle ob5 = new MouvementObstacle(new Point(800,100));
	MouvementObstacle ob6 = new MouvementObstacle(new Point(1000,200));
	
	
	public ObstacleView(){
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
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
	
	public void paintComponent(Graphics g) {
		
		System.out.println(ob1.getC().x+" "+ob1.getC().y+" "+ob1.getTaille()+" "+ob1.getTaille());
		for (Obstacle o : obstacles) {

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
			
				
			}
		ob3.moveX();
		ob3.moveY();
		ob4.moveX();
		ob5.moveX();
		ob5.moveY();
		ob6.moveY();
		
		
		Scene.s.repaint();
		
	}
	
	
}
