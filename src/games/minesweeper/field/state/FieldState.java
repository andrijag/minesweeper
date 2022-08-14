package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public abstract class FieldState {
	protected Field field;

	public FieldState(Field field) {
		this.field = field;
	}

	public abstract FieldState nextState1();

	public abstract FieldState nextState2();
}
