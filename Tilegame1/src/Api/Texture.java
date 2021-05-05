package Api;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class Texture {
	public static BufferedImage grass,land,grass_tiny,overworld,water,player,boss;
	public static HashMap<String, Image> tiles = new HashMap<>();
	
	
	public static BufferedImage[] player_down; // luu anh di xuong 
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
    public static BufferedImage[] attack_down;
    public static BufferedImage[] attack_up;
    public static BufferedImage[] attack_right;
    public static BufferedImage[] attack_left;
	public static BufferedImage[] boss_right;
	
	public static void loadImage() {
		try {
			grass = ImageIO.read(new File("src/assets/grass.png"));
			land = ImageIO.read(new File("src/assets/land.png"));
			grass_tiny = ImageIO.read(new File("src/assets/grass_tiny.png"));
			overworld = ImageIO.read(new File("src/assets/overworld.png"));
			water = ImageIO.read(new File("src/assets/water.png"));
			player= ImageIO.read(new File("src/assets/character.png"));
			boss=ImageIO.read(new File("src/assets/boss01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Image getTexture(String name) {
		return tiles.get(name);
	}
	public static void loadTextures() {
		loadImage();
		tiles.put("grass_0", grass_tiny.getSubimage(0, 32*4, 32, 32));
		tiles.put("land_1", land.getSubimage(32*2, 0, 32, 32));
		tiles.put("land_2", land.getSubimage(32*5, 0, 32, 32));
		tiles.put("land_3", land.getSubimage(32*6, 0, 32, 32));
		tiles.put("land_4", land.getSubimage(32*7, 0, 32, 32));
		tiles.put("land_5", land.getSubimage(32*7, 32, 32, 32));
		tiles.put("land_6", land.getSubimage(32*6, 32, 32, 32));
		tiles.put("land_7", land.getSubimage(32*5, 32, 32, 32));
		tiles.put("land_8", land.getSubimage(32*7, 32*2, 32, 32));
		tiles.put("land_9", land.getSubimage(32*6, 32*2, 32, 32));
		tiles.put("land_10", land.getSubimage(32*5, 32*2, 32, 32));
		tiles.put("land_11", land.getSubimage(0, 32, 32, 32));
		tiles.put("land_12", land.getSubimage(32, 32, 32, 32));
		tiles.put("land_13", land.getSubimage(0, 32*2, 32, 32));
		tiles.put("land_14", land.getSubimage(32, 32*2, 32, 32));
		tiles.put("land_15", land.getSubimage(32*4, 32, 32, 32));
		tiles.put("tree_1", overworld.getSubimage(0, 5*32, 32, 32));
		tiles.put("tree_2", overworld.getSubimage(32, 5*32, 32, 32));
		tiles.put("tree_3", overworld.getSubimage(32*2, 5*32, 32, 32));
		tiles.put("water_1", water.getSubimage(2*32, 0, 32, 32));
		tiles.put("water_2", water.getSubimage(4*32, 32, 32, 32));
		tiles.put("water_3", water.getSubimage(5*32, 0, 32, 32));
		tiles.put("water_4", water.getSubimage(6*32, 0, 32, 32));
		tiles.put("water_5", water.getSubimage(7*32, 0, 32, 32));
		tiles.put("water_6", water.getSubimage(7*32, 32, 32, 32));
		tiles.put("water_7", water.getSubimage(5*32, 32, 32, 32));
		tiles.put("water_8", water.getSubimage(7*32, 32*2, 32, 32));
		tiles.put("water_9", water.getSubimage(6*32, 32*2, 32, 32));
		tiles.put("water_10", water.getSubimage(5*32, 32*2, 32, 32));
		tiles.put("water_11", water.getSubimage(0, 32, 32, 32));
		tiles.put("water_12", water.getSubimage(32, 32, 32, 32));
		tiles.put("water_13", water.getSubimage(32, 32*2, 32, 32));
		tiles.put("water_14", water.getSubimage(0, 2*32 ,32, 32));
		tiles.put("water_15", water.getSubimage(6*32, 32 ,32, 32));
		tiles.put("flower_1",overworld.getSubimage(0, 6*32, 32, 32));
		tiles.put("flower_2",overworld.getSubimage(32, 6*32, 32, 32));
		tiles.put("flower_3",overworld.getSubimage(32*2, 6*32, 32, 32));
		tiles.put("flower_4",overworld.getSubimage(32*3, 6*32, 32, 32));
		tiles.put("flower_5",overworld.getSubimage(32*4, 6*32, 32, 32));
		tiles.put("flower_6",overworld.getSubimage(32*5, 6*32, 32, 32));
		tiles.put("flower_7",overworld.getSubimage(32*6, 6*32, 32, 32));
		tiles.put("flower_8",overworld.getSubimage(32*7, 6*32, 32, 32));
		
		player_down =  new BufferedImage[4];
		player_up =  new BufferedImage[4];
		player_right =  new BufferedImage[4];
		player_left =  new BufferedImage[4];
        attack_up= new BufferedImage[4];
        attack_down= new BufferedImage[4];
        attack_right= new BufferedImage[4];
        attack_left= new BufferedImage[4];

		player_down[0] = player.getSubimage(0, 5, 16, 23);
		player_down[1] = player.getSubimage(16, 5, 16, 23);
		player_down[2] = player.getSubimage(32, 5, 16, 23);
		player_down[3] = player.getSubimage(48, 5, 16, 23);

		player_up[0] = player.getSubimage(0, 69, 16, 23);
		player_up[1] = player.getSubimage(16, 69, 16, 23);
		player_up[2] = player.getSubimage(32, 69, 16, 23);
		player_up[3] = player.getSubimage(48, 69, 16, 23);

		player_left[0] = player.getSubimage(0, 101, 16, 23);
		player_left[1] = player.getSubimage(16, 101, 16, 23);
		player_left[2] = player.getSubimage(32, 101, 16, 23);
		player_left[3] = player.getSubimage(48, 101, 16, 23);

		player_right[0] = player.getSubimage(0, 37, 16, 23);
		player_right[1] = player.getSubimage(16, 37, 16, 23);
		player_right[2] = player.getSubimage(32, 37, 16, 23);
		player_right[3] = player.getSubimage(48, 37, 16, 23);
		
		attack_down[0] = player.getSubimage(7, 133, 18, 23);
		attack_down[1] = player.getSubimage(39, 133, 18, 23);
		attack_down[2] = player.getSubimage(71, 133, 18, 23);
		attack_down[3] = player.getSubimage(104, 133, 18, 23);
		
		attack_up[0] = player.getSubimage(7, 165, 18, 23);
		attack_up[1] = player.getSubimage(39, 165, 18,23);
		attack_up[2] = player.getSubimage(71, 165, 18, 23);
		attack_up[3] = player.getSubimage(104, 165, 18, 23);
		
		attack_right[0] = player.getSubimage(8, 198, 18, 23);
		attack_right[1] = player.getSubimage(40, 198, 21, 23);
		attack_right[2] = player.getSubimage(71, 198, 18, 23);
		attack_right[3] = player.getSubimage(104, 198, 18, 23);
		
		attack_left[0] = player.getSubimage(8, 230, 16, 23);
		attack_left[1] = player.getSubimage(32, 230, 20, 23);
		attack_left[2] = player.getSubimage(67, 230, 18, 23);
		attack_left[3] = player.getSubimage(100, 230, 20, 23);


		// load boss image 
		boss_right = new BufferedImage[8];
		 
		boss_right[0] = boss.getSubimage(0,0, 140, 140);
		boss_right[1] = boss.getSubimage(140,0, 140, 140);
		boss_right[2] = boss.getSubimage(280,0, 140, 140);
		boss_right[3] = boss.getSubimage(420,0, 140, 140);
		boss_right[4] = boss.getSubimage(558,0, 140,140);
		boss_right[5] = boss.getSubimage(0,149, 140, 140);
		boss_right[6] = boss.getSubimage(140,149, 140, 140);
		boss_right[7] = boss.getSubimage(280,149, 140, 140);
		
		
	}
}