package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width  = 30, height = 50;
	
	public static BufferedImage player1, player2, player3, player4;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/character.png"));
		
		player1 = sheet.crop(15,7, width, height);
		player2 = sheet.crop(75, 5, width, height);
		player3 = sheet.crop(125, 7, width, height);
		player4 = sheet.crop(180,5, width, height);
	}
	

}
