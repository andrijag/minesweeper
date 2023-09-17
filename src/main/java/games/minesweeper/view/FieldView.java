package main.java.games.minesweeper.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

import main.java.games.minesweeper.model.minefield.Field;
import main.java.games.minesweeper.model.util.Visitor;

public class FieldView extends JButton implements Visitor {
	private static final long serialVersionUID = 1L;
	private FieldViewState state;

	public FieldView() {
		super();
		state = new CoveredView();
		setPreferredSize(new Dimension(25, 25));
	}
	
	void changeState(FieldViewState state) {
		this.state = state;
	}
	
	public void update(Field field) {
		field.accept(this);
		repaint();
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		state.draw(graphics);
	}
	
	@Override
	public void visitCoveredField() {
		changeState(new CoveredView());
		setEnabled(true);
	}

	@Override
	public void visitUncoveredFieldWithNumber(int number) {
		changeState(new UncoveredViewWithNumber(number));
		setEnabled(false);
	}

	@Override
	public void visitUncoveredFieldWithMine(boolean isDetonated) {
		changeState(new UncoveredViewWithMine(isDetonated));
		setEnabled(false);
	}

	@Override
	public void visitFlaggedField(boolean isFalselyFlagged) {
		changeState(new FlaggedView(isFalselyFlagged));
		setEnabled(true);
	}

	@Override
	public void visitUnknownField() {
		changeState(new UnknownView());
		setEnabled(true);
	}
}
