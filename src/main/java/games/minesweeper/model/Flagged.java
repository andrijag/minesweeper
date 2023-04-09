package main.java.games.minesweeper.model;

class Flagged extends FieldState {
	Flagged(Field field) {
		super(field);
	}

	@Override
	void mark() {
		field.changeState(new Unknown(field));
	}

	@Override
	public String toString() {
		return ">";
	}
}
