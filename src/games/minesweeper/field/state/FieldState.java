package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public abstract void sweepHandle();

	public abstract void chordHandle();

	public abstract FieldState nextUncoveredState();

	public abstract FieldState nextFlaggedState();
}
