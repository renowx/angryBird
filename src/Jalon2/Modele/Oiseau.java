package Jalon2.Modele;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author ouvryl
 */
public class Oiseau {
	
    private int x;
    private int y;
    private int x2 = 650;
	private int y2 = 400;
    
	int taille = 50;
    
    MouvementOiseau moveBird = new MouvementOiseau();
    
    private int posBecX = 5;
	private int posBecY = 300;
	private int posBec1X = 5;
	private int posBec1Y = 300;
	private int posBec2X = 5;
	private int posBec2Y = 300;
	private int tmpX = 0;
	private int tmpY = 0;
    private int posBecDX = 5;
	private int posBecDY = 300;
	
	public Oiseau(){
		System.out.println("création d'un oiseau");
		this.x=5;
		this.y=300;
		this.taille=50;
		
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

	public int getTaille() {
		return this.taille/2;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public Point creationPoint() {
		return new Point(getX(), getY());

	}

	public int getPosBecX() {
		return posBecX;
	}

	public void setPosBecX(int posBecX) {
		this.posBecX = posBecX;
	}

	public int getPosBecY() {
		return posBecY;
	}

	public void setPosBecY(int posBecY) {
		this.posBecY = posBecY;
	}

	public int getPosBec1X() {
		return posBec1X;
	}

	public void setPosBec1X(int posBec1X) {
		this.posBec1X = posBec1X;
	}

	public int getPosBec1Y() {
		return posBec1Y;
	}

	public void setPosBec1Y(int posBec1Y) {
		this.posBec1Y = posBec1Y;
	}

	public int getPosBec2X() {
		return posBec2X;
	}

	public void setPosBec2X(int posBec2X) {
		this.posBec2X = posBec2X;
	}

	public int getPosBec2Y() {
		return posBec2Y;
	}

	public void setPosBec2Y(int posBec2Y) {
		this.posBec2Y = posBec2Y;
	}

	public int getTmpX() {
		return tmpX;
	}

	public void setTmpX(int tmpX) {
		this.tmpX = tmpX;
	}

	public int getTmpY() {
		return tmpY;
	}

	public void setTmpY(int tmpY) {
		this.tmpY = tmpY;
	}

	public int getPosBecDX() {
		return posBecDX;
	}

	public void setPosBecDX(int posBecDX) {
		this.posBecDX = posBecDX;
	}

	public int getPosBecDY() {
		return posBecDY;
	}

	public void setPosBecDY(int posBecDY) {
		this.posBecDY = posBecDY;
	}
    
}

