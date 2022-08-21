package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Covered extends FieldState {
	public Covered(Field field) {
		super(field);
	}

	@Override
	public void sweepHandle() {
		field.sweepHandle();
	}

	@Override
	public void chordHandle() {
	}

	@Override
	public FieldState nextUncoveredState() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextFlaggedState() {
		return new Flagged(field);
	}

	@Override
	public String toString() {
		return ".";
	}
}
