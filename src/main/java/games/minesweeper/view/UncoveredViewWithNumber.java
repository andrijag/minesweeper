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
			graphics.setColor(Color.GREEN.darker());
			break;
		case 3:
			graphics.setColor(Color.RED);
			break;
		case 4:
			graphics.setColor(Color.BLUE.darker());
			break;
		case 5:
			graphics.setColor(Color.RED.darker());
			break;
		case 6:
			graphics.setColor(Color.CYAN.darker());
			break;
		case 7:
			graphics.setColor(Color.BLACK);
			break;
		case 8:
			graphics.setColor(Color.GRAY);
			break;
		default:
			return;
		}
		graphics.drawString(Integer.toString(number), 10, 17);
	}
}
