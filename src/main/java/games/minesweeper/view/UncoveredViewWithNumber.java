package main.java.games.minesweeper.view;

import java.awt.Graphics;

public class UncoveredViewWithNumber extends FieldViewState {
	private int number;

	public UncoveredViewWithNumber(int number) {
		this.number = number;
	}

	@Override
	public void draw(Graphics graphics, int x, int y, int width, int height) {
		if (number == 0)
			return;
		graphics.setColor(getNumberColor(number));
		String text = Integer.toString(number);
		writeText(graphics, text, x, y, width, height);
	}
}
