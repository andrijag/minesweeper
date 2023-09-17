package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.Graphics;

public class UncoveredViewWithMine extends FieldViewState {
	private boolean isDetonated;

	public UncoveredViewWithMine(boolean isDetonated) {
		super();
		this.isDetonated = isDetonated;
	}

	@Override
	public void draw(Graphics graphics) {
		if (isDetonated) {
			graphics.setColor(Color.RED);
			graphics.fillRect(0, 0, 25, 25);
		}
		graphics.setColor(Color.BLACK);
		graphics.fillOval(7, 7, 25 - 7 - 7, 25 - 7 - 7);
		graphics.drawLine(5, 25 / 2, 20, 25 / 2);
		graphics.drawLine(25 / 2, 5, 25 / 2, 20);
		graphics.drawLine(7, 7, 25 - 7, 25 - 7);
		graphics.drawLine(7, 25 - 7, 25 - 7, 7);
		graphics.setColor(Color.WHITE);
		graphics.fillOval(10, 10, 3, 3);
	}
}
