/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalon2.Modele;

import Jalon2.Vue.Scene;

/**
 * Classe qui permet de passer le repère du coin supérieur gauche au coin inférieur gauche.
 * 
 * <B>Attention valeur mis en dur pour la taille de la fenètre à changer si les valeurs change.</B>
 * 
 * @author Ludovic
 **/
public  class Transformation {
    
   
    
    public static int changerX(int x){
        return x;
    } 
    
    /**
     * Recupère la coordonée y d'un point et la passe dans le repère du coin inférieur gauche.
     * @param int y La coordonée en y du point
     * @return int la nouvelle coordonée en y.
     **/
    public static int passageRepereBG(int y){
         return 710-y;
     }
     
    /**
     *
     * Recupère la coordonée y d'un point et la passe dans le repère du coin supérieur gauche.
     * @param int y La coordonée en y du point
     * @return int la nouvelle coordonée en y.
     **/
    public static int passageRepereHG(int y){
         return 710-y;
     }
     
     
    
}
