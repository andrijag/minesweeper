package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class UncoveredViewWithNumber extends FieldViewState {
	private int number;

	public UncoveredViewWithNumber(int number) {
		this.number = number;
	}

	@Override
	public void draw(Graphics graphics, int x0, int y0, int width, int height) {
		if (number == 0)
			return;
		graphics.setColor(getNumberColor(number));
		String text = Integer.toString(number);
		addText(graphics, text, x0, y0, width, height);
	}

	private Color getNumberColor(int number) {
		switch (number) {
		case 1:
			return Color.BLUE;
		case 2:
			return Color.GREEN.darker();
		case 3:
			return Color.RED;
		case 4:
			return Color.BLUE.darker();
		case 5:
			return Color.RED.darker();
		case 6:
			return Color.CYAN.darker();
		case 7:
			return Color.BLACK;
		case 8:
			return Color.GRAY;
		default:
			return null;
		}
	}
}
