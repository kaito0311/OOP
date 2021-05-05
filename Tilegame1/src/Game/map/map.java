package Game.map;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Api.Texture;
import nature.Flower;
import nature.Land;
import nature.Tree;
import nature.Water;

public class map {
	public int map[][];
	private Random rd;
	private Land land;
	private Tree tree;
	private Water water;
	private Flower flower;
	
	public map() {
		init();
	}
//	khoi tao cac doi tuong trong map
	public void init() {
		getMapFromFile();
		land = new Land();
		tree = new Tree();
		water = new Water();
		flower = new Flower();
	}
//doc map tu ma tran
	public void getMapFromFile(){
		ArrayList<ArrayList<Integer>> map_ = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/assets/map.txt"));
			String temp;
			while((temp = br.readLine()) != null) {
				String temp1[] = temp.trim().split(" ");
				if(temp.isEmpty()) {
					continue;
				}
				ArrayList<Integer> row = new ArrayList<>();
				for (String string : temp1) {
					int x = Integer.parseInt(string);
					row.add(x);
				}
				map_.add(row);
			}
			map = new int[map_.size()][map_.get(0).size()];
			
			for(int i = 0; i < map_.size();i++) {
				for(int j = 0; j < map_.get(0).size();j++) {
					map[i][j] = map_.get(i).get(j);
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			Texture.loadTextures();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	ve map
	public void render(Graphics g) {
		for(int i = 0; i < map.length;i++) {
			for(int j = 0; j < map[0].length;j++) {
				if(map[i][j] >= 1 && map[i][j] <= 15) {
					land.setLand("land_" +map[i][j], j, i);
					land.render(g);
				}else if(map[i][j] == 0){
					g.drawImage(Texture.getTexture("grass_0"), j*32, i*32, null);
				}else if(map[i][j] == 16){
					g.drawImage(Texture.getTexture("grass_0"), j*32, i*32, null);
					tree.setTree(j, i);
					tree.render(g);
				}else if(map[i][j] >= 21 && map[i][j] <= 35) {
					g.drawImage(Texture.getTexture("grass_0"), j*32, i*32, null);
					water.setWater("water_"+ (map[i][j] - 20), j, i);
					water.render(g);
				}else if(map[i][j] == 17){
					g.drawImage(Texture.getTexture("grass_0"), j*32, i*32, null);
					flower.setFlower(j, i);
					flower.render(g);
				}
			}
		}
	}
}
