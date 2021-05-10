// Copy Alll

package Api.creature;

import java.awt.Color;
import java.awt.Graphics;

import Api.Animation;
// import Api.Knights;
import Api.Texture;
import Application.Game;
import Application.GameStart;
// import state.GameState;

import java.awt.Rectangle;

public class Player extends Creature {

	private int dem = 0;
	private int previous_state = 0;
	private int damage;
	private boolean isAttack = false;

	private Rectangle rect;// Copy tu tuyen(Minh)
	// Rectangle bounds;
	// private Game game;
	private Animation player_up, player_down, player_right, player_left;
	private Animation attack_up, attack_down, attack_right, attack_left;
	private long cooldown = 1000, time = 5000, lasttime = 0; // thoi gian delay don danh , thoi gian do khoang cach 2 la
	// private Knights npc;

	public Player(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);

		rect = new Rectangle((int)x,(int)y,width,height);// Copy tu Tuyen (Minh)
		if (this.game == null) {
			System.out.println("ha");
		}
		// this.game = game;
		this.damage = 5;
		this.health = 300;
		player_up = new Animation(Texture.player_up, 300);
		player_down = new Animation(Texture.player_down, 300);
		player_left = new Animation(Texture.player_left, 300);
		player_right = new Animation(Texture.player_right, 300);

		attack_up = new Animation(Texture.attack_up, 100);
		attack_down = new Animation(Texture.attack_down, 100);
		attack_left = new Animation(Texture.attack_left, 100);
		attack_right = new Animation(Texture.attack_right, 100);

		bounds.x = 10;
		bounds.y = 20;
		bounds.width = 6;
		bounds.height = 8;

		// System.out.println("ak");
	}

	@Override
	public void tick() {
		// System.out.println("ahi");

		move_update();
		attack_update();
		checkAttack();
		update();
		move();

		// System.out.println("akaaaaaa");
		// checkAttack();
	}

	private void move_update() {
		player_up.update();
		player_down.update();
		player_left.update();
		player_right.update();
	}

	private void attack_update() {
		attack_up.update();
		attack_down.update();
		attack_right.update();
		attack_left.update();
	}

	private void update() { // update vi tri
		moveX = 0.f;
		moveY = 0.f;
		if (game.getKeyaction().up)
			if (y > 0)
				moveY = -3.5f;
		if (game.getKeyaction().down)
			if (y < GameStart.MAX_HEIGHT - 32)
				moveY = 3.5f;
		if (game.getKeyaction().left)
			if (x > 0)
				moveX = -3.5f;
		if (game.getKeyaction().right)
			if (x < GameStart.MAX_WIDTH - 32)
				moveX = 3.5f;
		if (game.getKeyaction().attack) {
			isAttack = true;
		}
		// else isAttack=false;
	}

	public boolean isAttack() {
		return isAttack;
	}

	public int getDamage() {
		return this.damage;
	}

	private boolean checkAttack() {
		time += System.currentTimeMillis() - lasttime;

		if (isAttack && (time >= cooldown)) {
			time = 0;
			lasttime = System.currentTimeMillis();
			return true;
		}
		return false;
	}

	private boolean checkTime() {
		time = System.currentTimeMillis() - lasttime;
		if (time > cooldown) {

			time = 0;
			System.out.println(lasttime);
			lasttime = System.currentTimeMillis();
			return true;
		}
		return false;
	}

	private void Time_attack() {

		if (isAttack == false)
			return;

		if (dem < Texture.getLengthBufferedImage(Texture.attack_right) * 5)
			return;

		System.out.println("hetime");
		if (checkTime()) {
			isAttack = true;
			dem = 0;
		} else
			isAttack = false;
	}

	public void die() {
		System.out.println("YOU LOSE");
	}

	public void drawLeft(Graphics g) {
		if (!isAttack)
			g.drawImage(player_left.getCurrentImage(Texture.player_left), (int) x, (int) y, width, height, null);
		else {
			g.drawImage(attack_left.getCurrentImage(Texture.attack_left), (int) x, (int) y, width, height, null);
			dem++;
		}
		previous_state = 1;
	}

	public void drawRight(Graphics g) {
		if (!isAttack)
			g.drawImage(player_right.getCurrentImage(Texture.player_right), (int) x, (int) y, width, height, null);
		else {

			g.drawImage(attack_right.getCurrentImage(Texture.attack_right), (int) x, (int) y, width, height, null);
			dem++;
		}
		previous_state = 2;
	}

	public void drawUp(Graphics g) {
		if (!isAttack)
			g.drawImage(player_up.getCurrentImage(Texture.player_up), (int) x, (int) y, width, height, null);
		else {
			g.drawImage(attack_up.getCurrentImage(Texture.attack_up), (int) x, (int) y, width, height, null);
			dem++;
		}
		previous_state = 3;
	}

	public void drawDown(Graphics g) {
		if (!isAttack)
			g.drawImage(player_down.getCurrentImage(Texture.player_down), (int) x, (int) y, width, height, null);
		else {
			g.drawImage(attack_down.getCurrentImage(Texture.attack_down), (int) x, (int) y, width, height, null);
			dem++;
		}
		previous_state = 4;
	}
	public void hurt(int damage) {
		// System.out.println("dau ");
		health -= damage;
		if (health <= 0) {
			dead = true;
			die();
		}
	}

	@Override
	public void render(Graphics g) {
		Time_attack();
		rect = new Rectangle((int)this.getX(),(int)this.getY(),width,height);

		// g.fillRect((int) x, (int) y, 32, 32);
		if (moveX == 0 && moveY == 0) {
			if (previous_state == 0) {
				drawRight(g);
			}
			if (previous_state == 1)
				drawLeft(g);
			if (previous_state == 2)
				drawRight(g);
			if (previous_state == 3)
				drawUp(g);
			if (previous_state == 4)
				drawDown(g);
		}
		if (moveX < 0) {
			drawLeft(g);
		}
		if (moveX > 0) {
			drawRight(g);
		}
		if (moveY < 0) {
			drawUp(g);
		}
		if (moveY > 0) {
			drawDown(g);
		}
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y - 4, 30, 4);
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y - 4, health / 10, 4);

		// ve bound quanh player

	}
	public Rectangle getRectangle() {
		return this.rect;
	}

}