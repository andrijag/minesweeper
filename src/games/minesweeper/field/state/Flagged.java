package games.minesweeper.field.state;

public class Flagged implements FieldState {
	public FieldState nextState1() {
		return new Flagged();
	}

	public FieldState nextState2() {
		return new Unknown();
	}

	public String toString() {
		return ">";
	}
}
