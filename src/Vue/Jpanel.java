/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import modele.Modele;
import modele.Obstacle;

/**
 * A voir si on fait une classe abstraite jpanel au cas ou on aurait besoin de
 * plusieur affichage différents.
 *
 * @author Ludovic
 */
public class Jpanel extends JPanel {

    private Modele modele;
    private Jframe jframe;

    public Jpanel(final Jframe jf, Modele modele) {
        System.out.println("création du Jpanel");
        jframe = jf;
        this.modele = modele;
        this.setVisible(true);
       

    }
    public Jpanel(){
        this.setVisible(true);
        modele= new Modele();
    }

    public void paint(Graphics g) {
            
            System.out.println("dessiner obstacle");
            dessinerObstacle(g);
        
    }

    /**
     * dessinne les obstacle dans le Jpanel;
     *
     * @param g le Graphics du Jpanel
     */
    public void dessinerObstacle(Graphics g) {
        g.drawRect(0, 0, 50, 50);
        for (Obstacle o : getModele().getListeObstacle()) {
            System.out.println("postion du x: "+o.getX()+" position du y: "+o.getY()+" taille: "+o.getTaille());
            g.drawOval(o.getX(), o.getY(), o.getTaille(), o.getTaille());
        }
        this.setBackground(Color.BLUE);
    }

    /**
     * @return the modele
     */
    public Modele getModele() {
        return modele;
    }

    /**
     * @param modele the modele to set
     */
    public void setModele(Modele modele) {
        this.modele = modele;
    }

    /**
     * @return the jframe
     */
    public Jframe getJframe() {
        return jframe;
    }

    /**
     * @param jframe the jframe to set
     */
    public void setJframe(Jframe jframe) {
        this.jframe = jframe;
    }

}
