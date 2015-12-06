package Jalon2.Controlleur;

import modele.Point;

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
	
	public int distance (int x1, int y1, int x2, int y2){
		int dist = (int) Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
		return dist;
	}
	
	public double y(int t){
		return t;
	}
	public double yP(int t){
		return 10-((0.07)*(y(t)));
	}
	
	public Point aproxCourbe(int x, float y, int t){
        
        y = (float) (yV * t + 0.5 * ACCELERATION * t * t);
        System.out.println("\t" + round2(x) + "\t" +
                           round2(y) + "\t" + round2(t));
        return new Point(x+1, (int) y);
	}
	
	public double round2(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
	
	public double angle(Point a, Point b){ 
		double distb = b.getX() - a.getX();
		double distc = b.getY() - a.getY();
		double coef = 180/Math.PI;
		double lol = Math.abs(Math.atan2(a.getY() - b.getY(), a.getX() - b.getX())*coef);
		//System.out.println("ab :" + distb + " bc :" + distc + " angle radian :" + div + "   " + lol);
		return lol;
	}
}

