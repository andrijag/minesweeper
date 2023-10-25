package main.java.games.minesweeper.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

import main.java.games.minesweeper.model.minefield.Field;
import main.java.games.minesweeper.model.util.Visitor;

class FieldView extends JButton implements Visitor {
	private static final long serialVersionUID = 1L;
	private int row;
	private int column;
	private FieldViewState state = new CoveredView();

	FieldView(int row, int column) {
		this.row = row;
		this.column = column;
		int width = 25;
		int height = 25;
		setPreferredSize(new Dimension(width, height));
	}

	int getRow() {
		return row;
	}

	int getColumn() {
		return column;
	}

	void update(Field field) {
		field.accept(this);
		repaint();
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		state.draw(graphics, 0, 0, getWidth(), getHeight());
	}

	@Override
	public void visitCoveredField() {
		state = new CoveredView();
		setEnabled(true);
	}

	@Override
	public void visitUncoveredFieldWithNumber(int number) {
		state = new UncoveredViewWithNumber(number);
		setEnabled(false);
	}

	@Override
	public void visitUncoveredFieldWithMine(boolean isDetonated) {
		state = new UncoveredViewWithMine(isDetonated);
		setEnabled(false);
	}

	@Override
	public void visitFlaggedField(boolean isFalselyFlagged) {
		state = new FlaggedView(isFalselyFlagged);
		setEnabled(!isFalselyFlagged);
	}

	@Override
	public void visitUnknownField() {
		state = new UnknownView();
		setEnabled(true);
	}
}
