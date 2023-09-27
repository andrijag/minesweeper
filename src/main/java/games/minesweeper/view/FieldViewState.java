package main.java.games.minesweeper.view;

import java.awt.Graphics;

abstract class FieldViewState {
	abstract void draw(Graphics graphics, int x, int y, int width, int height);
}
