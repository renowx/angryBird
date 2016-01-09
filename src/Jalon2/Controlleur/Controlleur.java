package Jalon2.Controlleur;

import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Jalon2.Controlleur.Transformation.passageRepereBG;
import static Jalon2.Controlleur.Transformation.passageRepereHG;

/**
 * La position de l'oiseau arrive avec le repère en haut à gauche ( SWING) elle
 * est changée, en repères en bas à gauche pour faire les calculs, rechangée
 * avec le repère en haut à gauche et renvoyée au modèle.
 * 
 */

public class Controlleur {
	Modele modele;

	public Controlleur(Modele modele) {
		this.modele = modele;
	}

	/**
	 * Fonction utilisée pour voir le déplacement du cercle lorsque
	 * l'utilisateur clique dessus
	 * 
	 * @param int x la postion de l'oiseau
	 * @param int y la position de l'oiseau
	 */
	public void PositionOiseau(int x, int y) {
		modele.PositionBird(x, (y));

	}

	/**
	 * Calcul du vecteur vitesse entre un point A et un point B, modification
	 * direct dans la classe modèle et création d'un Vecteur
	 * 
	 * @param Point
	 *            pa, le point A
	 * @param Point
	 *            pb, le point B
	 **/
	public void CalculerVecteurVitesse(Point pa, Point pb) {

		pb.y = passageRepereBG(pb.y);

		System.out.println("pa " + pa + " pb " + pb);
		Vecteur vecteurVitesseOiseau = new Vecteur(pa.x - pb.x, pa.y - pb.y);
		modele.setVecteurBird(vecteurVitesseOiseau);

	}

	/**
	 * cette Fonction change la position de l'oiseau Bird b en fonction de sa
	 * dernière position puis modifie son vecteur vitesse
	 * 
	 **/
	public void CalculeNouvellePositionBird() {
		Bird b = modele.getBird();
		b.setY(passageRepereBG(b.getY()));
		// attention changement de repère avant d'envoyer les donnée au modèle
		modele.PositionBird(b.getX() + b.getVitesse().getX(),
				(passageRepereHG(b.getY() - b.getVitesse().getY())));

		b.getVitesse().setY(b.getVitesse().getY() - 10); // valeur de
															// l'apesenteur a
															// voir si il faut
															// la modifier ou
															// non

	}

	/**
	 * Fonction apellée par mouseRealesed qui répète à l'oiseau d'avancer,
	 * toutes les x secondes. Cela permet entre autre de ne pas être gêné si
	 * l'utilisateur clique alors que l'oiseau est en vol ; (Pas de rappel de la
	 * fonction mousePressed)
	 */
	public void letsGo() {
		int i = 0; // arrêt en fonction du nombre de point pour le moment
		while (i < 50 && !modele.collision()) {
			CalculeNouvellePositionBird();
			System.out.println("1 temps i:" + i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {

			}
			i++;
		}

	}

}
