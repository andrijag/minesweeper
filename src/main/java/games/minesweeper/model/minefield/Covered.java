package main.java.games.minesweeper.model.minefield;

class Covered extends FieldState {
	@Override
	void mark(Field field) {
		field.flag();
	}

	@Override
	void accept(Visitor visitor) {
		visitor.visitCoveredField();
	}

	@Override
	public String toString() {
		return ".";
	}
}
