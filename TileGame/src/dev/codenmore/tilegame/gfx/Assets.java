package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width  = 240, height = 290;
	
	public static BufferedImage player1, player2, player3, player4;
	public static BufferedImage[] player_down, player_up; 
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
		
		player1 = sheet.crop(15,7, width, height);
		player2 = sheet.crop(75, 5, width, height);
		player3 = sheet.crop(15, 7, width, height);
		player4 = sheet.crop(0,5, width, height);
		
		
		player_down = new BufferedImage[4];
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pngegg.png"));
		

		
		player_down[0] = sheet.crop(60,50, width, height);
		player_down[1] = sheet.crop(300,50, width, height);
		player_down[2] = sheet.crop(570,70, width, height);
		player_down[3] = sheet.crop(860,70, width, height);
//		player_down[1] = sheet.crop(290,50, width, height);
		
	}
	

}
