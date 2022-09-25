package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Unknown extends FieldState {
	public Unknown(Field field) {
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
