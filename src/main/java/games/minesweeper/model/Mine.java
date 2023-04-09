package main.java.games.minesweeper.model;

class Mine extends FieldValue {
	private boolean isDetonated;

	Mine() {
		isDetonated = false;
	}

	void detonate() {
		isDetonated = true;
	}

	boolean isDetonated() {
		return isDetonated;
	}

	@Override
	public String toString() {
		return "*";
	}
}
