package games.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import games.minesweeper.field.Field;

public class Minelayer {
	private int nMines;
	private List<Field> fields;

	public Minelayer(Minefield minefield, int nMines) {
		this.nMines = nMines;
		fields = new ArrayList<Field>();
		for (int i = 0; i < minefield.getNRows(); i++) {
			for (int j = 0; j < minefield.getNColumns(); j++) {
				fields.add(minefield.get(i, j));
			}
		}
	}

	public void remove(Field field) {
		fields.remove(field);
	}

	public void layMines() {
		Random rand = new Random();
		for (int i = 0; i < nMines; i++) {
			int randI = rand.nextInt(fields.size());
			Field field = fields.remove(randI);
			field.layMine();
		}
	}
}
