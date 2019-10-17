package cn.sxt.game;


import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class MyGameFrame extends Frame {

    Image planeImg = GameUtil.getImage("images/plane.png");
    Image background = GameUtil.getImage("images/屏幕快照 2019-09-03 11.18.34.png");

    Plane plane = new Plane(planeImg,250,250);
    shell Shell = new shell();
    shell [] Shells = new shell[40];
    Explode bao;
    Date startTime = new Date();
    Date endTime;
    int period; //游戏时间


    //双缓冲解决闪烁问题
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.Game_Width,Constant.Game_Length);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics pen){

        pen.drawImage(background,0,0,null);

        plane.drawSelf(pen);
        Shell.draw(pen);
        for (int i = 0; i <Shells.length; i++ ){
            Shells [i].draw(pen);

            boolean crash = Shells[i].getRect().intersects(plane.getRect());
            if(crash){
                plane.live = false;
                if (bao == null) {
                    bao = new Explode(plane.x, plane.y);

                    endTime = new Date();
                    period = (int)((endTime.getTime() - startTime.getTime())/1000);


                }
                bao.draw(pen);
            }
            if(!plane.live){
                pen.setColor(Color.BLUE);
                Font f = new Font("宋体", Font.BOLD, 50);
                pen.setFont(f);
                pen.drawString("Time: "+period, (int)plane.x,(int)plane.y);
            }
        }


    }


    class PaintThread extends Thread {

        @Override
        public void run(){
            while (true){
                repaint(); //重画

                try {
                    Thread.sleep(35); // 1s = 1000ms， 每秒25下即为动画效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    // 定义键盘内部类
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }
    //初始化窗口
    public void lauchFrame(){
        this.setTitle("袁海力作品");
        this.setVisible(true);
        this.setSize(Constant.Game_Width,Constant.Game_Length);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

        new PaintThread().start(); //启动重画
        addKeyListener(new KeyMonitor()); //增加键盘监听

        // 50 shells
        for (int i = 0; i <Shells.length; i++ ){
            Shells [i] = new shell();
        }

    }

    public static void main(String[] args) {
        MyGameFrame game = new MyGameFrame();
        game.lauchFrame();
    }
}
