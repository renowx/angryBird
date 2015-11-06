
 package main;

import tests.Jeu;

import Vue.Jframe;
import java.util.logging.Level;
import java.util.logging.Logger;
import tests.Jeu;
import tests.RenaudTest2;
import tests.ValTests;

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