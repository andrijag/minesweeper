package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.minefield.Field;

public class Minesweeper {
	private List<Field> fields;

	public Minesweeper() {
		this.fields = new ArrayList<>();
	}

	public void sweep(Field field) {
		fields.add(field);
		while (!fields.isEmpty()) {
			field = fields.remove(fields.size() - 1);
			if (field.isUncovered() || field.isFlagged())
				continue;
			uncover(field);
			if (!field.isMine() && field.getNumber() == 0)
				fields.addAll(field.getNeighbours());
		}
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
