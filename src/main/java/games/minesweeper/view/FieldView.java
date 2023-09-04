package main.java.games.minesweeper.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class FieldView extends JButton {
	private static final long serialVersionUID = 1L;
	private int row;
	private int column;
	
	public FieldView(int row, int column) {
		super();
		setPreferredSize(new Dimension(50, 50));
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
    } 
}
