package games.minesweeper.field.value;

public class Mine extends FieldValue {
	public Mine() {
		value = null;
	}

	public Integer getValue() {
		return value;
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
