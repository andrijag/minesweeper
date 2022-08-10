package games.minesweeper.field.state;

public class Unknown extends FieldState {
	@Override
	public FieldState nextState1() {
		return new Uncovered();
	}

	@Override
	public FieldState nextState2() {
		return new Flagged();
	}

	@Override
	public String toString() {
		return "?";
	}
}
