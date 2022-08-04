package games.minesweeper.field.value;

public abstract class FieldValue {
	protected Integer value;

	public abstract Integer getValue();

	public abstract void increment();
	
	public abstract void reset();
}
