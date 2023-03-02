package main.java.games.minesweeper.field;

class Mine extends FieldValue {
	private ExplosiveState state;

	Mine() {
		state = ExplosiveState.LIVE;
	}

	void detonate() {
		state = ExplosiveState.DETONATED;
	}

	boolean isDetonated() {
		return state == ExplosiveState.DETONATED;
	}

	@Override
	public String toString() {
		return "*";
	}
}
