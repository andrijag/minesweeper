package games.minesweeper.field.value;

public class FieldNumber extends FieldValue {
	public FieldNumber() {
		value = 0;
	}

	public Integer getValue() {
		return value;
	}

	public void increment() {
		value++;
	}
	
	public void reset() {
		value = 0;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
