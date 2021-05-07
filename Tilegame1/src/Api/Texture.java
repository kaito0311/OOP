package Api;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class Texture {
	public static BufferedImage grass,land,grass_tiny,overworld,water,player,boss, bom;
	public static HashMap<String, Image> tiles = new HashMap<>();
	
	
	public static BufferedImage[] player_down; // luu anh di xuong 
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
    public static BufferedImage[] attack_down;
    public static BufferedImage[] attack_up;
    public static BufferedImage[] attack_right;
    public static BufferedImage[] attack_left;

	public static BufferedImage darkKnight;
	public static BufferedImage[] Knight;


	public static BufferedImage[] boss_up;
	public static BufferedImage[] boss_down;
	public static BufferedImage[] boss_left;
	public static BufferedImage[] boss_right;
	
	public static BufferedImage[] bom_bum;
	public static BufferedImage[] fire_attack;
	public static BufferedImage fire_blue;

	
	public static void loadImage() {
		try {
			grass = ImageIO.read(new File("src/assets/grass.png"));
			land = ImageIO.read(new File("src/assets/land.png"));
			grass_tiny = ImageIO.read(new File("src/assets/grass_tiny.png"));
			overworld = ImageIO.read(new File("src/assets/overworld.png"));
			water = ImageIO.read(new File("src/assets/water.png"));
			player= ImageIO.read(new File("src/assets/character.png"));
			boss=ImageIO.read(new File("src/assets/flying.png"));
			bom = ImageIO.read(new File("src/assets/Fire02.png"));
			fire_blue = ImageIO.read(new File("src/assets/fire_blue.png"));
			darkKnight = ImageIO.read(new File("src/assets/boss01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Image getTexture(String name) {
		return tiles.get(name);
	}

	public static int getLengthBufferedImage(BufferedImage[] Image)
	{
		return Image.length;
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
		boss_up = new BufferedImage[3];
		boss_down = new BufferedImage[3];
		boss_right = new BufferedImage[3];
		boss_left = new BufferedImage[3];


		boss_up[0] = boss.getSubimage(0, 0, 70, 60);
		boss_up[1] = boss.getSubimage(75, 0, 70, 60);
		boss_up[2] = boss.getSubimage(150, 0, 70, 60);

		boss_down[0] = boss.getSubimage(0, 130, 70, 60);
		boss_down[1] = boss.getSubimage(75, 130, 70, 60);
		boss_down[2] = boss.getSubimage(150,130, 70, 60);

		boss_right[0] = boss.getSubimage(0, 60, 70, 60);
		boss_right[1] = boss.getSubimage(75, 60, 70, 60);
		boss_right[2] = boss.getSubimage(150, 60, 70, 60);

		boss_left[0] = boss.getSubimage(0, 190, 70, 60);
		boss_left[1] = boss.getSubimage(75, 190, 70, 60);
		boss_left[2] = boss.getSubimage(150, 190, 70, 60);

		bom_bum = new BufferedImage[25];

		bom_bum[0] = bom.getSubimage(0, 0, 320, 232);
		bom_bum[1] = bom.getSubimage(320, 0, 320, 232);
		bom_bum[2] = bom.getSubimage(640, 0, 320, 232);
		bom_bum[3] = bom.getSubimage(960, 0, 320, 232);
		bom_bum[4] = bom.getSubimage(1280, 0, 320, 232);
		bom_bum[5] = bom.getSubimage(0, 232, 320, 232);
		bom_bum[6] = bom.getSubimage(320, 232, 320, 232);
		bom_bum[7] = bom.getSubimage(640, 232, 320, 232);
		bom_bum[8] = bom.getSubimage(960, 232, 320, 232);
		bom_bum[9] = bom.getSubimage(1280, 232, 320, 232);
		bom_bum[10] = bom.getSubimage(0, 464, 320, 232);
		bom_bum[11] = bom.getSubimage(320, 464, 320, 232);
		bom_bum[12] = bom.getSubimage(640, 464, 320, 232);
		bom_bum[13] = bom.getSubimage(960, 464, 320, 232);
		bom_bum[14] = bom.getSubimage(1280, 464, 320, 232);
		bom_bum[15] = bom.getSubimage(0, 696, 320, 232);
		bom_bum[16] = bom.getSubimage(320, 696, 320, 232);
		bom_bum[17] = bom.getSubimage(640, 696, 320, 232);
		bom_bum[18] = bom.getSubimage(960, 696, 320, 232);
		bom_bum[19] = bom.getSubimage(1280, 696, 320, 232);
		bom_bum[20] = bom.getSubimage(0, 696, 320, 232);
		bom_bum[21] = bom.getSubimage(320, 696, 320, 232);
		bom_bum[22] = bom.getSubimage(640, 696, 320, 232);
		bom_bum[23] = bom.getSubimage(960, 696, 320, 232);
		bom_bum[24] = bom.getSubimage(1280, 696, 320, 232);



		fire_attack = new BufferedImage[20];
		

		fire_attack[0] = fire_blue.getSubimage(0, 0, 192,192);
		fire_attack[1] = fire_blue.getSubimage(192, 0, 192,192);
		fire_attack[2] = fire_blue.getSubimage(384, 0, 192,192);
		fire_attack[3] = fire_blue.getSubimage(576, 0, 192,192);
		fire_attack[4] = fire_blue.getSubimage(768, 0, 192,192);
		fire_attack[5] = fire_blue.getSubimage(0, 192, 192,192);
		fire_attack[6] = fire_blue.getSubimage(192, 192, 192,192);
		fire_attack[7] = fire_blue.getSubimage(384, 192, 192,192);
		fire_attack[8] = fire_blue.getSubimage(576,192, 192,192);
		fire_attack[9] = fire_blue.getSubimage(768, 192, 192,192);
		fire_attack[10] = fire_blue.getSubimage(0, 384, 192,192);
		fire_attack[11] = fire_blue.getSubimage(192, 384, 192,192);
		fire_attack[12] = fire_blue.getSubimage(384, 384, 192,192);
		fire_attack[13] = fire_blue.getSubimage(576, 384, 192,192);
		fire_attack[14] = fire_blue.getSubimage(768, 384, 192,192);
		fire_attack[15] = fire_blue.getSubimage(0, 576, 192,192);
		fire_attack[16] = fire_blue.getSubimage(192, 576, 192,192);
		fire_attack[17] = fire_blue.getSubimage(384, 576, 192,192);
		fire_attack[18] = fire_blue.getSubimage(576, 576, 192,192);
		fire_attack[19] = fire_blue.getSubimage(768, 576, 192,192);



		Knight = new BufferedImage[8];
		Knight[0] = darkKnight.getSubimage(0,0, 140,140);
		Knight[1] = darkKnight.getSubimage(140,0, 140,140);
		Knight[2] = darkKnight.getSubimage(280,0, 140,140);
		Knight[3] = darkKnight.getSubimage(420,0, 140,140);
		Knight[4] = darkKnight.getSubimage(558,0, 140,140);
		Knight[5] = darkKnight.getSubimage(0,149, 140,140);
		Knight[6] = darkKnight.getSubimage(140,149, 140,140);
		Knight[7] = darkKnight.getSubimage(280,149, 140,140);



		 

		
		
	}
}