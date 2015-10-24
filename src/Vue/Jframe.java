/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.Modele;
import modele.Oiseau;


public class Jframe extends JFrame {

    Jpanel jpanel;
    Modele modele;
    
	private Oiseau o; 
	
	Timer time = new Timer();
	int y,x;

    public Jframe() {

        System.out.println("création de la Jframe.");
        // code pour l'oiseau
        o= new Oiseau();
        
        
        this.setTitle("Angry_Bird");
		this.setSize(1200, 910);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setVisible(true);
		int delay = 10; // milliseconds
		
                // code pour les obstacles 
        modele = new Modele();
        jpanel = new Jpanel(this, modele);
        x =jpanel.getPosX();
        y= jpanel.getPosY();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(jpanel);
        //jpanel.setBackground(Color.yellow);
        this.setLocationRelativeTo(null);
        
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				go();
			}
		};

    }
    private void go() {
		int x = jpanel.getPosX(), y = jpanel.getPosY();

		x = jpanel.getPosX();
		y = jpanel.getPosY();
		x = x + 2;
		y = (int) Parabole(x, y);
		jpanel.setPosX(x);
		jpanel.setPosY(y);

		this.repaint();
		repaint();

		// Vitesse de deplacement pour les tests passage au Timer par la
		// suite

		// Arret de l'objet a ameliorer
		if (x == this.getWidth() - 100 || y == this.getWidth() - 100
				|| x == this.getHeight() - 100 || y == this.getHeight() - 100
				|| (x == jpanel.getPosXo2() && y == jpanel.getPosYo2()) || x <= 0
				|| y <= 0) {

		}
		if ((x >= jpanel.getPosXo2() - 25 && y <= jpanel.getPosYo2() - 25)) {

			x = jpanel.getPosXo2();
			y = jpanel.getPosYo2();
			x = x + 2;
			y = (int) Parabole(x, y);
			jpanel.setPosXo2(x);
			jpanel.setPosYo2(y);
			this.repaint();
			repaint();
		}

	}
    private float Parabole(float x, float y) {
		y = this.getHeight() - (float) (-((0.005) * (x * x)) + 4 * x + 2);
		return y;
	}

	private double Parabole(double a, double x) {
		return a * Math.pow(x, 2); // Math.pow(x,2) vaut x2
	}
    

}
