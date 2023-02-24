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
	public void open() {
		detonate();
		field.getMinefield().detonate();
	}

	@Override
	public String toString() {
		if (isDetonated())
			return "x";
		else
			return "*";
	}
}
