package games.minesweeper.field.value;

public class FieldNumber extends FieldValue {
	public FieldNumber() {
		this.value = 0;
	}

	public Integer getValue() {
		return value;
	}

	public void increment() {
		value++;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
