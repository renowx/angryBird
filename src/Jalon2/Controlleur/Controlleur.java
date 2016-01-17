package Jalon2.Controlleur;

import static Jalon2.Modele.Transformation.passageRepereBG;
import static Jalon2.Modele.Transformation.passageRepereHG;
import static java.lang.Thread.sleep;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;
import Jalon2.Modele.Obstacle;
import Jalon2.Modele.Vecteur;

/**
 * La position de l'oiseau arrive avec le repère en haut à gauche ( SWING) elle
 * est changée, en repères en bas à gauche pour faire les calculs, rechangée
 * avec le repère en haut à gauche et renvoyée au modèle.
 * 
 * @author Ludovic
 */
public class Controlleur {
	Modele modele;
	Collision collision;
	Obstacle o; // représente l'obstacle que recontre l'oiseau.

	public Controlleur(Modele modele) {
		this.modele = modele;
		o = null;
		collision = new Collision(modele);

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

		if (!modele.collision() && b.getX() < 1125 && b.getY() < 700) {
			b.setY(passageRepereBG(b.getY())); // Pourquoi changer de repère ?
												// ça complique tout... #Renaud
			// attention changement de repère avant d'envoyer les donnée au
			// modèle
			modele.PositionBird(b.getX() + b.getVitesse().getX(),
					(passageRepereHG(b.getY() - b.getVitesse().getY())));

			b.getVitesse().setY(b.getVitesse().getY() - 10*b.getPoids()); // valeur de
			System.out
					.println("afficheons les obstacle et l'oiseau positionnée en "
							+ modele.getBird()); // l'apesenteur
			for (Obstacle o : modele.getObstacles()) {
				System.out.println(o);
			}
		} else if (modele.collision()) {
			System.out
					.println("\n\n--------------------------------------collision--------------------------------------\n\n");
		}
	}

	/**
	 * Fonction apellée par mouseRealesed qui répète à l'oiseau d'avancer,
	 * toutes les x secondes. Cela permet entre autre de ne pas être gêné si
	 * l'utilisateur clique alors que l'oiseau est en vol ; (Pas de rappel de la
	 * fonction mousePressed)
	 */

	public void letsGo() {
		/**System.out.println("AVANT" + " letsGo");
		try {
			sleep(10);
		} catch (InterruptedException ex) {
			Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE,
					null, ex);
		}**/
		int i = 0; // arrêt en fonction du nombre de point pour le moment
		o = null;
		while (o == null || !modele.collision()) {
			CalculeNouvellePositionBird();
			//o = collision.obstColision();
			System.out.println("1 temps i:" + i);
			
			if (o != null || modele.collision()) {
				System.out
						.println("\n\n--------------------------------------collision--------------------------------------\n\n");
				try {
					Thread.sleep(4800);// pause de 5s ;
				} catch (InterruptedException ex) {
					ex.getStackTrace();
				}
			}
			try {
				Thread.sleep(100); // nouvelle postition toutes les 100
									// miliseconde
			} catch (InterruptedException ex) {

			}
			i++;

		}

	}


}
