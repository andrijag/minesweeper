package main.java.games.minesweeper.view;

import javax.swing.JPanel;

import main.java.games.minesweeper.model.Game;
import main.java.games.minesweeper.model.util.Observer;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private Game game;

	public View(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void update() {
	}
}
