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
		int nFlags = minefield.adjecentFlags(i, j);
		if (minefield.get(i, j).equals(nFlags)) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				minefield.uncover(i + di, j + dj);
			}
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (minefield.isMine(i + di, j + dj)) {
					return;
				}
			}
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				sweep(i + di, j + dj);
			}
		}
	}
}
