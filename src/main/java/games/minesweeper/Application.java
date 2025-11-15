package main.java.games.minesweeper;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import main.java.games.minesweeper.model.Game;
import main.java.games.minesweeper.view.View;

public class Application implements Runnable {
	@Override
	public void run() {
		JFrame frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		int numberOfRows = 16;
		int numberOfColumns = 30;
		int numberOfMines = 99;
		Game game = new Game(numberOfRows, numberOfColumns, numberOfMines);
		View view = new View(game);

		game.addObserver(view);
		game.notifyObservers();

		frame.add(view);
		frame.pack();
		frame.setVisible(true);
	}
}
