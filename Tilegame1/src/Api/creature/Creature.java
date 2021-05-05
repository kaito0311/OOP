package Api.creature;

import Api.Entity;

public abstract class Creature extends Entity{
	
	protected int health,maxHealth;
	protected float speed;
	protected float moveX, moveY;
	
	public Creature(float x, float y, int width, int height) {
		super( x, y, width, height);
		moveX=0;
		moveY=0;
//		health = HEALTH;
//		speed = SPEED;
	}
    public void update(float delta) {
		
		if (health > maxHealth) health = maxHealth;
        if (health <= 0) {
            health = 0;
        }
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
		x+=moveX;
		y+=moveY;
	}
	
}
