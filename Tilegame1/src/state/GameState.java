package state;

import java.awt.Graphics;

import Api.creature.Boss;
import Api.creature.Player;
import Application.Game;

public class GameState {
   private Game game;
   private Player player;
   private Boss boss;
   public GameState(Game game) {
	   this.game=game;
	   player= new Player(game,100,100,32,32);
      boss = new Boss(game, 150,150,70,60, player);
      

   }




   public void update() {
      // System.out.println("loi");
	   player.tick();
      boss.tick();
   }
   public void render(Graphics g) {
	   player.render(g);
      boss.render(g);
   }
}
