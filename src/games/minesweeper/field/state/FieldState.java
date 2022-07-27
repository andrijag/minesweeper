package games.minesweeper.field.state;

public interface FieldState {
	public FieldState nextPrimaryState();

	public FieldState nextSecondaryState();
}
