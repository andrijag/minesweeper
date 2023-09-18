package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class FlaggedView extends FieldViewState {
	private boolean isFalselyFlagged;

	public FlaggedView(boolean isFalselyFlagged) {
		super();
		this.isFalselyFlagged = isFalselyFlagged;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawLine(5, 20, 20, 20);
		graphics.drawLine(25 / 2, 5, 25 / 2, 20);
		graphics.setColor(Color.RED);
		int[] xPoints = { 25 / 2, 25 / 2, 5 };
		int[] yPoints = { 5, 15, 10 };
		graphics.fillPolygon(xPoints, yPoints, 3);
	}
}
