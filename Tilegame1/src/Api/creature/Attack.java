package Api.creature;

import java.awt.Graphics;

import Api.Animation;
import Api.Entity;
import Api.Texture;
import Application.Game;

public class Attack extends Entity {
    private Game game;
    private Animation attack;
    private float moveX, moveY;
    private int dem ;

    public Attack(Game game,float x, float y, int width, int height , int dem)
    {
        super( x, y, width, height);
        this.game = game;
        attack = new Animation(Texture.fire_attack, 150);
        this.dem = dem;
    }

    public void setToado(float x, float y)
    {
        this.x = x; 
        this.y = y;
    }
    public void setDem(int dem)
    {
        this.dem = dem;
    }

    public void setRoad(float player_x, float player_y)
    {
        moveX = (player_x - this.x)/Texture.getLengthBufferedImage(Texture.fire_attack)*1.2f;
        moveY = (player_y - this.y)/Texture.getLengthBufferedImage(Texture.fire_attack)*1.2f;
        // System.out.println(moveX + " " + moveY);
    }

    @Override
    public void tick() {
        x += moveX; 
        y += moveY;
        attack.update();
    }

    public void setIndexAttack(int dem)
    {
        attack.setIndex(dem);
    }

    @Override
    public void render(Graphics g) {
        // System.out.println("loi");

        g.drawImage(attack.getCurrentImage(Texture.fire_attack),(int)(x -  width/2),(int)(y -height/2) , 192,192,null);
        
    }
    
}
