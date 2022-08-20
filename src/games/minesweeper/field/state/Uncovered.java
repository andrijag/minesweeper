package games.minesweeper.field.state;

import games.minesweeper.field.Field;

public class Uncovered extends FieldState {
	public Uncovered(Field field) {
		super(field);
	}
	
	@Override
	public void action() {
	}

	@Override
	public FieldState nextState1() {
		return new Uncovered(field);
	}

	@Override
	public FieldState nextState2() {
		return new Uncovered(field);
	}

	@Override
	public String toString() {
		return field.getValue().toString();
	}
}
