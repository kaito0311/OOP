package Application;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Game", (int)800, (int)640);
		game.start();
	}
}
