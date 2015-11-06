package modele;

public class Equation {
	private int coef;
	private float k;

	/**
	 * Constructeur d'une equation
	 * 
	 * @param sqrt
	 */
	public Equation(int sqrt) {
		this.coef = sqrt;
	}

	/**
	 * Créer une équation en fonction de t
	 * 
	 * @param t
	 * @return
	 */
	public double f(double t) {
		return t;
	}

	/**
	 * Créer une équation en fonction de t
	 * 
	 * @param t
	 * @param k
	 * @return
	 */
	public double g(double t, float k) {

		return k * Math.sin(0.3 * t * coef) * 200;

	}

	/**
	 * Calcul de la dérivée
	 * 
	 * @param t
	 * @param k
	 * @return
	 */
	public double derivG(double t, float k) {
		return 60 * k * coef * Math.cos((3 * coef * t / 10));
	}

	/**
	 * Calcul de la dérivée
	 * 
	 * @param t
	 * @param k
	 * @return
	 */
	public double derive(double t, float k) {
		return 0.3 * Math.cos(0.3 * t * coef) * 200;
	}

	/**
	 * Retourne sqrt
	 * 
	 * @return
	 */
	public int getSqrt() {
		return coef;
	}
	/**
	 * Constructeur de l'équation
	 * @param sqrt
	 * @param k
	 */
	public Equation(int sqrt, float k) {
		this.coef = sqrt;
		this.k = k;
	}
	/**
	 * Créer une équation en fonction de t
	 * @param t
	 * @return
	 */
	public double g(double t) {
		return k * Math.sin(0.3 * t * coef) * 200;
	}
	/**
	 * Créer une dérivée
	 * @param t
	 * @return
	 */
	public double derive(double t) {
		return 0.3 * Math.cos(0.3 * t * coef) * 200;
	}
	/**
	 * Créer la tangente 
	 * @param x
	 * @param t
	 * @return
	 */
	public double tangente(double x, double t) {

		return derive(t) * (x - t) + g(t);
	}

}
