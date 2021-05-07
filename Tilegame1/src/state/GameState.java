package state;

import java.awt.Graphics;

import Api.Knights;
import Api.knight;
import Api.creature.Boss;
import Api.creature.Player;
import Application.Game;

public class GameState {
   private Game game;
   private Player player;
   private Boss boss;
   private Knights quai;
   public GameState(Game game) {
	   this.game=game;
	   player= new Player(game,100,100,32,32);
      boss = new Boss(game, 150,150,70,60, player);
   
      quai = new Knights(10);

   }




   public void update() {
      // System.out.println("loi");
	   player.tick();
      boss.tick();
      quai.tick();
   }
   public void render(Graphics g) {
	   player.render(g);
      quai.render(g);
      boss.render(g);
   }
}
