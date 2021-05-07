package nature;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import Api.Entity;
import Api.Texture;
import Api.Tile;

public class Tree extends Tile{
//	id = 16
	private boolean isBigTree;
	private static Image[] trees;
	private int id;
	
	public Tree() {
		super(trees, 0, 0);
		init();
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void update() {
		
	}
	public void init() {
		trees = new Image[4];
		for(int i = 0; i < 4;i++) {
			trees[i] = Texture.getTexture("tree_"+(i+1));
		}
	}
	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(trees[id-1], x*32, y*32, null);
	}

}
