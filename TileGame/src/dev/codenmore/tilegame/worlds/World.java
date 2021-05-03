package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.*;


public class World {

	
	private int width, height;
	private int[][] tiles;
	private int spawnX, spawnY;
	private Game game; 
	
	public World(Game game,String path)
	{
		loadWorld(path);
		this.game = game; 
	}
	
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		int xStart = 0; 
		int xEnd = 0; 
		int yStart = 0; 
		int yEnd = 0 ; 
		for(int y =0; y < height; y++)
		{
			for(int x = xStart; x < xEnd; x ++)
			{
				getTile(x, y).render(g,(int) (x*Tile.TILEWIDTH - game.getGameCamera().getxOffset()),(int)(y* Tile.TILEHEIGHT - game.getGameCamera().getyOffset() ));
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		Tile t = Tile.tiles[tiles[x][y]];
		if(t== null)
			return Tile.dirtTile;
		return t;
	}
	private void loadWorld(String path)
	{
		String file = Utils.loadFileStringAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++)
		{
			for(int x =0; x < width; x++)
			{
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
		
		
		
		
	}
}
