package nature;

import java.awt.Graphics;
import java.awt.Image;

import Api.Entity;
import Api.Texture;
import Api.Tile;

public class RoadSign extends Tile{
	private static Image[] roadSigns;
	private int id;
	
//	id from 1 to 15
	public RoadSign() {
		super(roadSigns, 0, 0); //ke di Tile hoi phe vat
		init();
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
	public void init() {
		roadSigns=new Image[4];
		roadSigns[1]=Texture.getTexture("roadSign_1");
		roadSigns[2]=Texture.getTexture("roadSign_2");
		roadSigns[3]=Texture.getTexture("roadSign_3");
		
	}
	

	public void render(Graphics g,int x,int y) {
		g.drawImage(roadSigns[id],(int) (32 * x),(int) (32 *y), null);
	}

	@Override
	public void update() {
		
	}
	
}
