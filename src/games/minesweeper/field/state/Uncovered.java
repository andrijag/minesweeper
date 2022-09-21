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
	public void flag() {
	}

	@Override
	public void chord() {
		field.chordHandle();
	}

	@Override
	public FieldState nextFlaggedState() {
		return null;
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
