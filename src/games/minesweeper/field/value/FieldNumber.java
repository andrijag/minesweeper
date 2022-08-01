package games.minesweeper.field.value;

public class FieldNumber implements FieldValue {
	private int number;

	public FieldNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

	public void increment() {
		number++;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
