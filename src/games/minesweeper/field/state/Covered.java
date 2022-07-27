package games.minesweeper.field.state;

public class Covered implements FieldState {
	public FieldState nextPrimaryState() {
		return new Uncovered();
	}
	
	public FieldState nextSecondaryState() {
		return new Flagged();
	}
	
	public String toString() {
		return "_";
	}
}
