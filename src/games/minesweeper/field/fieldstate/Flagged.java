package games.minesweeper.field.fieldstate;

import games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
		super(field);
	}
	
	@Override
	public void sweep() {
	}

	@Override
	public void sweepRecursion() {
	}

	@Override
	public void mark() {
		field.setState(new Unknown(field));
		field.decrementNFlags();
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return ">";
	}
}
