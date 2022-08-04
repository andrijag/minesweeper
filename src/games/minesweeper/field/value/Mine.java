package games.minesweeper.field.value;

public class Mine extends FieldValue {
	public Mine() {
		number = null;
	}

	public void increment() {
	}

	public void reset() {
	}

	@Override
	public String toString() {
		return "*";
	}
}
