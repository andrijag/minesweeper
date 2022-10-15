package games.minesweeper.field.fieldstate;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}
	
	public abstract void sweep();
	
	public abstract void mark();

	public abstract void chord();
}
