package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public FieldState nextState1() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextState2() {
		return new Flagged(field);
	}

	@Override
	public String toString() {
		return ".";
	}
}
