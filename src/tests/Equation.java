package tests;


public class Equation {
	private int coef;
	private float k;
	public Equation(int sqrt){
		this.coef = sqrt;
	}
	public double f(double t){
		return t;
	}
	
	public double g(double t, float k){
		
		return k*Math.sin(0.3*t*coef)*200;
		
	}
	//calcul de la dérivée
	public double derivG(double t, float k) {
		return 60*k*coef*Math.cos((3*coef*t/10));
	}
	
	public double derive(double t, float k){
		return 0.3*Math.cos(0.3*t*coef)*200;
	}
	
	public int getSqrt(){
		return coef;
	}
        public Equation(int sqrt, float k) {
		this.coef = sqrt;
		this.k = k;
	}

	

	public double g(double t) {
		return k * Math.sin(0.3 * t * coef) * 200;
	}

	public double derive(double t) {
		return 0.3 * Math.cos(0.3 * t * coef) * 200;
	}

	public double tangente(double x, double t) {

		return derive(t) * (x - t) + g(t);
	}
        
      
	
}
