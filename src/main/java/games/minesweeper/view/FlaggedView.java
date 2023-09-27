package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

class FlaggedView extends FieldViewState {
	private boolean isFalselyFlagged;

	FlaggedView(boolean isFalselyFlagged) {
		this.isFalselyFlagged = isFalselyFlagged;
	}

	@Override
	void draw(Graphics graphics, int x, int y, int width, int height) {
		if (isFalselyFlagged) {
			Paint.drawMine(graphics, x, y, width, height);
			graphics.setColor(Color.RED);
			graphics.drawLine(x, y, width, height);
			graphics.drawLine(width, y, x, height);
		} else {
			Paint.drawFlag(graphics, x, y, width, height);
		}
	}
}
