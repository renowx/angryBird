/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.Modele;

public class Jframe extends JFrame {

    Jpanel jpanel;
    Modele modele;

    public Jframe() {

        System.out.println("création de la Jframe.");
        modele = new Modele();
        jpanel = new Jpanel(this, modele);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(jpanel);
        //jpanel.setBackground(Color.yellow);
        this.setLocationRelativeTo(null);

    }

}
