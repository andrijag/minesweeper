package main.java.games.minesweeper.field;

class Number extends FieldValue {
	private int number;

	Number() {
		this.number = 0;
	}

	int getNumber() {
		return number;
	}

	void increment() {
		number++;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
