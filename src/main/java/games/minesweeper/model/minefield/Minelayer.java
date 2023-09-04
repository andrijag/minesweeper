package main.java.games.minesweeper.model.minefield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minelayer {
	private List<Field> fields;

	public Minelayer(Minefield minefield) {
		fields = new ArrayList<>();
		for (int row = 0; row < minefield.getNumberOfRows(); row++)
			for (int column = 0; column < minefield.getNumberOfColumns(); column++)
				fields.add(minefield.getField(row, column));
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
