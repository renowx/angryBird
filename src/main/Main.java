
 package main;

import Jalon2.Controlleur.Controlleur;
import Jalon2.Modele.Modele;
import Jalon2.Vue.Scene;
import static Jalon2.Vue.Scene.s;


public class Main {

	public static void main(String args[]) {
           
                
                Modele modele= new Modele();
                Controlleur c= new Controlleur(modele);
		s = new Scene(modele,c);
                // impossible de lancer letsGo dans la classe mouse relased car cette classe ne rend pas la 
                // main sur l'affichage. 
                while(true){
                    while(!s.bView.mouseRelease){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {

                        }
                    }

                    s.bView.controlleur.letsGo();
                    s.bView.mouseRelease=false;
                }
             
                
	}

}