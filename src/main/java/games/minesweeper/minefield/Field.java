package main.java.games.minesweeper.minefield;

import java.util.ArrayList;
import java.util.List;

public class Field {
	private FieldValue value;
	private FieldState state;
	private List<Field> neighbours;

	Field() {
		value = new Number();
		state = new Covered(this);
		neighbours = new ArrayList<>();
	}

	FieldValue getValue() {
		return value;
	}

	void changeState(FieldState state) {
		this.state = state;
	}

	public List<Field> getNeighbours() {
		return neighbours;
	}

	void setNeighbours(List<Field> neighbours) {
		this.neighbours = neighbours;
	}

	void layMine() {
		value = new Mine();
		for (Field neighbour : neighbours)
			if (!neighbour.isMine())
				neighbour.setNumber(neighbour.getNumberOfNeighbourMines());
	}

	private void setNumber(int number) {
		((Number) value).setNumber(number);
	}

	void uncover() {
		state = new Uncovered(this);
	}

	void detonate() {
		((Mine) value).detonate();
	}

	void mark() {
		state.mark();
	}

	void flag() {
		state = new Flagged(this);
	}

	public boolean isDetonated() {
		return ((Mine) value).isDetonated();
	}

	public int getNumber() {
		return ((Number) value).getNumber();
	}

	public int getNumberOfNeighbourFlags() {
		int numberOfFlags = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isFlagged())
				numberOfFlags++;
		return numberOfFlags;
	}

	public int getNumberOfNeighbourMines() {
		int numberOfMines = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isMine())
				numberOfMines++;
		return numberOfMines;
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public boolean isFlagged() {
		return state instanceof Flagged;
	}

	public boolean isUncovered() {
		return state instanceof Uncovered;
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
