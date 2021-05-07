package Api.creature;

import java.awt.Graphics;
// import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Api.Animation;
import Api.Bom;
import Api.Texture;
import Application.Game;
// import Game.map.map;
import java.awt.*;

public class Boss extends Creature {
	private int picture_attack = 0;
	private int picture_die = 0;
	// private double rand;

	private Game game;

	// hinh cho boss di chuyen
	private Animation boss_up, boss_down, boss_right, boss_left;

	// private map map_world;
	private Player player;
	//
	// private Random generator = new Random();
	private boolean isAttack; // boss duoc phep tan cong khong
	private boolean isDie;
	private long time_boss_move; // thoi gian di chuyen cua boss
	private Attack fire;
	private Bom bom_die;

	// tao pham vi cho boss di chuyen
	private final float Center_x = 200;
	private final float Center_y = 200;
	private final double R = 200.0;

	public Boss(Game game, float x, float y, int width, int height, Player player)
	/*
	 * - load vi tri, kich thuoc cho boss - load anh cho boss di chuyen - khoi tao
	 * doi tuong cau lua
	 */
	{
		super(x, y, width, height);
		this.game = game;
		this.player = player;

		// map_world = new map();

		boss_up = new Animation(Texture.boss_up, 200);
		boss_down = new Animation(Texture.boss_down, 200);
		boss_left = new Animation(Texture.boss_left, 200);
		boss_right = new Animation(Texture.boss_right, 200);

		fire = new Attack(game, 0, 0, 192, 192, 0);

		bom_die = new Bom(game, x, y, 160, 116);

		isAttack = false;
		isDie = false;
		picture_die = 0;

	}

	@Override
	public void tick() {

		update_move();
		boss_state_update();
		move();
		bom_die.tick();

	}

	private void boss_state_update() {
		boss_up.update();
		boss_down.update();
		boss_left.update();
		boss_right.update();
	}

	// Check toa do so voi tam vong tron
	private boolean check_index(Float index_x, Float index_y) {
		double a = Math.sqrt((index_x - Center_x) * (index_x - Center_x) + (index_y - Center_y) * (index_y - Center_y));
		if (a >= R) {
			return false;
		} else
			return true;
	}

	private void setMoveX() {
		if (check_index(x, y)) {
			if (ThreadLocalRandom.current().nextInt(1, 100) < 50)
				moveX = -2.0f;
			else
				moveX = 2.0f;
		} else {
			if (Center_x > x) {
				moveX = 2.0f;
			} else
				moveX = -2.0f;
		}
		moveY = 0;
	}

	private void setMoveY() {
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
		moveX = 0;
	}

	private void update_move() {
		if (check_index(player.getX(), player.getY())) {
			isAttack = true;
			if (Math.abs(player.getX() - x) >= 10.f) {
				if (player.getX() > x) {
					moveX = 3.0f;
				} else
					moveX = -3.0f;
				moveY = 0;
				return;

			}
			if (Math.abs(player.getY() - y) >= 10.0f) {

				if (player.getY() > y) {
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
			if (System.currentTimeMillis() - time_boss_move > 3000 || !check_index(this.x, this.y)) {
				time_boss_move = System.currentTimeMillis();
				// rand = Math.random();
				if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
					setMoveX();
				} else {
					setMoveY();
				}
			}

		}
	}

	private void attack_update() {
		if (picture_attack >= Texture.fire_attack.length) {
			picture_attack = 0;
			fire.setIndexAttack(picture_attack);
		}
		// System.out.println(picture_attack);
		if (picture_attack == 0) {
			// System.out.println("sg");
			fire.setToado(x + 2, y + 1);
			fire.setRoad(player.getX(), player.getY());
			picture_attack += 1;
		}

		fire.tick();
		picture_attack += 1;
	}

	private Graphics2D rotate(Graphics g, int up_down) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate((int) (x), (int) (y));
		double alpha = 0;
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

	@Override
	public void render(Graphics g) {
		if (isDie) {
			if (picture_die < bom_die.getBomAnimation().getImageLength()) {
				picture_die++;
				bom_die.setToado(x, y);
				// bom_die.getBomAnimation().setIndex(picture_die);
				bom_die.render(g);
			}

			return;
		}

		if (isAttack) {
			attack_update();
			fire.render(g);
		}
		if (moveX == 0 && moveY == 0) {
			System.out.println(player.getY() + " " + this.y);
			if ((int) player.getY() < (int) y) {
				System.out.println("up");
				rotate(g, 1).drawImage(boss_up.getCurrentImage(Texture.boss_up), (int) 0, (int) 0, width, height, null);
			} else {
				System.out.println("down");
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

	}

}