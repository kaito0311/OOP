package api.creature;

import java.awt.Graphics;

public class Player extends Creature{

	
	
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(){
		
	}
	
	private void Input() {
		moveX = 0;
		moveY = 0;
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
