package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
		super(field);
	}

	@Override
	public void sweep() {
		field.sweepHandle();
	}

	@Override
	public void flag() {
		field.flagHandle();
	}

	@Override
	public void chord() {
	}

	@Override
	public FieldState nextUncoveredState() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextFlaggedState() {
		return new Covered(field);
	}

	@Override
	public String toString() {
		return "?";
	}
}
