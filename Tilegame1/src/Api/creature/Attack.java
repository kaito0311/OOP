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
    private boolean flip ; 

    public Attack(Game game,float x, float y, int width, int height , int dem)
    {
        super(game,x, y, width, height);
        
        attack = new Animation(Texture.fire_attack, 150);
        this.dem = dem;
        flip = false;
    }

    public void setToado(float x, float y)
    {
        this.x = x; 
        this.y = y;
    }

    public int checkDistance(float index_x, float index_y)
    {
        double b = x ;
        double c =  y ;
        double a = Math.sqrt((index_x - b) * (index_x - b) + (index_y -c) * (index_y - c));
        // System.out.println(index_x + " " + index_y + " " + c  + " " + b +" " + attack.getIndex() );
        return (int)a;
        
    }

    public int checkR()
    {
        if(attack.getIndex()>= 5&& attack.getIndex() <= 18)
        {
            return 40 +( attack.getIndex() - 5) * 5;
        }
        return 10;
    }

    public boolean checkAttack(float x, float y)
    {
        // System.out.println(checkDistance( x, y) + " " + checkR());
        if(checkDistance(x,y) < checkR()) return true;
        return false;

    }
    public void setDem(int dem)
    {
        this.dem = dem;
    }

    public void setRoad(float player_x, float player_y)
    {
         
        if(player_y > this.y) flip = true;
        else flip = false;
        moveX = (player_x - this.x)/attack.getImageLength()*1.5f;
        moveY = (player_y - this.y)/attack.getImageLength()*1.5f;
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
        System.out.println(attack.getIndex());
        if(!flip) g.drawImage(attack.getCurrentImage(Texture.fire_attack),(int)(x -  width/2),(int)(y -height/2) , 192,192,null);
        else g.drawImage(attack.getCurrentImage(Texture.fire_attack),(int)(x -  width/2),(int)(y -height/2) + height,192,-192,null);
        
    }
    
}
