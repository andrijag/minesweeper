package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

class UncoveredViewWithMine extends FieldViewState {
	private boolean isDetonated;

	UncoveredViewWithMine(boolean isDetonated) {
		this.isDetonated = isDetonated;
	}

	@Override
	void draw(Graphics graphics, int x, int y, int width, int height) {
		if (isDetonated) {
			graphics.setColor(Color.RED);
			graphics.fillRect(x, y, width, height);
		}
		Paint.drawMine(graphics, x, y, width, height);
	}
}
