package main.java.games.minesweeper.minefield;

class Number extends FieldValue {
	private int number;

	Number() {
		number = 0;
	}

	int getNumber() {
		return number;
	}

	void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
