package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class UncoveredViewWithMine extends FieldViewState {
	private boolean isDetonated;

	public UncoveredViewWithMine(boolean isDetonated) {
		this.isDetonated = isDetonated;
	}

	@Override
	public void draw(Graphics graphics, int x0, int y0, int width, int height) {
		if (isDetonated) {
			graphics.setColor(Color.RED);
			graphics.fillRect(x0, y0, width, height);
		}
		graphics.setColor(Color.BLACK);
		addText(graphics, "*", x0, y0, width, height);
	}
}
