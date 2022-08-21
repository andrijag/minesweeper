package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
		super(field);
	}

	@Override
	public void sweepHandle() {
	}

	@Override
	public void chordHandle() {
	}

	@Override
	public FieldState nextUncoveredState() {
		return new Flagged(field);
	}

	@Override
	public FieldState nextFlaggedState() {
		return new Unknown(field);
	}

	@Override
	public String toString() {
		return ">";
	}
}
