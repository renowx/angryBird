/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jalon2.Modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * 0. Classe qui reprÃ©sente les Obstacles dans lequelles l'oiseau peut rentrÃ©e.
 * Ajouter une ennum avec rond et carrÃ©e pour le livrable 2;
 */
public class Obstacle extends JPanel {

	private int x;

	private int y;
	private Point c;
	private boolean actif;
	private boolean carre;

	private int taille;
	private Color couleur;

	public Obstacle(Point c) {
		System.out.println("crÃ©ation d'un obtacle");
		this.c = c;
		this.taille = 50;
		this.actif = true;
		couleur = Color.black;
	}

	public boolean isActif() {
		return this.actif;
	}

	public void setActif(boolean t) {
		this.actif = t;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille
	 *            the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String toString() {
		return " x: " + this.getX() + " y: " + this.getY() + " taille: "
				+ this.getTaille() + " couleur:" + this.getCouleur();

	}

	public Point getC() {
		return c;
	}

	public void setC(int x, int y) {
		this.c.x = x;
		this.c.y = y;
	}

	public boolean isCarre() {
		return this.carre;
	}

	public void setCarre(boolean b) {
		this.carre = b;
	}

	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur
	 *            the couleur to set
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

}

