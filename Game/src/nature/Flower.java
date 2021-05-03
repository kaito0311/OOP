package nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import api.Entity;
import api.Texture;

public class Flower extends Entity{
	private Random rd;
	int index;
	private Image[] flower = {
			Texture.getTexture("flower_1"),Texture.getTexture("flower_2"),
			Texture.getTexture("flower_3"),Texture.getTexture("flower_4"),
			Texture.getTexture("flower_5"),Texture.getTexture("flower_6"),
			Texture.getTexture("flower_7"),Texture.getTexture("flower_8")
	};
//	id  = 17
	public Flower() {
		rd = new Random();
	}
	
	public void setFlower(int x,int y) {
		index = rd.nextInt(8);
		this.x = x;
		this.y = y;
	}
	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(flower[index], 32*x, 32*y, null);
	}
	
}
