package games.minesweeper.field.state;

public class Uncovered extends FieldState {
	public FieldState nextState1() {
		return new Uncovered();
	}

	public FieldState nextState2() {
		return new Uncovered();
	}
}
