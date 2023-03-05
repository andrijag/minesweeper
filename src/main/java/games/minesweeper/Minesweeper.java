package main.java.games.minesweeper;

import main.java.games.minesweeper.field.Field;

public class Minesweeper {
	public static void sweep(Field field) {
		if (field.isUncovered() || field.isFlagged())
			return;
		uncover(field);
		if (!field.isMine() && field.getNumber() == 0)
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}

	private static void uncover(Field field) {
		field.uncover();
		if (field.isMine())
			field.detonate();
	}

	public static void mark(Field field) {
		field.mark();
	}

	public static void chord(Field field) {
		if (!field.isUncovered())
			return;
		if (field.getNumber() == field.getNumberOfNeighbourFlags())
			for (Field neighbour : field.getNeighbours())
				sweep(neighbour);
	}
}
