package main.java.games.minesweeper;

import main.java.games.minesweeper.minefield.Field;

public class Minesweeper {

	public void sweep(Field field) {
		if (field.isUncovered() || field.isFlagged())
			return;
		uncover(field);
		if (!field.isMine() && field.getNumber() == 0)
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}
	
	private void uncover(Field field) {
		field.uncover();
		if (field.isMine())
			field.detonate();
	}

	public void mark(Field field) {
		field.mark();
	}

	public void chord(Field field) {
		if (!field.isUncovered())
			return;
		if (field.getNumber() == field.getNumberOfNeighbourFlags())
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}
}
