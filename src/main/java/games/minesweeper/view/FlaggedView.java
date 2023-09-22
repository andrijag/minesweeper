package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class FlaggedView extends FieldViewState {
	private boolean isFalselyFlagged;

	public FlaggedView(boolean isFalselyFlagged) {
		this.isFalselyFlagged = isFalselyFlagged;
	}

	@Override
	public void draw(Graphics graphics, int x0, int y0, int width, int height) {
		if (isFalselyFlagged) {
			addText(graphics, "*", x0, y0, width, height);
			graphics.setColor(Color.RED);
			graphics.drawLine(x0, y0, width, height);
			graphics.drawLine(width, y0, x0, height);
		} else {
			graphics.setColor(Color.RED);
			addText(graphics, "<", x0, y0, width, height);
		}
	}
}
