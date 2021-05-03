package api;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class Texture {

	
	public static BufferedImage grass,land,grass_tiny,overworld,water;
	public static HashMap<String, Image> tiles = new HashMap<>();

	
	public static void loadImage() {
		try {
			grass = ImageIO.read(new File("src/assets/grass.png"));
			land = ImageIO.read(new File("src/assets/land.png"));
			grass_tiny = ImageIO.read(new File("src/assets/grass_tiny.png"));
			overworld = ImageIO.read(new File("src/assets/overworld.png"));
			water = ImageIO.read(new File("src/assets/water.png"));
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
		
		System.out.println("Loading Successful");
	}
}