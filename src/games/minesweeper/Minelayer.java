package games.minesweeper;

import java.util.Random;

public class Minelayer {
	Minefield minefield;
	int nMines;

	public Minelayer(Minefield minefield, int nMines) {
		this.minefield = minefield;
		this.nMines = nMines;
	}

	public void layMines() {
		int layedMines = 0;
		Random rand = new Random();
		while (layedMines < nMines) {
			int i = rand.nextInt(minefield.getNRows());
			int j = rand.nextInt(minefield.getNColumns());
			if (!minefield.isMine(i, j) && !minefield.isUncovered(i, j)) {
				minefield.layMine(i, j);
				minefield.incrementAdjecent(i, j);
				layedMines++;
			}
		}
	}
}
