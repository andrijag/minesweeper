package main.java.games.minesweeper.view;

import java.awt.Graphics;

public class UnknownView extends FieldViewState {
	@Override
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		String text = "?";
		writeText(graphics, text, x, y, width, height);
	}
}
