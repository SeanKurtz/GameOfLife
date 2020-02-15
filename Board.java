package gameoflife;

import java.util.Random;

public class Board {
	private int widthCells, heightCells;
	private boolean[][] cells;
	
	public Board(int widthCells, int heightCells) {
		this.widthCells = widthCells;
		this.heightCells = heightCells;
		init();
		randomBoard();
	}
	public int getWidth() {
		return widthCells;
	}
	public int getHeight() {
		return heightCells;
	}
	private void init() {
		cells = new boolean[widthCells][heightCells];
		clear();
	}
	public void clear() {
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				cells[i][j] = false;
			}
		}
	}
	public void randomBoard() {
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				if (Math.random() < 0.3) {
					cells[i][j] = true;
				}
				else {
					cells[i][j] = false;
				}
			}
		}
	}
	public void nextGeneration() {
		boolean[][] nextGen = new boolean[widthCells][heightCells];
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < widthCells; j++) {
				int neighbors = 0;
				for (int x = Math.max(0, i-1); x < Math.min(i+2, widthCells); x++) {
					for (int y = Math.max(0, j-1); y < Math.min(j+2, heightCells); y++) {
						if (x == i && y == j) {
							continue;
						}
						if (cells[x][y]) {
							neighbors++;
						}
					}
				}
				// Any live cell with fewer than two neighbors dies.
				if (cells[i][j] && neighbors < 2) {
					nextGen[i][j] = false;
				}
				// Any live cell with two or three neighbors lives.
				else if (cells[i][j] && (neighbors == 2 || neighbors == 3)) {
					nextGen[i][j] = true;
				}
				// Any live cell with more than three neighbors dies.
				else if (cells[i][j] && neighbors > 3) {
					nextGen[i][j] = false;
				}
				// Any dead cell with exactly three live neighbors becomes alive.
				else if (!cells[i][j] && neighbors == 3) {
					nextGen[i][j] = true;
				}
			}
		}
		cells = nextGen;
	}
	public void setCell(boolean alive, int x, int y) {
		if (x >= 0 && x < widthCells && y >= 0 && y < heightCells) {
			cells[x][y] = alive;
		}
		
	}
	public boolean isAlive(int x, int y) {
		if (x >= 0 && x < widthCells && y >= 0 && y < heightCells) {
			return cells[x][y];
		}
		return false;
	}
}
