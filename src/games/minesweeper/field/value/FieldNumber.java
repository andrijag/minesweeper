package games.minesweeper.field.value;

public class FieldNumber implements FieldValue {
	int number;

	public FieldNumber(int number) {
		this.number = number;
	}

	public void increment() {
		number++;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
