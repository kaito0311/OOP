// chuyen nguyen sang 

package Api.creature;

import java.awt.Graphics;
// import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Api.Animation;
import Api.Bom;
import Api.NPC;
import Api.Texture;
import Application.Game;
import Application.GameStart;

// import Game.map.map;
import java.awt.*;

public class Boss extends NPC {
	private int picture_attack = 0;
	private int picture_die = 0;

	// private Game game;
	private Animation boss_up, boss_down, boss_right, boss_left;

	private Attack fire;
	private Bom bom_die;
	double alpha = 0;

	// tao pham vi cho boss di chuyen

	public Boss(Game game, float x, float y, int width, int height, Player player)
	/*
	 * - load vi tri, kich thuoc cho boss - load anh cho boss di chuyen - khoi tao
	 * doi tuong cau lua
	 */
	{
		super(game, player, x, y, width, height);
		// System.out.println(this.x + " " + y);
		// this.player = player;

		// map_world = new map();

		boss_up = new Animation(Texture.boss_up, 200);
		boss_down = new Animation(Texture.boss_down, 200);
		boss_left = new Animation(Texture.boss_left, 200);
		boss_right = new Animation(Texture.boss_right, 200);

		fire = new Attack(game, 0, 0, 192, 192, 0);

		bom_die = new Bom(game, x, y, 160, 116);

		picture_die = 0;

		Center_x = 600;
		Center_y = 440;

		this.health = 1000;

	}

	@Override
	public void tick() {
		update_move();
		boss_state_update();
		move();
		player_attack();
		bom_die.tick();
		fire.tick();
		// unrotate(g);

	}

	private void boss_state_update() {
		boss_up.update();
		boss_down.update();
		boss_left.update();
		boss_right.update();
	}

	protected void update_move() {
		if (check_index(player.getX(), player.getY())) {
			isAttack = true;
			if (Math.abs(player.getX() - x) >= 50.f) {
				if (player.getX() > x + 3.0f) {
					moveX = 3.0f;
				} else
					moveX = -3.0f;
				moveY = 0;
				return;

			}
			if (Math.abs(player.getY() - y) >= 50.0f) {

				if (player.getY() > y + 3.0f) {
					moveY = 3.0f;
				} else
					moveY = -3.0f;
				moveX = 0;

				return;

			}
			// isDie = true;
			moveX = moveY = 0;

			return;

		} else {

			isAttack = false;
			picture_attack = 0;

			// thoi gian boss giu nguyen mot trang thai la 3s
			// kiem tra xem thoi gian vuot qua chua hoac boss da ra ngoai pham vi chua
			if (System.currentTimeMillis() - time_npc_move > 3000 || !check_index(this.x, this.y)) {
				time_npc_move = System.currentTimeMillis();
				// rand = Math.random();
				if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
					setMoveX();
				} else {
					setMoveY();
				}
			}

		}
	}

	public void setMoveX()
	{
		// System.out.println("boss");
		super.setMoveX();
	}
	public void setMoveY()
	{
		// System.out.println("boss");
		super.setMoveY();
	}
	public void moveX()
	{
		if(x + moveX < 0 || x + moveX + width >= GameStart.MAX_WIDTH) 
			// moveX = -moveX;
			return;
		x += moveX;
		
	}

	public void moveY()
	{
		if(y + moveY < 0 || y + moveY + height>= GameStart.MAX_WIDTH) 
			// moveY = -moveY;
			return;
		y += moveY;
	}

	@Override
	protected void attack_update() {
		if (picture_attack >= Texture.getLengthBufferedImage(Texture.fire_attack)) {
			picture_attack = 0;
			fire.setIsBreak(false);
			fire.setIndexAttack(picture_attack);
			// System.out.println("Boss attack");
		}

		if (picture_attack == 0) {
			if(player.getY() < y) 
			fire.setToado(x, y-2);
			else fire.setToado(x, y+10);
			fire.setRoad(player.getX(), player.getY());
			// picture_attack += 1;
		}

		fire.setIndexAttack(picture_attack);
		picture_attack += 1;
		    
		// System.out.println(fire.checkAttack(player.getX(), player.getY()));
		if(getCheckAttack(player.getX(), player.getY()))
		{
			player.hurt(1);
			fire.setIsBreak(true);
		}
		
	}
	public boolean getCheckAttack(float x, float y)
	{
		return fire.checkAttack(x, y);
	}
	public void player_attack() {
		Rectangle bounds1 = player.getCollisionBounds(5);
		Rectangle bounds2 = this.getCollisionBounds(0);
		if (bounds1.intersects(bounds2) && player.isAttack()) {
			this.hurt(player.getDamage());
		}
	}

	private Graphics2D rotate(Graphics g, int up_down) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate((int) (x), (int) (y));

		// System.out.println(x + " " + y);
		float distance_x = player.getX() - this.x;
		float distance_y = this.y - player.getY();
		distance_y *= up_down;
		if (distance_y < 0.000000001) {
			distance_y = 0.00000001f;
		}
		try {
			alpha = Math.atan((double) (distance_x / distance_y)) * up_down;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		g2d.rotate(alpha);
		g2d.translate(-width / 2, -height / 2);

		return g2d;
	}

	private void unrotate(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(0, 0);
		g2d.rotate(-alpha);
	}

	@Override
	public void render(Graphics g) {
		

		// System.out.println(x + " " + Center_x);

		if (dead) {
			if (picture_die < bom_die.getBomAnimation().getImageLength()) {
				picture_die++;
				bom_die.setToado(x, y);
				// bom_die.getBomAnimation().setIndex(picture_die);
				bom_die.render(g);
			}

			return;
		}
		else
		{
		g.setColor(Color.gray);
		g.fillRect((int) x - 45, (int) y - 40, 100, 4);
		g.setColor(Color.red);
		g.fillRect((int) x - 45, (int) y - 40, health / 10, 4);
		}

		if (isAttack) {
			attack_update();
			fire.render(g);
		}
		if (moveX == 0 && moveY == 0) {
			// System.out.println(player.getY() + " " + this.y);/
			if ((int) player.getY() < (int) y) {
				// System.out.println("up");
				rotate(g, 1).drawImage(boss_up.getCurrentImage(Texture.boss_up), (int) 0, (int) 0, width, height, null);
			} else {
				// System.out.println("down");
				rotate(g, -1).drawImage(boss_down.getCurrentImage(Texture.boss_down), (int) 0, (int) 0, width, height,
						null);
			}
		}

		if (moveX < 0) {
			g.drawImage(boss_left.getCurrentImage(Texture.boss_left), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);
		}
		if (moveX > 0) {

			g.drawImage(boss_right.getCurrentImage(Texture.boss_right), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);

		}
		if (moveY < 0) {
			g.drawImage(boss_up.getCurrentImage(Texture.boss_up), (int) (x - width / 2), (int) (y - height / 2), width,
					height, null);

		}
		if (moveY > 0) {
			g.drawImage(boss_down.getCurrentImage(Texture.boss_down), (int) (x - width / 2), (int) (y - height / 2),
					width, height, null);

		}

		unrotate(g);

	}

}