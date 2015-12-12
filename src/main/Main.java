
 package main;

import Jalon2.Controlleur.Controlleur;
import Jalon2.Modele.Modele;
import Jalon2.Vue.Scene;
import static Jalon2.Vue.Scene.s;


public class Main {


            	public static void main(String args[]) {
                Modele modele= new Modele();
                Controlleur c= new Controlleur(modele);
                 new Scene(modele,c);
	}
        


}