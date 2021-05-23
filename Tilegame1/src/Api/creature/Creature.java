package Api.creature;

import Api.Entity;
// import Api.Tile;
import Application.Game;
import java.awt.Rectangle;
import Application.GameStart;
public abstract class Creature extends Entity {

	protected int health;
	public static final int maxHealth = 300;
	protected float speed;
	protected float moveX, moveY;
	// protected Game game;
	protected Rectangle bounds;
	protected attack_real hmmm = new attack_real(); 

	public Creature(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		moveX = 0;
		moveY = 0;
		bounds = new Rectangle(0, 0, width, height);

		// health = HEALTH;
		// speed = SPEED;
	}

	public void update(float delta) {

		if (health > maxHealth)
			health = maxHealth;
		if (health <= 0) {
			health = 0;
		}
	}

	public void die() {

	}

	public void hurt(int damage) {
		System.out.println("dau day");
		health -= damage;
		if (health <= 0) {
			dead = true;
			die();
		}
	}

	public void heal(int hp) { // hoi mau
		health += hp;
		if (health > maxHealth)
			health = maxHealth;
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

	public void setBoundsX(float x) {
		this.bounds.x = (int) x;
	}

	public void setBoundsY(float y) {
		this.bounds.y = (int) y;
	}

	public Rectangle getCollisionBounds(int range) {
		return new Rectangle((int) (x + bounds.x - range), (int) (y + bounds.y - range), bounds.width + range * 2,
				bounds.height + range * 2);
	}
	public void setRect(int range)
	{
		rect.setBounds((int) (x + bounds.x - range), (int) (y + bounds.y - range), bounds.width + range * 2,
		bounds.height + range * 2);
	}

	public void moveX() {
		if(x + width+moveX >= GameStart.MAX_WIDTH || x + moveX <= 0)
			return;
		if(y + moveY <= 0 || y + height + moveY>= GameStart.MAX_HEIGHT)
			return;


		if (moveX > 0) {
			int tx = (int) (x + moveX + bounds.x + bounds.width) / 32;
			int ty = (int) (y + bounds.y) / 32;
			int tyY = (int) (y + bounds.y + bounds.height) / 32;
			if (!collisionWithTile(tx, ty) && !collisionWithTile(tx, tyY)) {
				x += moveX;
			} else {
				x = tx * 32 + -bounds.width - 1 - bounds.x;
			}
		} else if (moveX < 0) {
			int tx = (int) (x + moveX + bounds.x) / 32;
			int ty = (int) (y + bounds.y) / 32;
			int tyY = (int) (y + bounds.y + bounds.height) / 32;
			if (!collisionWithTile(tx, ty) && !collisionWithTile(tx, tyY)) {
				x += moveX;
			} else {
				x = tx * 32 + 32 - bounds.x;
			}
		}

	}

	public void moveY() {
		if(x + width+moveX >= GameStart.MAX_WIDTH || x + moveX <= 0)
			return;
		if(y + moveY <= 0 || y + height + moveY>= GameStart.MAX_HEIGHT)
			return;

		if (moveY < 0) {
			int ty = (int) ((y + moveY + bounds.y) / 32);
			if (!collisionWithTile((int) (x + bounds.x) / 32, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty)) {
				y += moveY;
			} else {
				y = ty * 32 + 32 - bounds.y;
			}
		} else if (moveY > 0) {
			int ty = (int) (y + moveY + bounds.y + bounds.height) / 32;

			if (!collisionWithTile((int) (x + bounds.x) / 32, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / 32, ty)) {
				y += moveY;
			} else {
				y = ty * 32 - bounds.y - bounds.height - 1;
			}
		}
	}

	public void move() {
		moveX();
		moveY();
	}

	protected boolean collisionWithTile(int x, int y) {
		if (game.getTemp().getIsRock(x, y) == 1)
			return true;
		else
			return false;

	}

}
