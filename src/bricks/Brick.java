package bricks;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Brick extends JLabel {
    ImageIcon icon;
        int points;
        int x;
        int y;
        int width, height;

    Brick() {
        x=0;
        y=0;
        width=50;
        height=25;
        points=10;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Brick(ImageIcon icon, int points, int x, int y) {
        this.icon = icon;
        this.points = points;
        this.x = x;
        this.y = y;
    }

        
        
}
