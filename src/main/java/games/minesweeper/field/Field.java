package main.java.games.minesweeper.field;

import java.util.List;

import main.java.games.minesweeper.Minefield;

public class Field {
	private FieldValue value;
	private FieldState state;
	private List<Field> neighbours;

	public Field(Minefield minefield) {
		value = new Number();
		state = new Covered(this);
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

	public void setNeighbours(List<Field> neighbours) {
		this.neighbours = neighbours;
	}

	public void layMine() {
		value = new Mine();
		incrementNeighbours();
	}

	private void incrementNeighbours() {
		for (Field neighbour : neighbours)
			if (!neighbour.isMine())
				neighbour.increment();
	}

	private void increment() {
		((Number) value).increment();
	}

	public void uncover() {
		state = new Uncovered(this);
	}

	public void mark() {
		state.mark();
	}

	public void flag() {
		state = new Flagged(this);
	}

	public void detonate() {
		((Mine) value).detonate();
	}

	public boolean isDetonated() {
		return ((Mine) value).isDetonated();
	}

	public int getNumber() {
		return ((Number) value).getNumber();
	}

	public int getNumberOfNeighbourFlags() {
		int neighbourFlags = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isFlagged())
				neighbourFlags++;
		return neighbourFlags;
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
