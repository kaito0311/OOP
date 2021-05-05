package Api.creature;


import java.awt.Graphics;

import Api.Animation;
import Api.Texture;
import Application.Game;

public class Player extends Creature{
    private boolean isAttack=false;   
	private Game game;
	private Animation player_up,player_down,player_right,player_left;
	private Animation attack_up,attack_down,attack_right,attack_left;
	private long cooldown=5000,time=5000,lasttime=0;  // thoi gian delay don danh , thoi gian do khoang cach 2 la
	public Player(Game game,float x, float y, int width, int height) {
		super(x, y, width, height);
		this.game=game;
		player_up= new Animation(Texture.player_up,300);
	    player_down= new Animation(Texture.player_down,300);
		player_left= new Animation(Texture.player_left,300);
		player_right= new Animation(Texture.player_right,300);

		attack_up = new Animation(Texture.attack_up,500);
		attack_down = new Animation(Texture.attack_down,500);
		attack_left = new Animation(Texture.attack_left,500);
		attack_right = new Animation(Texture.attack_right,500);
		
		
	}
	
	@Override
	public void tick(){
		
		move_update();
		attack_update();checkAttack();
		update();
		move();
//		checkAttack();
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
		if(game.getKeyaction().attack)
			{
			isAttack=true;
			}
	//	else isAttack=false;
		}
	
    private boolean checkAttack() {
    	time+=System.currentTimeMillis()-lasttime;
    	
    	if(isAttack&&(time >= cooldown))
    	{
    		time=0;
    		lasttime=System.currentTimeMillis();
    		return true;
    	}
     return false;
    }
	
	
	@Override
	public void render(Graphics g) {
		if(moveX==0&&moveY==0) {
			if(!isAttack)
			g.drawImage(player_right.getCurrentImage(Texture.player_right),(int)x, (int)y,width,height, null);
			else
				g.drawImage(attack_right.getCurrentImage(Texture.attack_right), (int)x,(int)y, width,height, null);
			}
		if(moveX<0){
			if(!isAttack)
			g.drawImage(player_left.getCurrentImage(Texture.player_left),(int)x, (int)y,width,height, null);
			else
				g.drawImage(attack_left.getCurrentImage(Texture.attack_left), (int)x,(int)y, width,height, null);
			} 
		if(moveX>0){
			if(!isAttack)
			g.drawImage(player_right.getCurrentImage(Texture.player_right),(int)x, (int)y,width,height, null);
			else
				g.drawImage(attack_right.getCurrentImage(Texture.attack_right), (int)x,(int)y, width,height, null);
			}
		if(moveY<0){
			if(!isAttack)
			g.drawImage(player_up.getCurrentImage(Texture.player_up),(int)x, (int)y,width,height, null);
			else
				g.drawImage(attack_up.getCurrentImage(Texture.attack_up), (int)x,(int)y, width,height, null);
			} 
		if(moveY>0){
			if(!isAttack)
			g.drawImage(player_down.getCurrentImage(Texture.player_down),(int)x, (int)y,width,height, null);
			else
				g.drawImage(attack_down.getCurrentImage(Texture.attack_down), (int)x,(int)y, width,height, null);
			} 
		
		
	}

	
	
}