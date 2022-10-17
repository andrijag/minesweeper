package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.games.minesweeper.field.Field;

public class Minelayer {
	private int numberOfMines;
	private List<Field> fields;

	public Minelayer(Minefield minefield, int nMines) {
		this.numberOfMines = nMines;
		fields = new ArrayList<Field>();
		for (int i = 0; i < minefield.getNumberOfRows(); i++)
			for (int j = 0; j < minefield.getNumberOfColumns(); j++)
				fields.add(minefield.get(i, j));
	}

	public void layMines() {
		Random rand = new Random();
		for (int i = 0; i < numberOfMines; i++) {
			int randI = rand.nextInt(fields.size());
			Field field = fields.remove(randI);
			field.layMine();
			field.incrementNeighbours();
		}
	}

	public void remove(Field field) {
		fields.remove(field);
	}
}
