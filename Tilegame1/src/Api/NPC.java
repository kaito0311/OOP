
// chuyen nguyen sang (tanminh)
package Api;

import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import Api.creature.Creature;
import Api.creature.Player;
import Application.Game;
import Application.GameStart;
// import state.GameState;

public abstract class NPC extends Creature {
	// protected float x, y;
	// protected int width, height;
	protected boolean dead = false;
	protected Player player;
	protected boolean isAttack;
	protected long time_npc_move;
	protected float Center_x;
	protected float Center_y;
	protected double R;
	protected Game game;
	protected Knights quai;

	public NPC(Game game, Player player, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		this.player = player;
		Center_x = 200;
		Center_y = 200;
		R = 200.0;
		isAttack = false;
		time_npc_move = 0;
		dead = false;

	}

	public float getCenter_x() {
		return Center_x;
	}

	public void setCenter_x(float center_x) {
		Center_x = center_x;
	}

	public float getCenter_y() {
		return Center_y;
	}

	public void setCenter_y(float center_y) {
		Center_y = center_y;
	}

	public double getR() {
		return R;
	}

	public void setR(double r) {
		R = r;
	}

	public void die() {
		if (this.health <= 0)
			dead = true;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	protected boolean check_index(Float index_x, Float index_y) {
		double a = Math.sqrt((index_x - Center_x) * (index_x - Center_x) + (index_y - Center_y) * (index_y - Center_y));
		if (a >= R) {
			return false;
		} else
			return true;
	}

	protected void player_attack() {
		if(player.isAttack()== false) return ;
		this.setRect(0);
		player.setRect(5);

		hmmm.attack(this, player, 2);
	}
	protected void attack_player()
	{
		this.setRect(0);
		player.setRect(0);
		hmmm.attack(player, this, 2);
	}

	protected void setMoveX() {
		moveX = 0;
		moveY = 0;
		// if(this.x > 0 && this.x < GameStart.MAX_WIDTH-32) {
		if (check_index(x, y)) {
			if (ThreadLocalRandom.current().nextInt(1, 100) < 50)
			{
				moveX = -2.0f;
			}
			else moveX = 2.0f;
		} else {
			if (Center_x > x) {
				moveX = 2.0f;
			} else
				moveX = -2.0f;
		}

	}


	protected void setMoveY() {
		moveX = 0;
		moveY = 0;

		if (check_index(this.x, this.y)) {

			if (ThreadLocalRandom.current().nextInt(1, 100) < 50)
				moveY = -2.0f;
			else
				moveY = 2.0f;
		} else {
			if (Center_y > y) {
				moveY = 2.0f;
			} else
				moveY = -2.0f;
		}
		// moveX = 0;


	}

	// protected void setMoveYBoss() {
	// 	moveX = 0;
	// 	moveY = 0;

	// 	if (check_index(this.x, this.y)) {

	// 		if (ThreadLocalRandom.current().nextInt(1, 100) < 50)
	// 			if (this.y > 192)
	// 				moveY = -3.0f;
	// 			else if (y < GameStart.MAX_HEIGHT - 192)
	// 				moveY = 3.0f;
	// 	} else {
	// 		if (Center_y > y) {
	// 			if (y < GameStart.MAX_HEIGHT - 192)
	// 				moveY = 3.0f;
	// 		} else if (this.y > 192)
	// 			moveY = -3.0f;
	// 	}
	// 	// moveX = 0;

	// }

	protected abstract void update_move();

	protected abstract void attack_update();

}
