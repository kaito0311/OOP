package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;

public class Lancher {
	public static void main(String[] args)
	{
//		new Game("tile game!",640,3260);
		Game game = new Game("tile game!", 640, 360);
		game.start();
	}



}
