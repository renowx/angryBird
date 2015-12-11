

package Jalon2.Vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Jalon2.Modele.Bird;



/**
 * Sera la vue, qui affichera l'oiseau et les obstacles en fonction des données contenues  dans modele.
 * @author ouvryl
 */
public class Scene extends JFrame implements Observer{
    
	private static Bird b = new Bird(100, 500, 50);
	public static Scene s;
	BirdView bView = new BirdView(b);
	ObstacleView oView = new ObstacleView();
	
	public Scene(){
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
		s = new Scene();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}
