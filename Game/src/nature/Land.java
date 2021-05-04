package nature;

import java.awt.Graphics;
import java.awt.Image;

import api.Entity;
import api.Texture;

public class Land extends Entity{
	private static String[] land = {"land_1","land_2","land_3","land_4"
	,"land_5","land_6","land_7","land_8","land_15","land_9","land_10","land_11","land_13","land_14"};
	private Image texture;
	private String name;
//	id from 1 to 15
	public Land() {
		
	}
	
	public Land(String name,int x,int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void setLand(String name,int x,int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	@Override
	public void update(float delta) {
		
	}
	@Override
	public void render(Graphics g) {
		this.texture = Texture.getTexture(name);
		g.drawImage(texture, (int)(32 * x), (int)(32 *y), null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
