package main.java.games.minesweeper.field.fieldvalue;

import main.java.games.minesweeper.field.Field;

public class Mine extends FieldValue {
	public Mine(Field field) {
		super(field);
	}

	@Override
	public void expose() {
		field.detonate();
	}

	@Override
	public String toString() {
		return "*";
	}
}
