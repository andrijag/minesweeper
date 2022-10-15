package games.minesweeper.field.fieldstate;

import games.minesweeper.field.Field;

public class Uncovered extends FieldState {
	public Uncovered(Field field) {
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
	}

	@Override
	public void chord() {
		field.chordHandle();
		field.validate();
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}