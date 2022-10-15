package games.minesweeper.field.fieldstate;

import games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
		field.sweepHandle();
		field.getValue().sweep();
	}

	@Override
	public void mark() {
		field.setState(new Flagged(field));
		field.incrementNFlags();
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return ".";
	}
}
