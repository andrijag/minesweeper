package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
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
		field.setState(new Covered(field));
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return "?";
	}
}
