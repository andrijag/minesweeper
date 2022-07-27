package games.minesweeper;

public class Main {
	public static void main(String args[]) {
		System.out.println("Minesweeper");
		Minefield mf = new Minefield(10, 10);
		Minelayer ml = new Minelayer(mf, 9);
		ml.layMines();
		System.out.println("|>");
	}
}
