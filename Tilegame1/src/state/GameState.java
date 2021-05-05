package state;

import java.awt.Graphics;

import Api.creature.Player;
import Application.Game;

public class GameState {
   private Game game;
   private Player player;
   public GameState(Game game) {
	   this.game=game;
	   player= new Player(game,0,0,32,32);
   }
   public void update() {
	   player.tick();
   }
   public void render(Graphics g) {
	   player.render(g);
   }
}
