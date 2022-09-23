package games.minesweeper.field.value;

import games.minesweeper.field.Field;

public class FieldNumber extends FieldValue {
	private int number;

	public FieldNumber(Field field) {
		super(field);
		this.number = 0;
	}

	public int getNumber() {
		return number;
	}

	public void increment() {
		number++;
	}

	@Override
	public void sweep() {
		field.decrementToUncover();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
