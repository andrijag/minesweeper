package games.minesweeper.field.state;

public class Flagged extends FieldState {
	@Override
	public FieldState nextState1() {
		return new Flagged();
	}

	@Override
	public FieldState nextState2() {
		return new Unknown();
	}

	@Override
	public String toString() {
		return ">";
	}
}
