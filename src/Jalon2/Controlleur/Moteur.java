package Jalon2.Controlleur;

import Jalon2.Modele.Bird;

public class Moteur {

	public static final double Gravite = -9.81;

	private Bird modele;

	public void moteurPhysique(int angle, int vitesse) {

		int pas = 1200;
		System.out.println();

		double xVitesse = vitesse * Math.cos(angle);
		double yVitesse = vitesse * Math.sin(angle);
		double totalTime = -2.0 * yVitesse / Gravite;
		double timeIncrement = totalTime / pas;
		double xIncrement = xVitesse * timeIncrement;

		double x = 0.0;
		double y = 0.0;
		double t = 0.0;
		System.out.println("pas\tx\ty");
		System.out.println("0\t0.0\t0.0");
		for (int i = 1; i <= pas; i++) {
			t += timeIncrement;
			x += xIncrement;
			y = yVitesse * t + 0.5 * Gravite * t * t;
			round2(t);
			System.out.println(i + "\t" + Math.abs(round2(x)) + "\t" + round2(y) + "\t");
		}
	}

	public static double round2(double n) {
		return (int) (n * 100.0 + 0.5) / 100.0;
	}
}
