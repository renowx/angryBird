package tests;


public class Equation {
	private int coef;
	private float k;
	
	public Equation(int sqrt, float k){
		this.coef = sqrt;
		this.k = k;
	}
	public double f(double t){
		return t;
	}
	
	public double g(double t){
		
		return k*Math.sin(0.3*t*coef)*200;
		
	}
	
	public double derive(double t){
		return 0.3*Math.cos(0.3*t*coef)*200;
	}
	
	public double tangente(double x, double t) {
		
		return derive(t)*(x-t)+g(t); 
	}
	
	public int getSqrt(){
		return coef;
	}
}
