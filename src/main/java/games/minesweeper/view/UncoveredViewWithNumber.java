package main.java.games.minesweeper.view;

import java.awt.Graphics;

class UncoveredViewWithNumber extends FieldViewState {
	private int number;

	UncoveredViewWithNumber(int number) {
		this.number = number;
	}

	@Override
	void draw(Graphics graphics, int x, int y, int width, int height) {
		if (number == 0)
			return;
		graphics.setColor(Paint.getNumberColor(number));
		String text = Integer.toString(number);
		Paint.writeText(graphics, text, x, y, width, height);
	}
}
