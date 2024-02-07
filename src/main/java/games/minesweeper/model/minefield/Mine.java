package main.java.games.minesweeper.model.minefield;

class Mine extends FieldValue {
	private boolean isDetonated = false;

	void detonate() {
		isDetonated = true;
	}

	boolean isDetonated() {
		return isDetonated;
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visitUncoveredFieldWithMine(isDetonated);
	}

	@Override
	public String toString() {
		return "*";
	}
}
