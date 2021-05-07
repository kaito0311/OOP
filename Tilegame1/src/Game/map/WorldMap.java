package Game.map;

public class WorldMap {
	private Map worldMap[];
	private Map temp;
	
	public WorldMap() {
		worldMap = new Map[3];
		this.AddMap();
	}
	
	public Map getMap(int i) {
		return worldMap[i];
	}
	
	public void AddMap() {
		worldMap[0] = new Map("src/assets/map.txt");
		worldMap[1] = new Map("src/assets/map2.txt");
	}
}