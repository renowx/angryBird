package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tests.Jeu;

public class TestJeu {

	@Test
	public void testCalc() {
		Jeu jeu = new Jeu();
		assertTrue(jeu.run());
	}

	@Test
	public void testGo() {
		Jeu jeu = new Jeu();
		assertTrue(jeu.oiseauAvance());
	}

	@Test
	public void testArretObs() {
		Jeu jeu = new Jeu();
		assertTrue(jeu.oiseauArret());
	}

}
