package main.java.games.minesweeper.model.minefield;

import java.util.ArrayList;
import java.util.List;

import main.java.games.minesweeper.model.util.Visitable;
import main.java.games.minesweeper.model.util.Visitor;

public class Field implements Visitable {
	private FieldValue value = new Number();
	private FieldState state = new Covered();
	private List<Field> neighbours = new ArrayList<>();

	FieldValue getValue() {
		return value;
	}

	void changeState(FieldState state) {
		this.state = state;
	}

	List<Field> getNeighbours() {
		return neighbours;
	}

	void setNeighbours(List<Field> neighbours) {
		this.neighbours = neighbours;
	}

	void layMine() {
		value = new Mine();
		updateNeighbours();
	}

	private void updateNeighbours() {
		for (Field neighbour : neighbours)
			if (!neighbour.isMine())
				neighbour.updateNumber();
	}

	private void updateNumber() {
		setNumber(getNumberOfNeighbourMines());
	}

	private void setNumber(int number) {
		((Number) value).setValue(number);
	}

	private int getNumberOfNeighbourMines() {
		int numberOfMines = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isMine())
				numberOfMines++;
		return numberOfMines;
	}

	void uncover() {
		state = new Uncovered(value);
	}

	void detonate() {
		((Mine) value).detonate();
	}

	void mark() {
		state.mark(this);
	}

	void flag() {
		state = new Flagged();
	}

	int getNumber() {
		return ((Number) value).getValue();
	}

	int getNumberOfNeighbourFlags() {
		int numberOfFlags = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isFlagged())
				numberOfFlags++;
		return numberOfFlags;
	}

	boolean isDetonated() {
		return ((Mine) value).isDetonated();
	}

	void setFalselyFlagged() {
		((Flagged) state).setFalselyFlagged();
	}

	boolean isUncovered() {
		return state instanceof Uncovered;
	}

	boolean isMine() {
		return value instanceof Mine;
	}

	boolean isFlagged() {
		return state instanceof Flagged;
	}

	public void accept(Visitor visitor) {
		state.accept(visitor);
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
