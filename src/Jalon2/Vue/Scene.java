package Jalon2.Vue;

import javax.swing.JFrame;

import Jalon2.Controlleur.Controlleur;
import Jalon2.Modele.Bird;

import Jalon2.Modele.Modele;

/**
 * Sera la vue, qui affichera l'oiseau et les obstacles en fonction des données
 * contenues dans modele.
 * 
 * @author ouvryl
 */
public class Scene extends JFrame {
	
	Modele modele;
	private static Bird b = new Bird(100, 500, 50);
	public static Scene s;
	public BirdView bView;
	Controlleur c;

	public Scene(Modele modele, Controlleur c) {
		bView = new BirdView(b, modele, c);
		this.modele = modele;
		this.c = c;
		this.setTitle("Angry_Bird");
		this.setSize(1200, 710);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setContentPane(bView);
		this.setVisible(true);

	}

	public static void main(String args[]) {

		Modele modele = new Modele();
		Controlleur c = new Controlleur(modele);
		s = new Scene(modele, c);
		// impossible de lancer letsGo dans la classe mouse relased car cette
		// classe ne rend pas la
		// main sur l'affichage.
		for (int i = 0; i < 5; i++) {
			
			while (!s.bView.mouseRelease) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) {

				}
			}

			                c.letsGo();
			s.bView.mouseRelease = false;

		}

	}

}
