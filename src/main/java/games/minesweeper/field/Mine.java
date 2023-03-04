package main.java.games.minesweeper.field;

import main.java.games.minesweeper.utils.ExplosiveState;

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
