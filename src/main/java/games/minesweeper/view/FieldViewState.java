package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public abstract class FieldViewState {
	public abstract void draw(Graphics graphics, int x, int y, int width, int height);

	protected void writeText(Graphics graphics, String text, int x, int y, int width, int height) {
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int textWidth = fontMetrics.stringWidth(text);
		int textHeight = fontMetrics.getAscent();
		int textX = x + (width - textWidth) / 2;
		int textY = y + (height + textHeight) / 2;
		graphics.drawString(text, textX, textY);
	}

	protected void drawMine(Graphics graphics, int x, int y, int width, int height) {
		graphics.setColor(Color.BLACK);
		int mineWidth = 10;
		int mineX = x + (width - mineWidth) / 2;
		int mineY = y + (height - mineWidth) / 2;
		graphics.fillOval(mineX, mineY, mineWidth, mineWidth);

		int hornsWidth = 14;
		int hornsX1 = x + (width - hornsWidth) / 2;
		int hornsX2 = hornsX1 + hornsWidth;
		int hornsY1 = y + (height - hornsWidth) / 2;
		int hornsY2 = hornsY1 + hornsWidth;
		graphics.drawLine((hornsX1 + hornsX2) / 2, hornsY1, (hornsX1 + hornsX2) / 2, hornsY2);
		graphics.drawLine(hornsX1, (hornsY1 + hornsY2) / 2, hornsX2, (hornsY1 + hornsY2) / 2);

		int diagonalhornsWidth = 10;
		int diagonalhornsX1 = x + (width - diagonalhornsWidth) / 2;
		int diagonalhornsX2 = diagonalhornsX1 + diagonalhornsWidth;
		int diagonalhornsY1 = x + (width - diagonalhornsWidth) / 2;
		int diagonalhornsY2 = diagonalhornsY1 + diagonalhornsWidth;
		graphics.drawLine(diagonalhornsX1, diagonalhornsY1, diagonalhornsX2, diagonalhornsY2);
		graphics.drawLine(diagonalhornsX2, diagonalhornsY1, diagonalhornsX1, diagonalhornsY2);

		graphics.setColor(Color.WHITE);
		int shineWidth = 3;
		int shineX = x + width / 2 - shineWidth;
		int shineY = y + height / 2 - shineWidth;
		graphics.fillOval(shineX, shineY, shineWidth, shineWidth);
	}
}
