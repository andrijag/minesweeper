package main.java.games.minesweeper;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import main.java.games.minesweeper.model.Game;
import main.java.games.minesweeper.view.View;

public class Application implements Runnable {
	private static final int NUMBER_OF_ROWS = 9;
	private static final int NUMBER_OF_COLUMNS = 9;
	private static final int NUMBER_OF_MINES = 10;

	@Override
	public void run() {
		JFrame frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Game game = new Game(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, NUMBER_OF_MINES);
		View view = new View(game);

		game.addObserver(view);
		game.notifyObservers();

		frame.add(view);
		frame.pack();
		frame.setVisible(true);
	}
}
