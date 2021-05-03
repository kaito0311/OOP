package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f; 
	public static final int DEFAULT_CREATURE_WIDTH = 160,
							DEFAULT_CREATURE_HEIGHT = 260;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}

	public void move()
	{
		moveX();
		moveY();
	}
	
	public void moveX()
	{
		if(xMove >0)
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
			int ty = (int) ( y + bounds.y)/Tile.TILEHEIGHT;
			int tyY = (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT;
			if(!collisionWithTile(tx, ty) && !collisionWithTile(tx,tyY))
			{
				x += xMove;
			}
			else
			{
				x = tx*Tile.TILEWIDTH - bounds.x - bounds.width;
			}
		}
		else if ( xMove < 0)
		{
			int tx = (int) (x + xMove + bounds.x )/Tile.TILEWIDTH;
			int ty = (int) ( y + bounds.y)/Tile.TILEHEIGHT;
			int tyY = (int)(y + bounds.y + bounds.height)/Tile.TILEHEIGHT;
			if(!collisionWithTile(tx, ty) && !collisionWithTile(tx,tyY))
			{
				x += xMove;
			}
			else
			{
				x = tx*Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	public void moveY()
	{
		if(yMove <0)
		{
			int ty = (int)(y + yMove +bounds.y)/Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))
			{
				y+= yMove;
			}
			else
			{
				y = ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if(yMove > 0)
		{
			int ty = (int)(y + yMove +bounds.y+ bounds.height)/Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH, ty))
			{
				y+= yMove;
			}
			else
			{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}	
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
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
