package Api.creature;

import Api.Entity;
import java.awt.Rectangle;

public class attack_real {
    private Entity target;
    private Entity source;

    public boolean attack(Creature target, Entity source, int damage)
    {
        // System.out.println("hmmm");
        
        if(source.getRect().intersects(target.getRect()))
        {
            
            target.hurt(damage);
            return true;
        }
        return false;
    }

}
/*abstract
 Rectangle a = new Rectangle((int) index_x, (int) index_y, 32, 32);
        Rectangle b = new Rectangle( (int) (x - width / 2) + 30, (int) (y - height / 2)+ 45, 110,100);
        if (a.intersects(b))
            return 0;
        else
            return 1000;*/