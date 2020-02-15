package gameoflife;

/**
 * Main class for Game of Life application.
 * @author Sean Kurtz
 *
 */
public class GameOfLife {
	/**
	 * Entry point.
	 * @param args Unused
	 */
	public static void main(String[] args) {
		Controller game = new Controller();
		game.start(30,30);
	}
}
