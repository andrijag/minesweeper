package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class UnknownView extends FieldViewState {
	@Override
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		graphics.setColor(Color.BLACK);
		String text = "?";
		writeText(graphics, text, x, y, width, height);
	}
}
