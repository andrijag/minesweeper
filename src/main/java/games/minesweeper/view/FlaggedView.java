package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class FlaggedView extends FieldViewState {
	private boolean isFalselyFlagged;

	public FlaggedView(boolean isFalselyFlagged) {
		this.isFalselyFlagged = isFalselyFlagged;
	}

	@Override
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		if (isFalselyFlagged) {
			drawMine(graphics, x, y, width, height);
			graphics.setColor(Color.RED);
			graphics.drawLine(x, y, width, height);
			graphics.drawLine(width, y, x, height);
		} else {
			graphics.setColor(Color.RED);
			writeText(graphics, "<", x, y, width, height);
		}
	}
}
