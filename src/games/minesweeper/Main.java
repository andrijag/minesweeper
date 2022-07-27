package games.minesweeper;

public class Main {
	public static void main(String args[]) {
		System.out.println("Minesweeper");
		Minefield mf = new Minefield(10, 10);
		System.out.println(mf);
	}
}
