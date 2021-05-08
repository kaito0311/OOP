// chuyen nguyen sang (Tan minh)

package Api;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import Application.Game;

import java.awt.image.BufferedImage;



public class knight extends NPC{

    private Animation darkKinght;
    private BufferedImage[] Image;
    // protected Game game;

    public knight(Game game,float x, float y, int width, int height) {
        super(game,x, y, width, height);
        R = 50.0;
        time_npc_move =0;

       


         
    }

    public void setRannddomCenter()
    {
        Center_x = ThreadLocalRandom.current().nextInt(1, 300);
        Center_y = ThreadLocalRandom.current().nextInt(1, 300);
    }

    public void setAnimationImage(BufferedImage[] Image)
    {
        this.Image = Image;
        darkKinght = new Animation(Image,200);
    }
    public BufferedImage[] getImage()
    {
        return Image;
    }
    public Animation getAnimationImage()
    {
        return darkKinght;
    }




    @Override
    public void tick() {
        darkKinght.update();
        update_move();
        attack_update();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getAnimationImage().getCurrentImage(getImage()), (int)x, (int)y, 32,32,null);
        
    }

    @Override
    protected void update_move() {
        if (System.currentTimeMillis() - time_npc_move > 1000 || !check_index(this.x, this.y)) {
            time_npc_move = System.currentTimeMillis();
            // rand = Math.random();
            if (ThreadLocalRandom.current().nextInt(1, 100) < 50) {
                setMoveX();
            } else {
                setMoveY();
            }
        }
    }

    @Override
    protected void attack_update() {

        
    }

    
}
