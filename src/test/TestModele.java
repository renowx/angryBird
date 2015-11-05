package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.Jeu;

public class TestModele {

	@Test
	public void testCreationModele() {
		Jeu jeu = new Jeu();
		assertTrue(jeu.getPan().getModele().modeleCree());
	}

}
