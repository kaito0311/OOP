package Api;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;


public class knight extends NPC{

    private Animation darkKinght;

    public knight(float x, float y, int width, int height) {
        super(x, y, width, height);
        R = 50.0;

        darkKinght = new Animation(Texture.Knight,200);


         
    }

    public void setRannddomCenter()
    {
        Center_x = ThreadLocalRandom.current().nextInt(1, 300);
        Center_y = ThreadLocalRandom.current().nextInt(1, 300);
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
        if(moveX > 0)
        {
            g.drawImage(darkKinght.getCurrentImage(Texture.Knight), (int)x,(int)y, width,height,null);
        }
        else
        {
            g.drawImage(darkKinght.getCurrentImage(Texture.Knight), (int)x+ width,(int)y, -width,height,null);
        }
        
    }

    @Override
    protected void update_move() {
        if (System.currentTimeMillis() - time_npc_move > 3000 || !check_index(this.x, this.y)) {
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
