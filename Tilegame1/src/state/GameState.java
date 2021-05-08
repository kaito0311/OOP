// sua vai cho :)) (Tan minh )

package state;

import java.awt.Graphics;

import Api.Knights;
import Api.creature.Boss;
import Api.creature.Player;
import Application.Game;

public class GameState {
   private Game game;
   private Player player;

   // Minh sua 
   private Boss boss;
   private Knights quai;
   // end 

   public GameState(Game game) {
	   this.game=game;
	   player= new Player(game,96,96,32,32);

      // Minh sua 
      // boss = new Boss(game, 400,400,105,90, player);
   
      // quai = new Knights(game,10);
      // 
   }
   public void update() {
	   player.tick();

      // Minh sua 
      // boss.tick();
      // quai.tick();
      // end 
   }
   public void render(Graphics g) {
	   player.render(g);

      // Minh sua 
      // quai.render(g);
      // boss.render(g);
      // end 
   }
}
