package bricks;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovingBall extends JPanel {
    private final Image img;
    private int BallX;
    private int BallY;
    private Dimension preferredSize;

    private boolean dirXRight = true;
    private boolean dirYDown = true;
    MovingBall(){
        this.img = new ImageIcon("resources/Red-Ball-PNG.png").getImage();
        this.BallX = -1;
        this.BallY = -1;
        this.preferredSize = new Dimension(300,200);
    }

    public void left() {
        BallX -= 5;
        repaint();
    }
    public void right() {
        BallX += 5;
        repaint();
    }
    public void up() {
        BallY -= 5;
        repaint();
    }
    public void down() {
        BallY += 5;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(img, BallX, BallY, this);
    }

    public void move()  {

        int width = 400;
        int height = 400;

        while(true) {

            if((dirXRight && BallX+125>width) || (!dirXRight && BallX-125<0))
                dirXRight=!dirXRight;

            if((dirYDown && BallY+125>height) || (!dirYDown && BallY-125<0))
                dirYDown=!dirYDown;


            if(dirXRight)
                right();
            else
                left();

            if(dirYDown)
                down();
            else
                up();

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(MovingBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

