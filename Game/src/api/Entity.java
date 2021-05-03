package api;

import java.awt.Graphics;

public abstract class Entity {
	public int x;
	public int y;
	public int width;
	public int height;
	
	public Entity() {
		
	}
	
	public abstract void update(float delta);
	public abstract void render(Graphics g);    
}
