package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f; 
	public static final int DEFAULT_CREATURE_WIDTH = 20,
							DEFAULT_CREATURE_HEIGHT = 33;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Game game,float x, float y, int width, int height) {
		super(game, x, y, width, height);
		
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}

	public void move()
	{
		x += xMove;
		y += yMove;
	}




	//getter and setter
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	

}
