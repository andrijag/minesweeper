package games.minesweeper.field.fieldstate;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public void sweep() {
		field.expose();
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
