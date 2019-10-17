package cn.sxt.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    boolean left, up ,right,down;
    boolean live = true;

    public int speed = 5;
    public void drawSelf(Graphics pen) {
        if (live) {
            pen.drawImage(img, (int) x, (int) y, null);


            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
        }else {

        }

    }


    public Plane(Image img, double x, double y){
        this.img = img;
        this.x = x;
        this.y= y;
        this.speed = 5;
        this.width = img.getWidth(null)-50;
        this.height = img.getHeight(null)-50;
    }

    public void addDirection(KeyEvent e){
         switch (e.getKeyCode()){
             case 37:
                 left=true;
                 break;
             case 38:
                 up=true;
                 break;
             case 39:
                 right=true;
                 break;
             case 40:
                 down=true;
                 break;
         }

    }
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()) {
            case 37:
                left = false;
                break;
            case 38:
                up = false;
                break;
            case 39:
                right = false;
                break;
            case 40:
                down = false;
                break;
        }
    }
}
