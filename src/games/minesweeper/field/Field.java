package games.minesweeper.field;

import games.minesweeper.Minefield;
import games.minesweeper.Vector;
import games.minesweeper.field.state.Covered;
import games.minesweeper.field.state.FieldState;
import games.minesweeper.field.state.Flagged;
import games.minesweeper.field.value.FieldNumber;
import games.minesweeper.field.value.FieldValue;
import games.minesweeper.field.value.Mine;

public class Field {
	private Minefield minefield;
	private int i;
	private int j;
	private FieldValue value;
	private FieldState state;

	public Field(Minefield minefield, int i, int j) {
		this.minefield = minefield;
		this.i = i;
		this.j = j;
		value = new FieldNumber(0);
		state = new Covered(this);
	}

	public FieldValue getValue() {
		return value;
	}

	private void setValue(FieldValue value) {
		this.value = value;
	}

	private void setState(FieldState state) {
		this.state = state;
	}

	public void sweep() {
		state.sweepHandle();
	}

	public void flag() {
		setState(state.nextFlaggedState());
	}

	public void chord() {
		state.chordHandle();
	}

	public void layMine() {
		setValue(new Mine());
	}

	private void uncover() {
		setState(state.nextUncoveredState());
	}

	public boolean isMine() {
		return value instanceof Mine;
	}

	public int getNumber() {
		return ((FieldNumber) value).getNumber();
	}

	public void increment() {
		((FieldNumber) value).increment();
	}

	public boolean isFlagged() {
		return state instanceof Flagged;
	}

	public void sweepHandle() {
		uncover();
		if (!isMine() && getNumber() == 0) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (minefield.contains(i + di, j + dj)) {
					minefield.sweep(i + di, j + dj);
				}
			}
		}
	}

	public void chordHandle() {
		if (getNumber() == neighbourFlags()) {
			for (Vector vector : Vector.values()) {
				int di = vector.getI();
				int dj = vector.getJ();
				if (minefield.contains(i + di, j + dj)) {
					minefield.sweep(i + di, j + dj);
				}
			}
		}
	}

	public int neighbourFlags() {
		int nFlags = 0;
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (minefield.contains(i + di, j + dj) && minefield.isFlagged(i + di, j + dj)) {
				nFlags++;
			}
		}
		return nFlags;
	}

	public void incrementNeighbours() {
		for (Vector vector : Vector.values()) {
			int di = vector.getI();
			int dj = vector.getJ();
			if (minefield.contains(i + di, j + dj) && !minefield.isMine(i + di, j + dj)) {
				minefield.increment(i + di, j + dj);
			}
		}
	}

	@Override
	public String toString() {
		return state.toString();
	}
}
