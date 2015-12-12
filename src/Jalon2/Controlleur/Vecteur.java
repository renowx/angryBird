/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalon2.Controlleur;

/**
 * représente le déplacement de l'oiseau le nombre de pixels 
 * @author Ludovic
 */
public class Vecteur {
    private int x;
    private int y;
    public Vecteur(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "vitesse x: "+x+" vitesse y: "+y;
    }
    
}
