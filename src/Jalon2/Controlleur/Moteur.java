package Jalon2.Controlleur;

import Jalon2.Modele.Modele;

public class Moteur {

	public static final double Gravite = -9.81;
	
	/**
	 * Fonction de gestion du moteur physique, gérant la vitesse, l'angle lors de l'instant t, de l'oiseau
	 * @param int angle
	 * @param int vitesse
	 * @param Bird modele
	 **/
	public void moteurPhysique(int angle, int vitesse, Modele modele) {

		int pas = 2000;
		System.out.println();

		double xVitesse = vitesse * Math.cos(angle);
		double yVitesse = vitesse * Math.sin(angle);
		double totalTime = -2.0 * yVitesse / Gravite;
		double timeIncrement = totalTime / pas;
		double xIncrement = xVitesse * timeIncrement;

		double x = modele.getX();
		double y = 0.0;
		double yinit = modele.getY();
		double t = 0.0;
		System.out.println("pas\tx\ty");
		for (int i = 1; i <= pas; i++) {
			if (x < 1200 && y < 710 && y >= 0 && x >= modele.getX()) {
				t += timeIncrement;
				x += xIncrement + 1;
				if ((yinit - yVitesse * t + 0.5 * Gravite * t * t) <= 0) {
					y = Math.abs(yinit - yVitesse * t + 0.5 * Gravite * t * t);
				} else {
					y = yinit - yVitesse * t + 0.5 * Gravite * t * t;
				}

				round2(t);
				System.out.println(i + "\t" + Math.abs(round2(x)) + "\t"
						+ round2(y) + "\t");
				modele.PositionBird((int)Math.abs(round2(x)), (int)round2(y));

			}
		}

	}

	/**
	 * Calcul du point n+1
	 * @param double n
	 * @return double
	 **/
	public static double round2(double n) {
		return (int) (n * 100.0 + 0.5) / 100.0;
	}
}
