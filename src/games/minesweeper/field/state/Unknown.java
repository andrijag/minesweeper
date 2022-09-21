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
	public void mark() {
		field.markHandle();
	}

	@Override
	public void chord() {
	}

	@Override
	public FieldState nextMarkedState() {
		return new Covered(field);
	}

	@Override
	public String toString() {
		return "?";
	}
}
