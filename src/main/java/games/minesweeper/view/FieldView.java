package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

import main.java.games.minesweeper.model.minefield.Field;
import main.java.games.minesweeper.model.util.Visitor;

public class FieldView extends JButton implements Visitor {
	private static final long serialVersionUID = 1L;
	private Field model;
	private Color color;

	public FieldView() {
		super();
		setPreferredSize(new Dimension(25, 25));
	}

	public void setModel(Field model) {
		this.model = model;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		model.accept(this);
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawString(model.toString(), 10, 15);
	}
	
	@Override
	public void visitCoveredField() {
		color = Color.GRAY;
		setEnabled(true);
	}

	@Override
	public void visitUncoveredFieldWithNumber(int number) {
		color = Color.WHITE;
		setEnabled(false);
	}

	@Override
	public void visitUncoveredFieldWithMine(boolean isDetonated) {
		color = Color.BLACK;
		setEnabled(false);
	}

	@Override
	public void visitFlaggedField(boolean isFalselyFlagged) {
		color = Color.RED;
		setEnabled(true);
	}

	@Override
	public void visitUnknownField() {
		color = Color.BLUE;
		setEnabled(true);
	}
}
