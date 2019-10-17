package cn.sxt.game;
import java.awt.Color;
import java.awt.Graphics;

public class shell extends GameObject {
    double degree;

    public shell(){
        degree = Math.random()*Math.PI*2;  //random 生成0～1
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 3;
    }

    public void draw(Graphics g){
        //将外部传入对象g的状态保存好(画笔)
        Color c = g.getColor();
        g.setColor(Color.yellow);

        g.fillOval((int)x, (int)y, width, height);

        //炮弹沿着任意角度飞行
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        if (x<0||x>Constant.Game_Width - 10){
            degree = Math.PI - degree;
        }
        if (y<20||y>Constant.Game_Length-10){
            degree = -degree;
        }
        g.setColor(c);
    }
}
