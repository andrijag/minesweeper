package games.minesweeper.field;

import java.util.List;

import games.minesweeper.Minefield;
import games.minesweeper.field.fieldstate.Covered;
import games.minesweeper.field.fieldstate.FieldState;
import games.minesweeper.field.fieldstate.Flagged;
import games.minesweeper.field.fieldstate.Uncovered;
import games.minesweeper.field.fieldvalue.FieldNumber;
import games.minesweeper.field.fieldvalue.FieldValue;
import games.minesweeper.field.fieldvalue.Mine;

public class Field {
	private Minefield minefield;
	private FieldValue value;
	private FieldState state;
	private List<Field> neighbours;

	public Field(Minefield minefield) {
		this.minefield = minefield;
		value = new FieldNumber(this);
		state = new Covered(this);
	}

	public FieldValue getValue() {
		return value;
	}

	public void setState(FieldState state) {
		this.state = state;
	}

	public void setNeighbours(List<Field> neighbours) {
		this.neighbours = neighbours;
	}

	public void sweep() {
		state.sweep();
	}

	public void mark() {
		state.mark();
	}

	public void chord() {
		state.chord();
	}

	public void layMine() {
		value = new Mine(this);
	}

	public void uncover() {
		state = new Uncovered(this);
	}

	public void flag() {
		state = new Flagged(this);
	}

	public int getNumber() {
		return ((FieldNumber) value).getNumber();
	}

	public void increment() {
		((FieldNumber) value).increment();
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public boolean isFlagged() {
		return state instanceof Flagged;
	}

	public void sweepHandle() {
		uncover();
		if (!isMine() && getNumber() == 0)
			for (Field neighbour : neighbours)
				neighbour.sweep();
	}

	public void chordHandle() {
		if (getNumber() == neighbourFlags())
			for (Field neighbour : neighbours)
				neighbour.sweep();
	}

	public int neighbourFlags() {
		int nFlags = 0;
		for (Field neighbour : neighbours)
			if (neighbour.isFlagged())
				nFlags++;
		return nFlags;
	}

	public void incrementNeighbours() {
		for (Field neighbour : neighbours)
			if (!neighbour.isMine())
				neighbour.increment();
	}

	public void incrementNFlags() {
		minefield.incrementNFlags();
	}

	public void decrementNFlags() {
		minefield.decrementNFlags();
	}

	public void detonate() {
		minefield.detonate();
	}

	public void decrementToUncover() {
		minefield.decrementToUncover();
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
