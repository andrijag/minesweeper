package games.minesweeper.field.state;

public class Unknown implements FieldState {
	public FieldState nextState1() {
		return new Uncovered();
	}

	public FieldState nextState2() {
		return new Flagged();
	}

	public String toString() {
		return "?";
	}
}
