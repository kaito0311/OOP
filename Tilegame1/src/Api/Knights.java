package Api;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
public class Knights {
    private knight[] npc;
    private int count_NPC;

    public  Knights(int count_NPC)
    {
        this.count_NPC = count_NPC;
        npc = new knight[count_NPC];

        init();

    }

    public void init()
    {
        float center_x,center_y ; 
        for(int i = 0; i< count_NPC; i++)
        {
            
            center_x = ThreadLocalRandom.current().nextInt(1, 300);
            center_y = ThreadLocalRandom.current().nextInt(1,300);
            npc[i] = new knight(center_x, center_y, 35, 35);
            npc[i].setCenter_x(center_x);
            npc[i].setCenter_y(center_y);

        }
    }
    public void tick()
    {
        for (int i = 0; i< count_NPC; i++)
        {
            npc[i].tick();
        }
    }

    public void render(Graphics g)
    {
        for(int i =0; i< count_NPC; i++)
        {
            npc[i].render(g);
        }
    }

}
