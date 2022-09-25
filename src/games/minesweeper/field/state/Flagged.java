package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Flagged extends FieldState {
	public Flagged(Field field) {
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
		field.setState(new Unknown(field));
		field.decrementFlagCounter();
	}

	@Override
	public void chord() {
	}

	@Override
	public String toString() {
		return ">";
	}
}
