package Api;

import java.awt.Graphics;

import Application.Game;
import java.awt.Rectangle;

public abstract class Entity {

	protected float x,y;// chinh lai o cac cho khac tu int o thanh (int)(o)
	protected int width, height;
	
	protected boolean dead = false;
	
	protected int HP, maxHP;
	public Game game;
	protected Rectangle rect;

	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Entity(Game game,float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game = game;
		rect = new Rectangle((int)x,(int) y, width, height);
		
	}
	public void setRect(int x, int y, int width, int height)
	{
		rect.setBounds((int)x, (int)y, width, height);
	}
	public Rectangle getRect()
	{
		return this.rect;
	}
	
	public Entity() {
		
	}
	
	public void update(float delta) {
		
		if (HP > maxHP) HP = maxHP;
        if (HP <= 0) {
            HP = 0;
        }
	}
	public abstract void tick();    
	 
	public abstract void render(Graphics g);   
}
