package Game.map;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Api.Texture;
import nature.BigTree;
import nature.Chest;
import nature.ConcreteColumn;
import nature.Flower;
import nature.Grass;
import nature.Grave;
import nature.Lake;
import nature.Land;
import nature.Tree;
import nature.Water;

public class Map {
	private int map[][];
	private Lake lake;
	private Land land;
	private Tree tree;
	private Grass grass;
	private Water water;
	private Flower flower;
	private BigTree bigTree;
	private Grave grave;
	private Chest chest;
	private ConcreteColumn column;
	public Map(String path) {
		getMapFromFile(path);
		init();
	}
//	khoi tao cac doi tuong trong map
	public void init() {
		lake = new Lake();
		land = new Land();
		grass = new Grass();
		tree = new Tree();
		water = new Water();
		chest = new Chest();
		flower = new Flower();
		bigTree = new BigTree();
		column = new ConcreteColumn();
		grave=new Grave();
	}
//doc map tu ma tran
	public void getMapFromFile(String path){
		ArrayList<ArrayList<Integer>> map_ = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
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
					land.setId(map[i][j]);
					land.render(g, j, i);
				}else if(map[i][j] == 0){
					grass.render(g, j, i);
				}else if(map[i][j] == 18){
					grass.render(g, j, i);
					tree.render(g, j, i);
				} else if(map[i][j] >= 21 && map[i][j] <= 35) {
					grass.render(g, j, i);
					water.setId(map[i][j]-20);
					water.render(g, j, i);
				}else if(map[i][j] == 16){
					grass.render(g, j, i);
					flower.render(g, j, i);
				}else if(map[i][j] >= 41 && map[i][j] <= 56) {
					grass.render(g, j, i);
					bigTree.setId(map[i][j]-40);
					bigTree.render(g, j, i);
				}else if(map[i][j]==40||map[i][j]==39)
				{
					grass.render(g, j, i);
					grave.setId(map[i][j]-39);
					grave.render(g, j, i);
				}else{
					chest.setId(0);
					chest.render(g, j, i);
				}
			}
		}
	}
}
