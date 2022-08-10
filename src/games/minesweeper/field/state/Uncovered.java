package games.minesweeper.field.state;

public class Uncovered extends FieldState {
	@Override
	public FieldState nextState1() {
		return new Uncovered();
	}

	@Override
	public FieldState nextState2() {
		return new Uncovered();
	}
}
