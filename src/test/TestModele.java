package test;

import static org.junit.Assert.assertTrue;
import modele.Jeu;

import org.junit.Test;

public class TestModele {

	@Test
	public void testCreationModele() throws InterruptedException {
		Jeu jeu = new Jeu();
		Thread.sleep(2000);
		assertTrue(jeu.getPan().getModele().modeleCree());
	}

}
