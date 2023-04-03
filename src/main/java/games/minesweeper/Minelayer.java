package main.java.games.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.games.minesweeper.minefield.Field;
import main.java.games.minesweeper.minefield.Minefield;

public class Minelayer {
	private List<Field> fields;

	public Minelayer(Minefield minefield) {
		fields = new ArrayList<>();
		for (int i = 0; i < minefield.getNumberOfRows(); i++)
			for (int j = 0; j < minefield.getNumberOfColumns(); j++)
				fields.add(minefield.getField(i, j));
	}

	public void scatterMines(int numberOfMines) {
		Random rand = new Random();
		for (int i = 0; i < numberOfMines; i++) {
			Field field = fields.remove(rand.nextInt(fields.size()));
			layMine(field);
		}
	}

	public void layMine(Field field) {
		field.layMine();
	}

	public void remove(Field field) {
		fields.remove(field);
	}
}
