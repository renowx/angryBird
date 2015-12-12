

package Jalon2.Vue;

import Jalon2.Controlleur.Controlleur;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Jalon2.Modele.Bird;
import Jalon2.Modele.Modele;



/**
 * Sera la vue, qui affichera l'oiseau et les obstacles en fonction des données contenues  dans modele.
 * @author ouvryl
 */
public class Scene extends JFrame implements Observer{
        Modele modele;
	private static Bird b = new Bird(100, 500, 50);
	public static Scene s;
	BirdView bView;
        Controlleur c;
        
	
	
	public Scene(Modele modele,Controlleur c){
                bView= new BirdView(b, modele,c);
                this.modele=modele;
                this.c=c;
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
                Modele modele= new Modele();
                Controlleur c= new Controlleur(modele);
		s = new Scene(modele,c);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}
