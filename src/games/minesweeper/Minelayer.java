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
		Random rand = new Random();
		double p = (double) nMines / (minefield.getNRows() * minefield.getNColumns() - 1);
		int layedMines = 0;
		while (true) {
			for (int i = 0; i < minefield.getNRows(); i++) {
				for (int j = 0; j < minefield.getNColumns(); j++) {
					if (!minefield.isMine(i, j) && !minefield.isUncovered(i, j) && rand.nextDouble() < p) {
						minefield.layMine(i, j);
						minefield.incrementAdjecent(i, j);
						layedMines++;
						if (layedMines >= nMines){
							return;
						}
					}
				}
			}
		}
	}
}
