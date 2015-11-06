
 package main;

import modele.Jeu;

public class Main {


	public static void main(String[] args) {

		System.out.println("Début");
		int nbLancer = 0;

		while (nbLancer != 10) {
			new Jeu();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
			}
			System.out.println("test");
			nbLancer++;
		}
	}

}