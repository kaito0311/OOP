package api.creature;

import api.Entity;

public abstract class Creature extends Entity{
	
	protected int health;
	protected float speed;
	protected float moveX, moveY;
	
	public Creature(float x, float y, int width, int height) {
		super( x, y, width, height);
		
//		health = HEALTH;
//		speed = SPEED;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getMoveX() {
		return moveX;
	}

	public void setMoveX(float moveX) {
		this.moveX = moveX;
	}

	public float getMoveY() {
		return moveY;
	}

	public void setMoveY(float moveY) {
		this.moveY = moveY;
	}
	
	
	public void move(){
		move_X();
		move_Y();
	}
	public void move_X() {
		
	}
	
	public void move_Y() {
		
	}

	
	
}
