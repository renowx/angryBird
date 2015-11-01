package tests;

import java.util.ArrayList;

public class Equation {
	private int sqrt;
	
	public Equation(int sqrt){
		this.sqrt = sqrt;
	}
	public double f(double t){
		return t;
	}
	
	public double g(double t, float k){
		
		return k*Math.sin(0.3*t*sqrt)*200;
		
	}
	//calcul de la dérivée
	public double derivG(double t, float k) {
		return 60*k*sqrt*Math.cos((3*sqrt*t/10));
	}
	
	public double derive(double t, float k){
		return 0.3*Math.cos(0.3*t*sqrt)*200;
	}
	
	public int getSqrt(){
		return sqrt;
	}
}
