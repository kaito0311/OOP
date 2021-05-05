package Api.creature;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Api.Animation;
import Api.Texture;
import Application.Game;

public class Player extends Creature{

	private int cooldown;   // thoi gian delay don danh
	private Game game;
	private Animation player_up,player_down,player_right,player_left;
	public Player(Game game,float x, float y, int width, int height) {
		super(x, y, width, height);
		this.game=game;
		player_up= new Animation(Texture.player_up,300);
	    player_down= new Animation(Texture.player_down,300);
		player_left= new Animation(Texture.player_left,300);
		player_right= new Animation(Texture.player_right,300);
	}
	
	@Override
	public void tick(){
		
		player_up.update();
		player_down.update();
		player_left.update();
		player_right.update();
		update();
		move();
		
	}
	
	private void update() {                         // update vi tri
		moveX = 0.f;
		moveY = 0.f;
		if(game.getKeyaction().up) 
			moveY=-3.5f;
		if(game.getKeyaction().down)
			moveY=3.5f;
		if(game.getKeyaction().left)
			moveX=-3.5f;
		if(game.getKeyaction().right)
			moveX=3.5f;
		
	}

	
	
	@Override
	public void render(Graphics g) {
		if(moveX==0&&moveY==0)
			g.drawImage(player_down.getCurrentImage(Texture.player_down),(int)x, (int)y,width,height, null);
		if(moveX<0) 
			g.drawImage(player_left.getCurrentImage(Texture.player_left),(int) x,(int) y,width,height, null);
		if(moveX>0) 
			g.drawImage(player_right.getCurrentImage(Texture.player_right),(int)x, (int)y,width,height, null);
		if(moveY<0) 
			g.drawImage(player_up.getCurrentImage(Texture.player_up),(int)x, (int)y,width,height, null);
		if(moveY>0) 
			g.drawImage(player_down.getCurrentImage(Texture.player_down),(int)x, (int)y,width,height, null);
		
		
	}
//	public BufferedImage getCurrentState() {
//		if(moveX<0)
//			return player_left.getCurrentImage(Texture.player_left);
	
	
}