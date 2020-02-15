package gameoflife;

public class Controller {
	private Window frame;
	private Board board;
	
	public void start(int xSize, int ySize) {
		board = new Board(xSize, ySize);
		frame = new Window(this);
	}
	public int getWidth() {
		return board.getWidth();
	}
	public int getHeight() {
		return board.getHeight();
	}
	public void nextGeneration() {
		board.nextGeneration();
	}
	public void setCell(boolean alive, int x, int y) {
		board.setCell(alive , x, y);
	}
	public boolean isAlive(int x, int y) {
		return board.isAlive(x, y);
	}
	public void clearBoard() {
		board.clear();
	}
}
