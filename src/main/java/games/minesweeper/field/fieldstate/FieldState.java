package main.java.games.minesweeper.field.fieldstate;

import main.java.games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public void sweep() {
		field.uncover();
		if (!field.isMine() && field.getNumber() == 0)
			for (Field neighbour : field.getNeighbours())
				neighbour.sweep();
	}

	public abstract void mark();

	public void chord() {
		if (field.getNumber() == field.neighbourFlags())
			for (Field neighbour : field.getNeighbours())
				neighbour.sweep();
	}
}