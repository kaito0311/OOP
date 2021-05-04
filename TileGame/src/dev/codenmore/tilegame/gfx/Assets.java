package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width  = 140, height = 140;
	
	public static BufferedImage player1, player2, player3, player4;
	public static BufferedImage[] player_down, player_up; 
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
		
		player1 = sheet.crop(15,7, width, height);
		player2 = sheet.crop(75, 5, width, height);
		player3 = sheet.crop(15, 7, width, height);
		player4 = sheet.crop(0,5, width, height);
		
		
		player_down = new BufferedImage[8];
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/boss01.png"));
		
		
		
		player_down[0] = sheet.crop(0,0, width, height);
		player_down[1] = sheet.crop(140,0, width, height);
		player_down[2] = sheet.crop(280,0, width, height);
		player_down[3] = sheet.crop(420,0, width, height);
		player_down[4] = sheet.crop(558,0, width,height);
		player_down[5] = sheet.crop(0,149, width, height);
		player_down[6] = sheet.crop(140,149, width, height);
		player_down[7] = sheet.crop(280,149, width, height);
//		player_down[1] = sheet.crop(290,50, width, height);
		
	}
	

}
