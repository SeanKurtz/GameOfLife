package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Panel extends JPanel{
	

	private final int WIDTH = 600, HEIGHT = 600;
	private int widthCells, heightCells;
	private int cellWidthPx, cellHeightPx;
	
	private Controller controller;
	private int button = -1;
	private boolean paint = false;
	private int clickX = -1;
	private int clickY = -1;
	private int x = - 1;
	private int y = -1;

	
	public Panel(Controller controller) {
		this.controller = controller;
		widthCells = controller.getWidth();
		heightCells = controller.getHeight();
		cellWidthPx = WIDTH / widthCells;
		cellHeightPx = HEIGHT / heightCells;
		initPanel();
		initListeners();
		setFocusable(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH,HEIGHT);
	}
	private void initPanel() {
		setSize(WIDTH,HEIGHT);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	private void initListeners() {
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_SPACE) {
					controller.nextGeneration();
					repaint();
				}
				else if (key == KeyEvent.VK_C) {
					controller.clearBoard();
					repaint();
				}
			}
			public void keyReleased(KeyEvent e) {
				
			}

			public void keyTyped(KeyEvent e) {
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button = e.getButton();
				clickX = e.getX();
				clickY = e.getY();
				x = clickX;
				y = clickY;
				paint = true;
				
				int cellX = x / cellWidthPx;
				int cellY = y / cellHeightPx;
				if (button == MouseEvent.BUTTON1) {
					controller.setCell(true, cellX, cellY);
				}
				else if (button == MouseEvent.BUTTON3) {
					controller.setCell(false, cellX, cellY);
				}
				
				repaint();
			}
			public void mouseReleased(MouseEvent e) {
				button = -1;
				clickX = -1;
				clickY = -1;
				x = -1;
				y = -1;
				paint = false;
			}
		});
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e) {
				
			}
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				if (paint) {
					int cellX = x / cellWidthPx;
					int cellY = y / cellHeightPx;
					if (button == MouseEvent.BUTTON1) {
						controller.setCell(true, cellX, cellY);
					}
					else if (button == MouseEvent.BUTTON3) {
						controller.setCell(false, cellX, cellY);
					}
					repaint();
				}
			
			}
		});
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				g.drawRect(i*cellWidthPx, j*cellHeightPx, cellWidthPx, cellHeightPx);
			}
		}
		g.setColor(Color.BLACK);
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				if (controller.isAlive(i,j)) {
					g.fillRect(i*cellWidthPx, j*cellHeightPx, cellWidthPx, cellHeightPx);
				}
				
			}
		}
	}
}
