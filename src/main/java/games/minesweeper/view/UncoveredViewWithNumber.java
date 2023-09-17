package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class UncoveredViewWithNumber extends FieldViewState {
	private int number;

	public UncoveredViewWithNumber(int number) {
		super();
		this.number = number;
	}

	@Override
	public void draw(Graphics graphics) {
		switch (number) {
			case 1:
				graphics.setColor(Color.BLUE);
				break;
			case 2:
				graphics.setColor(Color.GREEN);
				break;
			case 3:
				graphics.setColor(Color.RED);
				break;
			case 4:
				;
				break;
			case 5:
				;
				break;
			case 6:
				;
				break;
			case 7:
				;
				break;
			case 8:
				;
				break;
			default:
				return;
		}
		graphics.drawString(Integer.toString(number), 10, 17);
	}
}
