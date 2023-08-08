package main.java.games.minesweeper.model.minefield;

enum Vector {
	N(-1, 0), NE(-1, 1), E(0, 1), SE(1, 1), S(1, 0), SW(1, -1), W(0, -1), NW(-1, -1);

	private int i;
	private int j;

	Vector(int i, int j) {
		this.i = i;
		this.j = j;
	}

	int getI() {
		return i;
	}

	int getJ() {
		return j;
	}
}
