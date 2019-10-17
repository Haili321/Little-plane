package cn.sxt.game;

import java.awt.*;

/**
 * 游戏物体的父类
 *
 *
 */
public class GameObject {
    Image img;
    double x,y;
    int speed,width,height;


    public void drawSelf(Graphics pen){
        pen.drawImage(img,(int)x,(int)y,null);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }
    public GameObject(){

    }
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }

}
