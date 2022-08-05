package games.minesweeper;

public class Minesweeper {
	private Minefield minefield;

	public Minesweeper(Minefield minefield) {
		this.minefield = minefield;
	}

	public void sweep(int i, int j) {
		minefield.uncover(i, j);
		if (minefield.get(i, j).equals(0)) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (minefield.contains(i + di, j + dj) && !minefield.isUncovered(i + di, j + dj)) {
					sweep(i + di, j + dj);
				}
			}
		}
	}

	public void flag(int i, int j) {
		minefield.flag(i, j);
	}

	public void expand(int i, int j) {
	}
}
