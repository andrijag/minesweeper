package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}
	
	public abstract void sweep();

	public abstract void sweepRecursion();
	
	public abstract void mark();

	public abstract void chord();
}
