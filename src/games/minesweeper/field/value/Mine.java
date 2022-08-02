package games.minesweeper.field.value;

public class Mine implements FieldValue {
	public void increment() {
	}

	public void reset() {
	}

	@Override
	public String toString() {
		return "*";
	}
}
