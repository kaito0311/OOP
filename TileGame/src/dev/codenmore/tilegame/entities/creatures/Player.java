package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation aniDown;
	
	
	
	
//	private Game handler;

	public Player(Handler handler, float x, float y) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 2;
		bounds.y =10;
		bounds.width =15;
		bounds.height = 25;
		
		
		aniDown = new Animation(60, Assets.player_down);
		
	}

	@Override
	public void tick() {
		
		aniDown.tick();

		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}

	private void getInput()
	{
		xMove = 0; 
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(aniDown.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()) + width,(int)(y - handler.getGameCamera().getyOffset()), -width, height,null);
		// g.drawImage(aniDown.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()) ,(int)(y - handler.getGameCamera().getyOffset()), width, height,null);
//		g.setColor(Color.red);
//		g.fillRect((int)(x+ bounds.x-handler.getGameCamera().getxOffset()),
//				(int)(y+ bounds.y-handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height
//				);
	}

}
