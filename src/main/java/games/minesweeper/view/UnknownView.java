package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

class UnknownView extends FieldViewState {
	@Override
	void draw(Graphics graphics, int x, int y, int width, int height) {
		graphics.setColor(Color.BLACK);
		String text = "?";
		Paint.writeText(graphics, text, x, y, width, height);
	}
}
