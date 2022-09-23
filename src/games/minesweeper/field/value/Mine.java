package games.minesweeper.field.value;

import games.minesweeper.field.Field;

public class Mine extends FieldValue {
	public Mine(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
		field.gameOver();
	}

	@Override
	public String toString() {
		return "*";
	}
}
