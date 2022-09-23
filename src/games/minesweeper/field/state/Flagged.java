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
		field.markHandle();
		field.decrementFlagCounter();
	}

	@Override
	public void chord() {
	}

	@Override
	public FieldState nextMarkedState() {
		return new Unknown(field);
	}

	@Override
	public String toString() {
		return ">";
	}
}
