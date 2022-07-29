package games.minesweeper;

import java.util.Random;

public class Minelayer {
	private Minefield minefield;
	private int nMines;

	public Minelayer(Minefield minefield, int nMines) {
		this.minefield = minefield;
		this.nMines = nMines;
	}

	public void layMines() {
		int layedMines = 0;
		for (int i = 0; i < minefield.getNRows(); i++) {
			for (int j = 0; j < minefield.getNColumns(); j++) {
				if (layedMines >= nMines) {
					return;
				}
				if (!minefield.isUncovered(i, j)) {
					minefield.layMine(i, j);
					layedMines++;
				}
			}
		}
	}
	
	public void scatterMines() {
		Random rand = new Random();
		int scatteredMines = 0;
		for (int i = 0; i < minefield.getNRows(); i++) {
			for (int j = 0; j < minefield.getNColumns(); j++) {
				if (scatteredMines >= nMines) {
					return;
				}
				int k = rand.nextInt(minefield.getNRows());
				int l = rand.nextInt(minefield.getNColumns());
				if (minefield.isMine(i, j) && !minefield.isUncovered(k, l)) {
					minefield.switchFields(i, j, k, l);
					scatteredMines++;
				}
			}
		}
	}
}
