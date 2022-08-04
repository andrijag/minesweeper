package games.minesweeper.field.value;

public abstract class FieldValue {
	protected Integer number;

	public Integer getNumber() {
		return number;
	}

	public abstract void increment();

	public abstract void reset();
}
