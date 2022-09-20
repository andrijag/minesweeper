package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public abstract void sweep();
	
	public abstract void flag();

	public abstract void chord();

	public abstract FieldState nextUncoveredState();

	public abstract FieldState nextFlaggedState();
}
