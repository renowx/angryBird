package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modele.Panneau;

import org.junit.Test;

import tests.Jeu;

public class TestPanneau {

	@Test
	public void testPointille() {
		Panneau pan = new Panneau();
		assertFalse(pan.pointilleTrace());
	}

	@Test
	public void testPointille2() throws InterruptedException {
		Jeu jeu = new Jeu();
		assertTrue(jeu.getPan().pointilleTrace());
	}

	@Test
	public void testGeneObstacle() throws InterruptedException {
		Jeu jeu = new Jeu();
		Thread.sleep(2000);
		assertTrue(jeu.getPan().obstacleGene());
	}

}
