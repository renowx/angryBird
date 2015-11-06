package modele;

public class Point {
	public double x;
	public double y;
	/**
	 * Construction d'un point
	 * @param x
	 * @param y
	 */
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	/**
	 * retourne la position X
	 * @return X
	 */
	public double getX(){
		return this.x;
	}
	/**
	 * Retourne la position Y
	 * @return Y
	 */
	public double getY(){
		return this.y;
	}
	/**
	 * To string d'un point et de ses attributs
	 */
	public String toString(){
		return " " + this.getX() + " " + this.getY();
 	}
}
