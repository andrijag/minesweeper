package games.minesweeper.field.state;

public class Flagged implements FieldState {
	public FieldState nextPrimaryState() {
		return new Flagged();
	}

	public FieldState nextSecondaryState() {
		return new Unknown();
	}

	public String toString() {
		return ">";
	}
}
