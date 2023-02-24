package main.java.games.minesweeper.field.fieldvalue;

import main.java.games.minesweeper.field.Field;

public class Mine extends FieldValue {
	private ExplosiveState state;
	
	public Mine(Field field) {
		super(field);
		state = ExplosiveState.LIVE;
	}
	
	public void detonate() {
		state = ExplosiveState.DETONATED;
	}
	
	public boolean isDetonated() {
		return state == ExplosiveState.DETONATED;
	}

	@Override
	public void uncover() {
		detonate();
	}

	@Override
	public String toString() {
		return "*";
	}
}
