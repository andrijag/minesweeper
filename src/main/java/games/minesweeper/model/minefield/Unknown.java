package main.java.games.minesweeper.model.minefield;

class Unknown extends FieldState {
	@Override
	void mark(Field field) {
		field.changeState(new Covered());
	}
	
	@Override
	void accept(Visitor visitor) {
		visitor.visitUnknownField();
	}

	@Override
	public String toString() {
		return "?";
	}
}
