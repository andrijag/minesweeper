package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
		field.getValue().sweep();
		field.sweepHandle();
		field.validate();
	}

	@Override
	public void sweepRecursion() {
		field.getValue().sweep();
		field.sweepHandle();
	}

	@Override
	public void mark() {
		field.markHandle();
		field.incrementFlagCounter();
	}

	@Override
	public void chord() {
	}

	@Override
	public FieldState nextMarkedState() {
		return new Flagged(field);
	}

	@Override
	public String toString() {
		return ".";
	}
}
