package main.java.games.minesweeper.model.minefield;

public interface Visitor {
	public void visitCoveredField();

	public void visitUncoveredFieldWithNumber(int number);

	public void visitUncoveredFieldWithMine(boolean isDetonated);

	public void visitFlaggedField(boolean isFalselyFlagged);

	public void visitUnknownField();
}
