package Game.map;

public class WorldMap {
	private Map worldMap[];
	private Map temp;
	
	public WorldMap() {
		worldMap = new Map[4];
		this.AddMap();
	}
	
	public Map getMap(int i) {
		return worldMap[i];
	}
	
	public void AddMap() {
		// Copy tu a Tuyen
		worldMap[0] = new Map("src/assets/map3.txt");
		worldMap[0].renderRect(1, 264, 350, 610);
		worldMap[1] = new Map("src/assets/map2.txt");
		worldMap[1].renderRect(320, 1, -99, -99);
		worldMap[2] = new Map("src//assets/map.txt");
		worldMap[2].renderRect(768, 383, -99, -99);
		// End
		
	}
}
