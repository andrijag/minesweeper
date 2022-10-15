package games.minesweeper.field.fieldvalue;

import games.minesweeper.field.Field;

public abstract class FieldValue {
	protected Field field;

	public FieldValue(Field field) {
		this.field = field;
	}

	public abstract void expose();
}
