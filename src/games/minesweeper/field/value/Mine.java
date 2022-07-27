package games.minesweeper.field.value;

public class Mine implements FieldValue {
	public void increment() {
	}

	@Override
	public String toString() {
		return "*";
	}
}
