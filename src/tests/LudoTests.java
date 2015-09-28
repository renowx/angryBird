/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Vue.Jframe;
import Vue.Panel;
import modele.Modele;

/**
 *
 * @author ouvryl
 */
public class LudoTests {

    
        public static void main(String[] args){
           // Jframe jf= new Jframe();
            //jf.add(new Panel());
            Modele modele = new Modele();
            System.out.println(modele.getListeObstacle());
        }
       
    }


