package Api;

import java.awt.Graphics;






import Application.Game;
public class Bom extends Entity{
    private boolean attack;
    private Game game;
    private Animation bom;
    public Bom(Game game, float x, float y, int width, int height)
    {
        super(x,y,width,height);
        this.game = game;
        bom = new Animation(Texture.bom_bum,100);
    }

    public void setToado(float x, float y)
    {
        this.x = x; 
        this.y = y;
    }

    @Override
    public void tick() {

        
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(bom.getCurrentImage(Texture.bom_bum),(int) x,(int) y, width, height, null);
        
    }

}

