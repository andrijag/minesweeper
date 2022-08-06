package games.minesweeper.field.value;

public class FieldNumber extends FieldValue {
	private int number;

	public FieldNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
