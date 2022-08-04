package games.minesweeper.field.value;

public class FieldNumber extends FieldValue {
	public FieldNumber(int number) {
		this.number = number;
	}

	public void increment() {
		number++;
	}

	public void reset() {
		number = 0;
	}

	@Override
	public String toString() {
		return number.toString();
	}
}
