package main.java.games.minesweeper.minefield;

class Covered extends FieldState {
	Covered(Field field) {
		super(field);
	}

	@Override
	void mark() {
		field.flag();
	}

	@Override
	public String toString() {
		return ".";
	}
}