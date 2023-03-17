package main.java.games.minesweeper;

import main.java.games.minesweeper.minefield.Field;
import main.java.games.minesweeper.minefield.Minefield;

public class Minesweeper {
	private Minefield minefield;

	public Minesweeper(Minefield minefield) {
		this.minefield = minefield;
	}

	public void sweep(Field field) {
		if (field.isUncovered() || field.isFlagged())
			return;
		uncover(field);
		if (!field.isMine() && field.getNumber() == 0)
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}

	private void uncover(Field field) {
		minefield.uncover(field);
	}

	public void mark(Field field) {
		minefield.mark(field);
	}

	public void chord(Field field) {
		if (!field.isUncovered())
			return;
		if (field.getNumber() == field.getNumberOfNeighbourFlags())
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}
}
