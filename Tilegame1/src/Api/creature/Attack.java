package Api.creature;

// import java.awt.Color;
import java.awt.Graphics;

import Api.Animation;
import Api.Entity;
import Api.Texture;
import Application.Game;
import java.awt.Rectangle;

public class Attack extends Entity {
    // private Game game;
    private Animation attack;
    private float moveX, moveY;
    private int dem;
    private boolean flip;
    private boolean isBreak;

    public Attack(Game game, float x, float y, int width, int height, int dem) {
        super(game, x, y, width, height);

        attack = new Animation(Texture.fire_attack, 50);
        this.dem = dem;
        flip = false;
        isBreak = false;
    }

    public void setToado(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public int checkDistance(float index_x, float index_y) {
        Rectangle a = new Rectangle((int) index_x, (int) index_y, 32, 32);
        Rectangle b = new Rectangle( (int) (x - width / 2) + 30, (int) (y - height / 2)+ 45, 110,100);
        if (a.intersects(b))
            return 0;
        else
            return 1000;

    }

    public int checkR() {
        if (attack.getIndex() > 5 && attack.getIndex() <= 20) {
            return 40 + (attack.getIndex() - 5) * 5;
        }
        return 10;
    }

    public boolean checkAttack(float x, float y) {
        if (isBreak)
            return false;
        // System.out.println(checkDistance( x, y) + " " + checkR());
        if (checkDistance(x, y) < checkR()) {
            return true;
        }
        return false;

    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public void setRoad(float player_x, float player_y) {

        if (player_y > this.y)
            flip = true;
        else
            flip = false;
        moveX = (player_x - this.x) / attack.getImageLength() * 1.0f;
        moveY = (player_y - this.y) / attack.getImageLength() * 1.0f;
        // System.out.println(moveX + " " + moveY);
    }

    @Override
    public void tick() {
        x += moveX;
        y += moveY;
        attack.setIndex(dem);
        attack.update();
    }

    public void setIsBreak(boolean set) {
        isBreak = set;
    }

    public void setIndexAttack(int dem) {
       this.dem = dem;
    }

    @Override
    public void render(Graphics g) {
        // System.out.println("loi");
        // Rectangle b = new Rectangle( (int) (x - width / 2), (int) (y - height / 2), 192,192);
        // g.setColor(Color.BLUE);
        // g.fillRect( (int) (x - width / 2) + 30, (int) (y - height / 2)+ 50, 110,100);

        if (!flip)
            g.drawImage(attack.getCurrentImage(Texture.fire_attack), (int) (x - width / 2), (int) (y - height / 2), 192,
                    192, null);
        else
            g.drawImage(attack.getCurrentImage(Texture.fire_attack), (int) (x - width / 2),
                    (int) (y - height / 2) + height, 192, -192, null);

    }

}
