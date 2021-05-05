package Api;

import java.awt.image.BufferedImage;

public class Animation {
    private int index,deltatime;   // delta time là thoi gian xuat hien 1 hinh
    private BufferedImage[] Images;
    private long time,last_time;
    public Animation(BufferedImage[] Images,int deltatime) {
    	
        this.Images=Images;
        this.deltatime=deltatime;
        index=0;
    	time=0;
    	last_time=System.currentTimeMillis();
    }
    public void update() {
        time+= System.currentTimeMillis()-last_time;
        last_time=System.currentTimeMillis();
        if(time>deltatime) {
        	index++;
        	time=0;
        	if(index>=3)
        		index=0;
            }
        }
    public BufferedImage getCurrentImage(BufferedImage[] Images) {
    	return Images[index];
    } 
    
    
}
