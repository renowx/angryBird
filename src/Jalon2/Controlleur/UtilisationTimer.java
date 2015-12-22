/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalon2.Controlleur;



/**
 *
 * @author Ludovic
 */
public class UtilisationTimer {
    
    public static void time(int miliseconde){
        
        javax.swing.Timer t= new javax.swing.Timer(miliseconde, null);
        t.start();
        
    }
    
}
