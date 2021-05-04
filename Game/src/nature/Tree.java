package nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import api.Entity;
import api.Texture;

public class Tree extends Entity{
//	id = 16
	private Random rd;
	int index;
	private Image[] tree = {Texture.getTexture("tree_1"),Texture.getTexture("tree_2"),
			Texture.getTexture("tree_3")};
	
	public Tree() {
		rd = new Random();
	}
	
	public void setTree(int x,int y) {
		index = rd.nextInt(2);
		this.x = x;
		this.y = y;
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tree[index],  (int)(32 * x), (int)(32 *y), null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
