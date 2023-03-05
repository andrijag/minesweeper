package main.java.games.minesweeper;

public class Main {
	public static void main(String args[]) {
		System.out.println("Minesweeper");
		Game ms = new Game(9, 9, 10);
		ms.sweep(0, 0);
		ms.sweep(8, 8);
		ms.mark(8, 0);
		System.out.println(ms);
	}
}