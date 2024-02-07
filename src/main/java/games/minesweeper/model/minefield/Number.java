package main.java.games.minesweeper.model.minefield;

class Number extends FieldValue {
	private int value = 0;

	int getValue() {
		return value;
	}

	void setValue(int value) {
		this.value = value;
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visitUncoveredFieldWithNumber(value);
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
