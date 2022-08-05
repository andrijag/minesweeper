package games.minesweeper.field.state;

public abstract class FieldState {
	public abstract FieldState nextState1();

	public abstract FieldState nextState2();
}
