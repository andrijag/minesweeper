package main.java.games.minesweeper.model;

class Number extends FieldValue {
	private int value;

	Number() {
		value = 0;
	}

	int getValue() {
		return value;
	}

	void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
