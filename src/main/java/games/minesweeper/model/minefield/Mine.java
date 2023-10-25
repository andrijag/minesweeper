package main.java.games.minesweeper.model.minefield;

import main.java.games.minesweeper.model.util.Visitor;

class Mine extends FieldValue {
	private boolean isDetonated;

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
