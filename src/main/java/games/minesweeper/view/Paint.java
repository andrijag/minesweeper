package main.java.games.minesweeper.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

class Paint {
	static void writeText(Graphics graphics, String text, int x, int y, int width, int height) {
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int textWidth = fontMetrics.stringWidth(text);
		int textHeight = fontMetrics.getAscent();
		int textX = x + (width - textWidth) / 2;
		int textY = y + (height + textHeight) / 2;
		graphics.drawString(text, textX, textY);
	}

	static Color getNumberColor(int number) {
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
			return Color.BLACK;
		}
	}

	static void drawMine(Graphics graphics, int x, int y, int width, int height) {
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

	static void drawFlag(Graphics graphics, int x, int y, int width, int height) {
		int poleHeight = 9;
		int flagWidth = 6;
		int flagHeight = 6;

		graphics.setColor(Color.BLACK);
		int poleX = x + (width + flagWidth) / 2;
		int poleY1 = y + (height - poleHeight) / 2;
		int poleY2 = poleY1 + poleHeight;
		graphics.drawLine(poleX, poleY1, poleX, poleY2);

		graphics.setColor(Color.RED);
		int flagX1 = x + (width - flagWidth) / 2;
		int flagX2 = flagX1 + flagWidth;
		int flagY1 = y + (height - poleHeight) / 2;
		int flagY2 = flagY1 + flagHeight;
		int[] flagXPoints = { flagX2, flagX1, flagX2 };
		int[] flagYPoints = { flagY1, (flagY1 + flagY2) / 2, flagY2 };
		int numberOfPoints = 3;
		graphics.fillPolygon(flagXPoints, flagYPoints, numberOfPoints);
	}
}
