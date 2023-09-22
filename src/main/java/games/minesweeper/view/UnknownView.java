package main.java.games.minesweeper.view;

import java.awt.Graphics;

public class UnknownView extends FieldViewState {
	@Override
	public void draw(Graphics graphics, int x0, int y0, int width, int height) {
		String text = "?";
		addText(graphics, text, x0, y0, width, height);
	}
}
