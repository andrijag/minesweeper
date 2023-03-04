package main.java.games.minesweeper;

import main.java.games.minesweeper.field.Field;

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
		field.uncover();
		if (field.isMine()) {
			field.detonate();
		} else
			minefield.incrementNumberOfUncoveredFields();
	}

	public void mark(Field field) {
		if (field.isFlagged()) {
			field.mark();
			if (!field.isFlagged())
				minefield.decrementNumberOfFlags();
		} else {
			field.mark();
			if (field.isFlagged())
				minefield.incrementNumberOfFlags();
		}
	}

	public void chord(Field field) {
		if (!field.isUncovered())
			return;
		if (field.getNumber() == field.getNumberOfNeighbourFlags())
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}
}
