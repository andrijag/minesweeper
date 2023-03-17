package main.java.games.minesweeper.minefield;

class Unknown extends FieldState {
	Unknown(Field field) {
		super(field);
	}

	@Override
	void mark() {
		field.changeState(new Covered(field));
	}

	@Override
	public String toString() {
		return "?";
	}
}
