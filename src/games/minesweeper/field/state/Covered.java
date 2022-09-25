package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
		field.sweepHandle();
		field.getValue().sweep();
		field.validate();
	}

	@Override
	public void sweepRecursion() {
		field.sweepHandle();
		field.getValue().sweep();
	}

	@Override
	public void mark() {
		field.setState(new Flagged(field));
		field.incrementFlagCounter();
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return ".";
	}
}
