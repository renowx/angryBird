package Jalon2.Modele;

import java.awt.Point;

public class MouvementObstacle extends Obstacle {
	private int[] limit_x = { 0, 0 };
	private int[] limit_y = { 0, 0 };
	private boolean goDown = true;
	private boolean toRight = true;

	public MouvementObstacle(Point c) {
		super(c);
	}

	// théoriquement méthode move x et move y à déplacer dans la classe
	// controlleur,
	// mais cela compliquerait les calculs
	public void moveY() {
		if (this.limit_y[0] != this.limit_y[1]) {
			if (super.getC().getY() <= this.getLimit_y()[0]) {
				goDown = true;
			} else if (super.getC().getY() >= this.getLimit_y()[1]) {
				goDown = false;
			}
		}

		if (goDown) {
			super.setC(super.getC().x, super.getC().y + 1);
		} else {
			super.setC(super.getC().x, super.getC().y - 1);
		}
	}

	public void moveX() {
		if (limit_x[0] != limit_x[1]) {
			if (super.getC().getX() <= this.getLimit_x()[0]) {
				toRight = true;
			} else if (super.getC().getX() >= this.getLimit_x()[1]) {
				toRight = false;
			}

			if (toRight) {
				super.setC(super.getC().x + 1, super.getC().y);
				// super.setX(super.getX()+1);
			} else {
				super.setC(super.getC().x - 1, super.getC().y);
				// super.setX(super.getX()-1);
			}
		}
	}

	public int[] getLimit_x() {
		return limit_x;
	}

	public void setLimit_x(int[] limit_x) {
		this.limit_x = limit_x;
	}

	public int[] getLimit_y() {
		return limit_y;
	}

	public void setLimit_y(int[] limit_y) {
		this.limit_y = limit_y;
	}
}
