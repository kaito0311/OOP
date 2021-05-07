package Api.creature;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Api.Animation;
import Api.Texture;
import Application.Game;
import Game.map.map;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Boss extends Creature {
	private int dem = 0;
	private double rand;

	private Game game;

	// hinh cho boss di chuyen
	private Animation boss_up, boss_down, boss_right, boss_left;

	private map map_world;
	private Player player;
	//
	private Random generator = new Random();
	private boolean isAttack; // boss duoc phep tan cong khong
	private long time_boss_move; // thoi gian di chuyen cua boss
	private Attack fire;

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

		map_world = new map();

		boss_up = new Animation(Texture.boss_up, 200);
		boss_down = new Animation(Texture.boss_down, 200);
		boss_left = new Animation(Texture.boss_left, 200);
		boss_right = new Animation(Texture.boss_right, 200);

		fire = new Attack(game, 0, 0, 192, 192, 0);

		isAttack = false;

	}

	@Override
	public void tick() {

		update_move();
		boss_state_update();
		move();

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
			if (Math.abs(player.getX() - x) >= 100.f) {
				if (player.getX() > x) {
					moveX = 3.0f;
				} else
					moveX = -3.0f;
				moveY = 0;
				return;

			}
			if (Math.abs(player.getY() - y) >= 100.0f) {

				if (player.getY() > y) {
					moveY = 3.0f;
				} else
					moveY = -3.0f;
				moveX = 0;

				return;

			}
			moveX = moveY = 0;

			return;

		} else {

			isAttack = false;
			dem = 0;

			// thoi gian boss giu nguyen mot trang thai la 3s
			// kiem tra xem thoi gian vuot qua chua hoac boss da ra ngoai pham vi chua
			if (System.currentTimeMillis() - time_boss_move > 3000 || !check_index(this.x, this.y)) {
				time_boss_move = System.currentTimeMillis();
				rand = Math.random();
				if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
					setMoveX();
				} else {
					setMoveY();
				}
			}

		}
	}

	private void attack_update() {
		if (dem >= Texture.fire_attack.length) {
			dem = 0;
			fire.setIndexAttack(dem);
		}
		System.out.println(dem);
		if (dem == 0) {
			System.out.println("sg");
			fire.setToado(x, y);
			fire.setRoad(player.getX(), player.getY());
			dem += 1;
		}

		fire.tick();
		dem += 1;
	}

	@Override
	public void render(Graphics g) {

		if (isAttack) {
			attack_update();
			fire.render(g);
		}
		if (moveX == 0 && moveY == 0) {

			// g.drawImage(boss_left.getCurrentImage(Texture.boss_left), (int) x, (int) y, width, height, null);

			AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(45),width/2, height/2);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(x, y);
			g2d.rotate(0.5235987756);
			g2d.drawImage(boss_down.getCurrentImage(Texture.boss_down),0,0, width, height, null);


			}
		
		if (moveX < 0) {
			g.drawImage(boss_left.getCurrentImage(Texture.boss_left), (int) x, (int) y, width, height, null);
		}
		if (moveX > 0) {

			g.drawImage(boss_right.getCurrentImage(Texture.boss_right), (int) x, (int) y, width, height, null);

		}
		if (moveY < 0) {
			g.drawImage(boss_up.getCurrentImage(Texture.boss_up), (int) x, (int) y, width, height, null);

		}
		if (moveY > 0) {
			g.drawImage(boss_down.getCurrentImage(Texture.boss_down), (int) x, (int) y, width, height, null);

		}

	}

}