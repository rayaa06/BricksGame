/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks;
import javax.swing.*;
import java.awt.*;

public class BallPanel_ extends JPanel {
    private final Image img;
    private int xCoord;
    private int yCoord;
    private Dimension preferredSize;

    private boolean dirXRight = true;
    private boolean dirYDown = true;
    BallPanel_(){
        this.img = new ImageIcon(getClass().getResource("/resources/ball.png")).getImage();
        this.xCoord = 600;
        this.yCoord = 300;
        this.preferredSize = new Dimension(30,30);
    }

    public void left() {
        xCoord -= 5;
        repaint();
    }
    public void right() {
        xCoord += 5;
        repaint();
    }
    public void up() {
        yCoord -= 5;
        repaint();
    }
    public void down() {
        yCoord += 5;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.drawImage(img, xCoord, yCoord, this);
    }

    public void move() throws InterruptedException {

        int width = 1026;
        int height = 630;

        while(true) {

            if((dirXRight && xCoord+125>width) || (!dirXRight && xCoord-125<0))
                dirXRight=!dirXRight;

            if((dirYDown && yCoord+125>height) || (!dirYDown && yCoord-125<0))
                dirYDown=!dirYDown;


            if(dirXRight)
                right();
            else
                left();

            if(dirYDown)
                down();
            else
                up();

            Thread.sleep(50);
        }
    }
}
