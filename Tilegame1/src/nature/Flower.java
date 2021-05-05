package nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import Api.Entity;
import Api.Texture;

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
		index = 6;
		this.x = x;
		this.y = y;
	}
	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(flower[index], (int)(32*x),(int) (32*y), null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
