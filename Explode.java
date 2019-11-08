package cn.sxt.game;
import java.awt.Graphics;
import java.awt.Image;

public class Explode {
    double x,y;
    static Image[] imgs = new Image[16];
    static {
        for(int i=0;i<16;i++){
            imgs[i] = GameUtil.getImage("images/explode/e"+(i)+".gif"); // 这里gif格式很重要！！！
            // it's very improtant to use gif form
            imgs[i].getWidth(null);
            imgs[i].getHeight(null);
        }
    }

    int count= 0;

    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(imgs[count], (int)x, (int)y, null);
            count++;
        }
    }

    public Explode(double x,double y){
        this.x = x;
        this.y = y;
    }
}
