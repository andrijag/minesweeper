package games.minesweeper.field.value;

public class Mine extends FieldValue {
	public Mine() {
		number = null;
	}
	
	public boolean equals(int number) {
		return false;
	}

	public void increment() {
	}

	public void reset() {
	}

	@Override
	public String toString() {
		return "*";
	}
}
