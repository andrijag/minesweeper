package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Uncovered extends FieldState {
	public Uncovered(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
	}

	@Override
	public void chord() {
		field.chordHandle();
	}

	@Override
	public FieldState nextUncoveredState() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextFlaggedState() {
		return new Uncovered(field);
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
