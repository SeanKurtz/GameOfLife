package gameoflife;


import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class Mouse extends MouseInputAdapter{
	private int button = -1;
	private int xClick = -1;
	private int yClick = -1;
	private int x = -1;
	private int y = -1;
	private boolean paint = false;
	
	public void mousePressed(MouseEvent e) {
		this.button = e.getButton();
		this.xClick = e.getX();
		this.yClick = e.getX();
		this.x = xClick;
		this.y = yClick;
		paint = true;
	}
	public void mouseDragged(MouseEvent e) {
		if (paint) {
			xClick = x;
			yClick = y;
			x = e.getX();
			y = e.getY();
		}
	}
	public void mouseReleased(MouseEvent e) {
		button = - 1;
		xClick = -1;
		yClick = -1;
		x = -1;
		y = -1;
		paint = false;
	}
	public boolean shouldPaint() {
		return this.paint;
	}
	
}