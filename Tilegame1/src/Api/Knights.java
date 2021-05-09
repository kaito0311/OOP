
// chuyen nguyen sang (Tan minh)
package Api;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import Api.creature.Player;
import Application.Game;

import java.awt.image.BufferedImage;

public class Knights {
    private knight[] npc;
    private int count_NPC;
    private Game game;
    private Player player;

    public Knights(Game game, Player player, int count_NPC) {
        this.count_NPC = count_NPC;
        npc = new knight[count_NPC];
        this.game = game;
        this.player = player;
        init();

    }

    private BufferedImage[] randomImage(int i) {
        if (i == 0)
            return Texture.bat;
        if (i == 1)
            return Texture.slime;
        if (i == 2)
            return Texture.spider;
        if (i == 3)
            return Texture.skeleton;
        return null;

    }

    public void init() {
        float center_x, center_y;
        for (int i = 0; i < count_NPC; i++) {

            center_x = ThreadLocalRandom.current().nextInt(1, 700);
            center_y = ThreadLocalRandom.current().nextInt(1, 590);
            npc[i] = new knight(game, player, center_x, center_y, 32, 32);
            npc[i].setCenter_x(center_x);
            npc[i].setCenter_y(center_y);
            npc[i].setAnimationImage(randomImage(i % 4));

        }
    }

    public NPC getNPC(int i) {
        return npc[i];
    }

    public int getcount_NPC() {
        return this.count_NPC;
    }

    public void tick() {
        for (int i = 0; i < count_NPC; i++) {
            if (npc[i] != null) {
                npc[i].tick();
                npc[i].player_attack(npc[i]);
                if (npc[i].isDead()) { // loai bo doi tuong khi chet khoi man hinh
                    npc[i] = null;
                }
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < count_NPC; i++) {
            if (npc[i] != null)
                npc[i].render(g);
        }
    }

}
