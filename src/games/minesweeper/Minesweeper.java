package games.minesweeper;

import games.minesweeper.field.Field;

public class Minesweeper {
	private Minefield minefield;

	public Minesweeper(Minefield minefield) {
		this.minefield = minefield;
	}

	public void sweep(int i, int j) {
		if (minefield.isUncovered(i, j)) {
			expand(i, j);
		} else {
			uncover(i, j);
		}
	}

	private void expand(int i, int j) {
		Field field = minefield.get(i, j);
		if (field.getNumber() == field.neighbourFlags()) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				uncover(i + di, j + dj);
			}
		}
	}

	private void uncover(int i, int j) {
		Field field = minefield.get(i, j);
		field.uncover();
		if (!field.isMine() && field.getNumber() == 0 && !field.isFlagged()) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (minefield.contains(i + di, j + dj) && !minefield.isUncovered(i + di, j + dj)) {
					uncover(i + di, j + dj);
				}
			}
		}
	}

	public void flag(int i, int j) {
		minefield.flag(i, j);
	}
}
