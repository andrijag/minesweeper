package main.java.games.minesweeper.view;

import java.awt.FontMetrics;
import java.awt.Graphics;

public abstract class FieldViewState {
	public abstract void draw(Graphics graphics, int x0, int y0, int width, int height);

	protected void addText(Graphics graphics, String text, int x0, int y0, int width, int height) {
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int textWidth = fontMetrics.stringWidth(text);
		int textHeight = fontMetrics.getAscent();
		graphics.drawString(text, x0 + (width - textWidth) / 2, y0 + (height + textHeight) / 2);
	}
}
