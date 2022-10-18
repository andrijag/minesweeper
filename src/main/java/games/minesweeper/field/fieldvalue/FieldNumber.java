package main.java.games.minesweeper.field.fieldvalue;

import main.java.games.minesweeper.field.Field;

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
	public void uncover() {
		field.decrementToUncover();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
