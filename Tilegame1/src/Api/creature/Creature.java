package Api.creature;

import Api.Entity;
import Api.Tile;
import Application.Game;
import java.awt.Rectangle;

public abstract class Creature extends Entity{
	
	protected int health,maxHealth;
	protected float speed;
	protected float moveX, moveY;
	// protected Game game;
	protected Rectangle bounds;
	
	public Creature(Game game,float x, float y, int width, int height) {
		super(game, x, y, width, height);
		moveX=0;
		moveY=0;
		bounds = new Rectangle(2,2,20,20);
		

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
	public void moveX()
	{
		if(moveX >0)
		{
			int tx = (int) (x + moveX + bounds.x+ bounds.width)/32;
			int ty = (int) ( y + bounds.y)/32;
			int tyY = (int)(y + bounds.y + bounds.height)/32;
			if(!collisionWithTile(tx, ty) && !collisionWithTile(tx,tyY))
			{
				x += moveX;
			}
			else
			{
				x = tx*32+ -bounds.width-1 - bounds.x;
			}
		}
		else if ( moveX < 0)
		{
			int tx = (int) (x + moveX + bounds.x)/32;
			int ty = (int) ( y + bounds.y)/32;
			int tyY = (int)(y + bounds.y + bounds.height)/32;
			if(!collisionWithTile(tx, ty) && !collisionWithTile(tx,tyY))
			{
				x += moveX;
			}
			else
			{
				x = tx*32 + 32 - bounds.x;
			}
		}

	}
	public void moveY()
	{
		if(moveY <0)
		{
			int ty = (int)((y + moveY +bounds.y)/32);
			if(!collisionWithTile((int)(x + bounds.x)/32, ty)
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/32, ty))
			{
				y+= moveY;
			}
			else
			{
				y = ty*32 + 32 - bounds.y ;
			}
		}
		else if(moveY > 0)
		{
			int ty = (int) (y + moveY + bounds.y + bounds.height) / 32;
			
			if(!collisionWithTile((int) (x + bounds.x) / 32, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty)){
				y += moveY;
			}else{
				y = ty * 32 - bounds.y - bounds.height - 1;
			}
		}
	}
	
	
	public void move(){
		moveX();
		moveY();
	}
	protected boolean collisionWithTile(int x, int y)
	{
		if(game.getTemp().getIsRock(x, y) == 1)
			return true;
		else return false;

	}
	
}
