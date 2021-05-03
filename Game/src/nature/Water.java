package nature;

import java.awt.Graphics;
import java.awt.Image;

import api.Entity;
import api.Texture;

public class Water extends Entity{
	private String name;
	private Image temp;
	private Image water[] = {
			Texture.getTexture("water_1"),Texture.getTexture("water_2"),
			Texture.getTexture("water_3"),Texture.getTexture("water_4"),
			Texture.getTexture("water_5")
	};
//	id from 21 to 35
	
	public Water() {
		
	}
	public void setWater(String name,int x,int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics g) {
		temp = Texture.getTexture(name);
		g.drawImage(temp, x*32, y*32, null);
	}
	
}
