package Jalon2.Controlleur;

import Jalon2.Modele.Bird;
import java.awt.Point;

public class Calculs {
	
	private int tmax = 1200;
	
	private double v;
	private int angle;
	private int pas;
	private final double ACCELERATION = -9.81;		
	double xV = v * Math.cos(angle);
    double yV = v * Math.sin(angle);
    double totalTime = - 2.0 * yV / ACCELERATION;
    double timeIncrement = totalTime / pas;
    double xIncrement = xV * timeIncrement;
	
	/**
	 * Calcul la distance entre 2 points, dont les coordonnees sont passées en parametres
	 * @param int, int, int, int
	 * @return int
	 **/
	public int distance (int x1, int y1, int x2, int y2){
		int dist = (int) Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
		return dist;
	}
	
	/**
	 * Prend un int en parametre pour le renvoyer en double
	 * @param int
	 * @return double
	 **/
	public double y(int t){
		return t;
	}
	
	/**
	 * Effectue un calcul à partir de l'entier t. Renvoie un double
	 * @param int
	 * @return double
	 **/
	public double yP(int t){
		return 10-((0.07)*(y(t)));
	}
	
	/**
	 * Renvoie un point approximatif de la courbe en affichant les donnees traitees
	 * @param int, float, int
	 * @return Point
	 **/
	public Point aproxCourbe(int x, float y, int t){
        
        y = (float) (yV * t + 0.5 * ACCELERATION * t * t);
        System.out.println("\t" + round2(x) + "\t" +
                           round2(y) + "\t" + round2(t));
        return new Point(x+1, (int) y);
	}
	
	/**
	 * Renvoie le calcul du point n+1
	 * @param double
	 * @return double
	 **/
	public double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
	
	/**
	 * Calcul l'angle, en radian, entre 2 points
	 * @param Point, Point
	 * @return double
	 **/
	public double angle(Point a, Point b){ 
		double distb = b.getX() - a.getX();
		double distc = b.getY() - a.getY();
		double coef = 180/Math.PI;
		double lol = Math.abs(Math.atan2(a.getY() - b.getY(), a.getX() - b.getX())*coef);
		//System.out.println("ab :" + distb + " bc :" + distc + " angle radian :" + div + "   " + lol);
		return lol;
	}
        
       
}

