package main.java.games.minesweeper.view;

import java.awt.Graphics;

public class UnknownView extends FieldViewState {
	@Override
	public void draw(Graphics graphics) {
		graphics.drawString("?", 10, 17);
	}
}
