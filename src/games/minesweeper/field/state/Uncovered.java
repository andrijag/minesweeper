package games.minesweeper.field.state;

public class Uncovered implements FieldState {
	public FieldState nextPrimaryState() {
		return new Uncovered();
	}

	public FieldState nextSecondaryState() {
		return new Uncovered();
	}
}
